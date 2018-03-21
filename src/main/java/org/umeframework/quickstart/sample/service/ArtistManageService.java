package org.umeframework.quickstart.sample.service;

import java.util.List;
import java.util.Map;

import org.umeframework.quickstart.sample.service.dto.AlbumDto;

/**
 * 艺术家管理服务组件接口定义。<br>
 * 
 * @author DORA
 */
public interface ArtistManageService {
	/**
	 * 查询多个艺术家的唱片信息。<br>
	 * 
	 * @param artists 艺术家列表
	 * @return 唱片总括信息描述对象集
	 */
	Map<String, List<AlbumDto>> queryAchievements(String... artists);

}
