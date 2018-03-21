
package org.umeframework.quickstart.sample.entity;

import java.io.Serializable;
import org.umeframework.dora.validation.constraints.Size;
import org.umeframework.dora.type.ColumnDesc;
import org.umeframework.dora.validation.constraints.NotEmpty;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Entity;
import org.umeframework.dora.type.TableDesc;
import javax.persistence.Id;
import org.umeframework.dora.bean.BeanUtil;
import org.umeframework.dora.service.TableEntity;

/**
 * Entity class map to table "唱片基本信息"
 *
 * @author ume-team
 */
@Entity
@Table(name="ALBUM_BASIC")
@TableDesc(label="唱片基本信息")
public class AlbumBasicDto extends TableEntity implements Serializable {
   /**
    * Default serial version code
    */
    private static final long serialVersionUID = 1L;

   /**
    * 编号 
    */
    @NotEmpty
    @Id
    @ColumnDesc(index=1, type="AUTO-INCREMENT", label="编号")
    @Column(name="ALBUM_CODE", nullable=false)
    private Long albumCode;

   /**
    * 标题 
    */
    @NotEmpty
    @Size(max=64)
    @ColumnDesc(index=2, type="VARCHAR", label="标题")
    @Column(name="ALBUM_TITLE", nullable=false, length=64)
    private String albumTitle;

   /**
    * 作者 
    */
    @NotEmpty
    @Size(max=64)
    @ColumnDesc(index=3, type="VARCHAR", label="作者")
    @Column(name="ALBUM_ARTIST", nullable=false, length=64)
    private String albumArtist;

   /**
    * 语种 
    */
    @NotEmpty
    @Size(max=16)
    @ColumnDesc(index=4, type="VARCHAR", label="语种")
    @Column(name="ALBUM_LANGUAGE", nullable=false, length=16)
    private String albumLanguage;

   /**
    * 发行时间 
    */
    @ColumnDesc(index=5, type="DATE", label="发行时间")
    @Column(name="ALBUM_ISSUE_DATE", nullable=true)
    private java.sql.Date albumIssueDate;

   /**
    * 出版商 
    */
    @Size(max=64)
    @ColumnDesc(index=6, type="VARCHAR", label="出版商")
    @Column(name="ALBUM_ISSUE_COMPANY", nullable=true, length=64)
    private String albumIssueCompany;

   /**
    * 风格 
    */
    @Size(max=16)
    @ColumnDesc(index=7, type="VARCHAR", label="风格")
    @Column(name="ALBUM_GENRE", nullable=true, length=16)
    private String albumGenre;

   /**
    * 封面设计 
    */
    @ColumnDesc(index=8, type="BLOB", label="封面设计")
    @Column(name="ALBUM_COVER_PHOTO", nullable=true)
    private java.sql.Blob albumCoverPhoto;

   /**
    * 备注 
    */
    @Size(max=128)
    @ColumnDesc(index=9, type="VARCHAR", label="备注")
    @Column(name="REMARK", nullable=true, length=128)
    private String remark;

   /**
    * Create Author (default setting while insert)
    */
    @ColumnDesc(index=(9 + 1), type="VARCHAR", label="createAuthor")
    @Column(name="CREATE_AUTHOR", nullable=true, length=32)
    private String createAuthor;
   /**
    * Create Datetime (default setting while insert)
    */
    @ColumnDesc(index=(9 + 2), type="TIMESTAMP", label="createDatetime")
    @Column(name="CREATE_DATETIME", nullable=true)
    private java.sql.Timestamp createDatetime;
   /**
    * Update Author (refresh on each update)
    */
    @ColumnDesc(index=(9 + 3), type="VARCHAR", label="updateAuthor")
    @Column(name="UPDATE_AUTHOR", nullable=true, length=32)
    private String updateAuthor;
   /**
    * Update Datetime (refresh on each update)
    */
    @ColumnDesc(index=(9 + 4), type="TIMESTAMP", label="updateDatetime")
    @Column(name="UPDATE_DATETIME", nullable=true)
    private java.sql.Timestamp updateDatetime;

    /**
     *　Get the "编号"
     */
    public Long getAlbumCode() {
        return this.albumCode;
    }
    /**
     *　Set the "编号"
     */
    public void setAlbumCode(
            Long albumCode) {
        this.albumCode = albumCode;
    }

    /**
     *　Get the "标题"
     */
    public String getAlbumTitle() {
        return this.albumTitle;
    }
    /**
     *　Set the "标题"
     */
    public void setAlbumTitle(
            String albumTitle) {
        this.albumTitle = albumTitle;
    }

    /**
     *　Get the "作者"
     */
    public String getAlbumArtist() {
        return this.albumArtist;
    }
    /**
     *　Set the "作者"
     */
    public void setAlbumArtist(
            String albumArtist) {
        this.albumArtist = albumArtist;
    }

    /**
     *　Get the "语种"
     */
    public String getAlbumLanguage() {
        return this.albumLanguage;
    }
    /**
     *　Set the "语种"
     */
    public void setAlbumLanguage(
            String albumLanguage) {
        this.albumLanguage = albumLanguage;
    }

    /**
     *　Get the "发行时间"
     */
    public java.sql.Date getAlbumIssueDate() {
        return this.albumIssueDate;
    }
    /**
     *　Set the "发行时间"
     */
    public void setAlbumIssueDate(
            java.sql.Date albumIssueDate) {
        this.albumIssueDate = albumIssueDate;
    }

    /**
     *　Get the "出版商"
     */
    public String getAlbumIssueCompany() {
        return this.albumIssueCompany;
    }
    /**
     *　Set the "出版商"
     */
    public void setAlbumIssueCompany(
            String albumIssueCompany) {
        this.albumIssueCompany = albumIssueCompany;
    }

    /**
     *　Get the "风格"
     */
    public String getAlbumGenre() {
        return this.albumGenre;
    }
    /**
     *　Set the "风格"
     */
    public void setAlbumGenre(
            String albumGenre) {
        this.albumGenre = albumGenre;
    }

    /**
     *　Get the "封面设计"
     */
    public java.sql.Blob getAlbumCoverPhoto() {
        return this.albumCoverPhoto;
    }
    /**
     *　Set the "封面设计"
     */
    public void setAlbumCoverPhoto(
            java.sql.Blob albumCoverPhoto) {
        this.albumCoverPhoto = albumCoverPhoto;
    }

    /**
     *　Get the "备注"
     */
    public String getRemark() {
        return this.remark;
    }
    /**
     *　Set the "备注"
     */
    public void setRemark(
            String remark) {
        this.remark = remark;
    }

    /**
     * Get the "Create Auther"
     */
    public String getCreateAuthor() {
        return createAuthor;
    }
    /**
     * Set the "Create Auther"
     */
    public void setCreateAuthor(
            String createAuthor) {
        this.createAuthor = createAuthor;
    }

    /**
     * Get the "Create Datetime"
     */
    public java.sql.Timestamp getCreateDatetime() {
        return createDatetime;
    }
    /**
     * Set the "Create Datetime"
     */
    public void setCreateDatetime(
            java.sql.Timestamp createDatetime) {
        this.createDatetime = createDatetime;
    }

    /**
     * Get the "Update Auther"
     */
    public String getUpdateAuthor() {
        return updateAuthor;
    }
    /**
     * Set the "Update Auther"
     */
    public void setUpdateAuthor(
            String updateAuthor) {
        this.updateAuthor = updateAuthor;
    }

    /**
     * Get the "Update Datetime"
     */
    public java.sql.Timestamp getUpdateDatetime() {
        return updateDatetime;
    }
    /**
     * Set the "Update Datetime"
     */
    public void setUpdateDatetime(
            java.sql.Timestamp updateDatetime) {
        this.updateDatetime = updateDatetime;
    }

    /**
     * Create bean instance copy with selected properties
     * 
     * @param selectProperties
     *            - properties which copy to new instance
     * @return
     */
    public AlbumBasicDto copyFrom(
            Property... selectProperties) {
        if (selectProperties == null) {
            return null;
        }
        AlbumBasicDto newInstance = new AlbumBasicDto();
        for (Property property : selectProperties) {
            String name = property.toString();
            Object value = BeanUtil.getBeanProperty(this, name);
            BeanUtil.setBeanProperty(newInstance, name, value);
        }
        return newInstance;
    }
    
    /**
     * Constant declare: SQL ID in config file
     */
    public static class SQLID {
        public static final String INSERT = "org.umeframework.quickstart.sample.entity.ALBUM_BASIC_INSERT"; 
        public static final String UPDATE = "org.umeframework.quickstart.sample.entity.ALBUM_BASIC_UPDATE"; 
        public static final String SMART_UPDATE = "org.umeframework.quickstart.sample.entity.ALBUM_BASIC_SMART_UPDATE"; 
        public static final String DELETE = "org.umeframework.quickstart.sample.entity.ALBUM_BASIC_DELETE"; 
        public static final String DELETE_ALL = "org.umeframework.quickstart.sample.entity.ALBUM_BASIC_DELETE_ALL"; 
        public static final String FIND = "org.umeframework.quickstart.sample.entity.ALBUM_BASIC_FIND"; 
        public static final String FIND_FOR_UPDATE = "org.umeframework.quickstart.sample.entity.ALBUM_BASIC_FIND_FOR_UPDATE"; 
        public static final String FIND_LIST = "org.umeframework.quickstart.sample.entity.ALBUM_BASIC_FIND_LIST"; 
        public static final String FIND_LIST_LIKE = "org.umeframework.quickstart.sample.entity.ALBUM_BASIC_FIND_LIST_LIKE"; 
        public static final String FIND_LIST_MATCH = "org.umeframework.quickstart.sample.entity.ALBUM_BASIC_FIND_LIST_MATCH"; 
        public static final String COUNT = "org.umeframework.quickstart.sample.entity.ALBUM_BASIC_COUNT";
    } 

    /**
     * Constant declare: entity property name.<br>
     */
    public static class Property {
        public static final String albumCode = "albumCode";
        public static final String albumTitle = "albumTitle";
        public static final String albumArtist = "albumArtist";
        public static final String albumLanguage = "albumLanguage";
        public static final String albumIssueDate = "albumIssueDate";
        public static final String albumIssueCompany = "albumIssueCompany";
        public static final String albumGenre = "albumGenre";
        public static final String albumCoverPhoto = "albumCoverPhoto";
        public static final String remark = "remark";
        public static final String createAuthor = "createAuthor";
        public static final String createDatetime = "createDatetime";
        public static final String updateAuthor = "updateAuthor";
        public static final String updateDatetime = "updateDatetime";
    }
    
    /**
     * Constant declare: column name map with bean property.<br>
     */
    public static class ColumnName {
        public static final String ALBUM_CODE = "ALBUM_CODE";
        public static final String ALBUM_TITLE = "ALBUM_TITLE";
        public static final String ALBUM_ARTIST = "ALBUM_ARTIST";
        public static final String ALBUM_LANGUAGE = "ALBUM_LANGUAGE";
        public static final String ALBUM_ISSUE_DATE = "ALBUM_ISSUE_DATE";
        public static final String ALBUM_ISSUE_COMPANY = "ALBUM_ISSUE_COMPANY";
        public static final String ALBUM_GENRE = "ALBUM_GENRE";
        public static final String ALBUM_COVER_PHOTO = "ALBUM_COVER_PHOTO";
        public static final String REMARK = "REMARK";
        public static final String CREATE_AUTHOR = "CREATE_AUTHOR";
        public static final String CREATE_DATETIME = "CREATE_DATETIME";
        public static final String UPDATE_AUTHOR = "UPDATE_AUTHOR";
        public static final String UPDATE_DATETIME = "UPDATE_DATETIME";
    }
    /**
     * Constant declare: table name.<br>
     */
    public static String TableName = "ALBUM_BASIC";

}
