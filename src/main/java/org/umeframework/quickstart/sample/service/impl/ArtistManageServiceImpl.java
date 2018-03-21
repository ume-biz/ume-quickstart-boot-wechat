package org.umeframework.quickstart.sample.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.umeframework.dora.service.BaseDBComponent;
import org.umeframework.quickstart.sample.message.MessageConst;
import org.umeframework.quickstart.sample.service.AlbumManageService;
import org.umeframework.quickstart.sample.service.ArtistManageService;
import org.umeframework.quickstart.sample.service.dto.AlbumDto;

/**
 * 艺术家服务组件的业务实现。<br>
 * 该组件继承自DORA框架的"BaseDBComponent"组件并实现业务接口"ArtistService"中定义的全部功能。<br>
 * 具体功能列表如下：<br>
 * <li>查询多个艺术家的唱片信息。<br>
 * 
 * @author ume-team
 */
@Service
public class ArtistManageServiceImpl extends BaseDBComponent implements ArtistManageService, MessageConst {
	/**
	 * AlbumService服务实例。<br>
	 */
	@Resource
	private AlbumManageService albumService;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ume.sample.service.ArtistService#getAchievements(java.lang.String[])
	 */
	@Override
	public Map<String, List<AlbumDto>> queryAchievements(String... artists) {
		// 抛出ApplicationException的范例
		if (artists == null) {
			super.createApplicationException(SAMPLE_MSG_005);
		}
		int maxQueryLimit = 3;
		if (artists.length > maxQueryLimit) {
			super.createApplicationException(SAMPLE_MSG_006, artists.length, maxQueryLimit);
		}
		
		Map<String, List<AlbumDto>> result = new HashMap<String, List<AlbumDto>>();
		for (String artist : artists) {
			List<AlbumDto> albumList = albumService.queryAlbumsByArtist(artist);
			if (albumList.size() > 0) {
				result.put(artist, albumList);
			}
			
			// 向Service上下文中假如消息的范例（Service执行完无异常发生时消息会作为ServiceResponse的成员返回至客户端）
			super.createMessage(SAMPLE_MSG_007, artist, albumList.size());
		}
		return result;
	}
}
