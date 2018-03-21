package org.umeframework.quickstart.sample.service.dto;

import java.util.List ;
import org.umeframework.quickstart.sample.entity.AlbumBasicDto ;

/**
 * AlbumDto 唱片总括信息描述结构对象
 * 该结构将如下实体表的信息整合后，返回给服务调用者。
- 唱片基本信息
- 唱片参与表演者
- 唱片曲目信息
 *
 * @author DORA.Generator
 */
public class AlbumDto implements java.io.Serializable {
   /**
    * Default serial version code
    */
    private static final long serialVersionUID = 1L;

   /**
    * basicInfo - 唱片基础信息。
    */
    private AlbumBasicDto basicInfo;
   /**
    * trackList - 唱片曲目列表。
    */
    private List<org.umeframework.quickstart.sample.entity.AlbumTrackDto> trackList;
   /**
    * contributorList - 唱片的参与艺术家列表
    */
    private List<org.umeframework.quickstart.sample.entity.AlbumContributorDto> contributorList;

   /**
    * Get the "唱片基础信息。"
    */
    public AlbumBasicDto getBasicInfo () {
        return this.basicInfo;
    }
   /**
    * Set the "唱片基础信息。"
    */
    public void setBasicInfo (
            AlbumBasicDto basicInfo) {
        this.basicInfo = basicInfo;
    }

   /**
    * Get the "唱片曲目列表。"
    */
    public List<org.umeframework.quickstart.sample.entity.AlbumTrackDto> getTrackList () {
        return this.trackList;
    }
   /**
    * Set the "唱片曲目列表。"
    */
    public void setTrackList (
            List<org.umeframework.quickstart.sample.entity.AlbumTrackDto> trackList) {
        this.trackList = trackList;
    }

   /**
    * Get the "唱片的参与艺术家列表"
    */
    public List<org.umeframework.quickstart.sample.entity.AlbumContributorDto> getContributorList () {
        return this.contributorList;
    }
   /**
    * Set the "唱片的参与艺术家列表"
    */
    public void setContributorList (
            List<org.umeframework.quickstart.sample.entity.AlbumContributorDto> contributorList) {
        this.contributorList = contributorList;
    }

}