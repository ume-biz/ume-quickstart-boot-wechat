package org.umeframework.quickstart.sample.service;

import java.util.List;
import org.umeframework.quickstart.sample.service.dto.AlbumDto;
import org.umeframework.quickstart.sample.entity.AlbumBasicDto;

/**
 * 唱片信息管理服务组件 <br>
 *   <br>
 *
 * @author DORA.Generator
 */
public interface AlbumManageService {

    /**
     * 根据唱片编码查询唱片信息 <br>
     *  <br>
     *
     * @param albumCode - 唱片编码
     * @return AlbumDto 唱片总括信息描述对象 
     */
    AlbumDto queryAlbumByCode ( Long albumCode );

    /**
     * 查询艺术家的唱片信息 <br>
     *  <br>
     *
     * @param artist - 艺术家
     * @return List<org.umeframework.quickstart.sample.service.dto.AlbumDto> 唱片总括信息描述对象 
     */
    List<org.umeframework.quickstart.sample.service.dto.AlbumDto> queryAlbumsByArtist ( String artist );

    /**
     * 根据多个输入条件查询符合条件的唱片信息 <br>
     *  <br>
     *
     * @param artist - 艺术家
     * @param album - 唱片查询条件
     * @return List<org.umeframework.quickstart.sample.service.dto.AlbumDto> 唱片总括信息描述对象 
     */
    List<org.umeframework.quickstart.sample.service.dto.AlbumDto> queryAlbumsByMultiCondition ( String artist , AlbumBasicDto album );

    /**
     * 更新唱片基础信息及详细信息 <br>
     *  <br>
     *
     * @param album - 唱片总括信息描述对象
     */
    void updateAlbum ( AlbumDto album );


}