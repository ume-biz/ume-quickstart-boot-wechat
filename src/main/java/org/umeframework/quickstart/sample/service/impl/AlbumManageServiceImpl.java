package org.umeframework.quickstart.sample.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.umeframework.dora.service.BaseDBComponent;
import org.umeframework.dora.util.DateUtil;
import org.umeframework.quickstart.sample.entity.AlbumBasicDto;
import org.umeframework.quickstart.sample.entity.AlbumContributorDto;
import org.umeframework.quickstart.sample.entity.AlbumTrackDto;
import org.umeframework.quickstart.sample.entity.crud.AlbumBasicCrudService;
import org.umeframework.quickstart.sample.entity.crud.AlbumContributorCrudService;
import org.umeframework.quickstart.sample.entity.crud.AlbumTrackCrudService;
import org.umeframework.quickstart.sample.message.MessageConst;
import org.umeframework.quickstart.sample.service.AlbumManageService;
import org.umeframework.quickstart.sample.service.dto.AlbumDto;

/**
 * 唱片信息管理服务组件的业务实现。<br>
 * 该组件继承自UME框架的"BaseDBComponent"组件并实现业务接口"AlbumService"中定义的全部功能。<br>
 * 
 * @author ume-team
 */
@Service
public class AlbumManageServiceImpl extends BaseDBComponent implements AlbumManageService, MessageConst {
	/**
	 * 唱片基本信息实体组件。<br>
	 */
	@Resource
	private AlbumBasicCrudService albumBasicService;
	/**
	 * 唱片曲目信息实体组件。<br>
	 */
	@Resource
	private AlbumTrackCrudService albumTrackService;
	/**
	 * 唱片参与表演者信息实体组件。<br>
	 */
	@Resource
	private AlbumContributorCrudService albumContributorService;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ume.sample.service.AlbumService#findAlbumByCode(java.lang.Long)
	 */
	@Override
	public AlbumDto queryAlbumByCode(Long albumCode) {
		// 根据传入的唱片编号，主键查询唱片基础信息
		AlbumBasicDto albumBasicParam = new AlbumBasicDto();
		albumBasicParam.setAlbumCode(albumCode);
		AlbumBasicDto albumBasic = this.albumBasicService.find(albumBasicParam);
		// AlbumBasicDto albumBasic = getDao().queryForObject(AlbumBasicDto.SQLID.FIND, albumCode, AlbumBasicDto.class);
		if (albumBasic == null) {
			super.createMessage(SAMPLE_MSG_002, albumCode);
			return null;
		}
		// 返回结果唱片信息的描述对象
		AlbumDto album = new AlbumDto();
		// 进行业务加工处理
		albumBasic.clearDefaultProperties();
		album.setBasicInfo(albumBasic);
		// 根据传入的唱片编号，查询唱片参与者信息
		AlbumContributorDto contributorParam = new AlbumContributorDto();
		contributorParam.setAlbumCode(albumCode);
		List<AlbumContributorDto> contributorList = this.albumContributorService.findList(contributorParam);
		// List<AlbumContributorDto> contributorList = getDao().queryForObjectList(AlbumContributorDto.SQLID.SEARCH, contributorParam, AlbumContributorDto.class);
		// 进行业务加工处理
		for (AlbumContributorDto contributor : contributorList) {
			contributor.clearDefaultProperties();
		}
		album.setContributorList(contributorList);
		// 查询唱片曲目信息
		AlbumTrackDto trackParam = new AlbumTrackDto();
		trackParam.setAlbumCode(albumCode);
		List<AlbumTrackDto> trackList = this.albumTrackService.findList(trackParam);
		// List<AlbumTrackDto> trackList = getDao().queryForObjectList(AlbumTrackDto.SQLID.SEARCH, trackParam, AlbumTrackDto.class);
		// 进行业务加工处理
		for (AlbumTrackDto track : trackList) {
			track.clearDefaultProperties();
		}
		album.setTrackList(trackList);
		return album;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ume.sample.service.AlbumService#findAlbumByArtist(java.lang.String)
	 */
	@Override
	public List<AlbumDto> queryAlbumsByArtist(String artist) {
		AlbumBasicDto queryParam = new AlbumBasicDto();
		queryParam.setAlbumArtist(artist);
		List<AlbumBasicDto> albumBasicList = this.albumBasicService.findList(queryParam);
		// List<AlbumBasicDto> albumBasicList = getDao().queryForObjectList(AlbumBasicDto.SQLID.SEARCH, queryParam, AlbumBasicDto.class);
		if (albumBasicList.size() == 0) {
			super.createMessage(SAMPLE_MSG_008, artist);
			return null;
		}
		List<AlbumDto> albumList = new ArrayList<AlbumDto>(albumBasicList.size());
		for (AlbumBasicDto albumBasic : albumBasicList) {
			AlbumDto e = queryAlbumByCode(albumBasic.getAlbumCode());
			albumList.add(e);
		}
		return albumList;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ume.sample.service.AlbumService#getAlbumsByMultiCondition(java.lang.String, com.ume.sample.entity.AlbumBasicDto)
	 */
	@Override
	public List<AlbumDto> queryAlbumsByMultiCondition(String artist, AlbumBasicDto album) {
		List<AlbumDto> albumList = new ArrayList<AlbumDto>();

		List<AlbumDto> result = this.queryAlbumsByArtist(artist);
		albumList.addAll(result);

		if (album != null) {
			List<AlbumBasicDto> albumBasicList = this.albumBasicService.findList(album);
			// List<AlbumBasicDto> albumBasicList = getDao().queryForObjectList(AlbumBasicDto.SQLID.SEARCH, album, AlbumBasicDto.class);
			for (AlbumBasicDto albumBasic : albumBasicList) {
				AlbumDto e = queryAlbumByCode(albumBasic.getAlbumCode());
				albumList.add(e);
			}
		}
		return albumList;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.umeframework.quickstart.sample.service.AlbumAccessService#updateAlbum(org.umeframework.quickstart.sample.service.dto.AlbumDto)
	 */
	@Override
	public void updateAlbum(AlbumDto album) {
		AlbumBasicDto albumBasic = album.getBasicInfo();
		// 更新前基础校验
		if (albumBasic.getAlbumCode() == null || albumBasic.getAlbumCode() < 0) {
			super.createApplicationException(SAMPLE_MSG_001, albumBasic.getAlbumCode());
		}
		// 更新前业务校验
		AlbumBasicDto exist = this.albumBasicService.find(albumBasic);
		// AlbumBasicDto exist = super.getDao().queryForObject(AlbumBasicDto.SQLID.FIND_FOR_UPDATE, albumBasic.getAlbumCode(), AlbumBasicDto.class);
		if (exist == null) {
			super.createApplicationException(SAMPLE_MSG_002, albumBasic.getAlbumCode());
		}

		String remark = DateUtil.dateToString(new java.util.Date(), DateUtil.FORMAT.YYYYMMDDHHMMSSHyphen);
		// 更新曲目列表
		List<AlbumTrackDto> trackList = album.getTrackList();
		if (trackList != null) {
			for (AlbumTrackDto track : trackList) {
				track.setRemark(remark);
				this.albumTrackService.update(track);
				// super.getDao().update(AlbumTrackDto.SQLID.SMART_UPDATE, track);
			}
		}
		// 更新参与者列表
		List<AlbumContributorDto> contributorList = album.getContributorList();
		if (contributorList != null) {
			for (AlbumContributorDto contributor : contributorList) {
				contributor.setRemark(remark);
				this.albumContributorService.update(contributor);
				// super.getDao().update(AlbumContributorDto.SQLID.SMART_UPDATE, contributor);
			}
		}
		// 更新唱片基础信息
		exist.setRemark(remark);
		this.albumBasicService.update(exist);
		// super.getDao().update(AlbumBasicDto.SQLID.SMART_UPDATE, albumBasic);
		// 根据需求返回消息给客户端
		super.createMessage(SAMPLE_MSG_003, exist.getAlbumCode() + ":" + exist.getAlbumArtist() + "-" + exist.getAlbumTitle());
	}

}
