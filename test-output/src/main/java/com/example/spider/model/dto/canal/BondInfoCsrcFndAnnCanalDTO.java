package com.example.spider.model.dto.canal;

import java.sql.Timestamp;
import java.sql.Date;
import java.sql.Timestamp;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 中国证券监督管理委员会基金公告-补充表CanalDTO对象
 *
 * @author xionglei
 */
public class BondInfoCsrcFndAnnCanalDTO {

    /**
     * 主键
     */
    @JsonProperty("id")
    private Long id;

    /**
     * task任务
     */
    @JsonProperty("origin")
    private String origin;

    /**
     * 创建时间
     */
    @JsonProperty("create_time")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Timestamp createTime;

    /**
     * 更新时间
     */
    @JsonProperty("update_time")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Timestamp updateTime;

    /**
     * 唯一记录标识MD5
     */
    @JsonProperty("md5_value")
    private String md5Value;

    /**
     * 附件日期
     */
    @JsonProperty("attachment_date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Timestamp attachmentDate;

    /**
     * 附件标题
     */
    @JsonProperty("attachment_title")
    private String attachmentTitle;

    /**
     * 附件在oss的访问地址
     */
    @JsonProperty("attachment_url")
    private String attachmentUrl;

    /**
     * 公告日期
     */
    @JsonProperty("bulletin_date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date bulletinDate;

    /**
     * 公告名称
     */
    @JsonProperty("bulletin_title")
    private String bulletinTitle;

    /**
     * 公告链接
     */
    @JsonProperty("bulletin_url")
    private String bulletinUrl;

    /**
     * 涉及对象
     */
    @JsonProperty("com_chi_name")
    private String comChiName;

    /**
     * 文号
     */
    @JsonProperty("document_num")
    private String documentNum;

    /**
     * 一级分类
     */
    @JsonProperty("first_category")
    private String firstCategory;

    /**
     * 基金代码
     */
    @JsonProperty("fund_code")
    private String fundCode;

    /**
     * 基金全称
     */
    @JsonProperty("fund_full_name")
    private String fundFullName;

    /**
     * 基金简称
     */
    @JsonProperty("fund_short_name")
    private String fundShortName;

    /**
     * 基金类别
     */
    @JsonProperty("fund_type")
    private String fundType;

    /**
     * 重大事项标签名(公告二级标签)
     */
    @JsonProperty("major_event_tag_name")
    private String majorEventTagName;

    /**
     * 列表页名称
     */
    @JsonProperty("news_list_name")
    private String newsListName;

    /**
     * 列表页url
     */
    @JsonProperty("news_list_url")
    private String newsListUrl;

    /**
     * oss存储地址
     */
    @JsonProperty("oss_url")
    private String ossUrl;

    /**
     * 发布时间
     */
    @JsonProperty("publish_time")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Timestamp publishTime;

    /**
     * 项目类型
     */
    @JsonProperty("type")
    private String type;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    public String getMd5Value() {
        return md5Value;
    }

    public void setMd5Value(String md5Value) {
        this.md5Value = md5Value;
    }

    public Timestamp getAttachmentDate() {
        return attachmentDate;
    }

    public void setAttachmentDate(Timestamp attachmentDate) {
        this.attachmentDate = attachmentDate;
    }

    public String getAttachmentTitle() {
        return attachmentTitle;
    }

    public void setAttachmentTitle(String attachmentTitle) {
        this.attachmentTitle = attachmentTitle;
    }

    public String getAttachmentUrl() {
        return attachmentUrl;
    }

    public void setAttachmentUrl(String attachmentUrl) {
        this.attachmentUrl = attachmentUrl;
    }

    public Date getBulletinDate() {
        return bulletinDate;
    }

    public void setBulletinDate(Date bulletinDate) {
        this.bulletinDate = bulletinDate;
    }

    public String getBulletinTitle() {
        return bulletinTitle;
    }

    public void setBulletinTitle(String bulletinTitle) {
        this.bulletinTitle = bulletinTitle;
    }

    public String getBulletinUrl() {
        return bulletinUrl;
    }

    public void setBulletinUrl(String bulletinUrl) {
        this.bulletinUrl = bulletinUrl;
    }

    public String getComChiName() {
        return comChiName;
    }

    public void setComChiName(String comChiName) {
        this.comChiName = comChiName;
    }

    public String getDocumentNum() {
        return documentNum;
    }

    public void setDocumentNum(String documentNum) {
        this.documentNum = documentNum;
    }

    public String getFirstCategory() {
        return firstCategory;
    }

    public void setFirstCategory(String firstCategory) {
        this.firstCategory = firstCategory;
    }

    public String getFundCode() {
        return fundCode;
    }

    public void setFundCode(String fundCode) {
        this.fundCode = fundCode;
    }

    public String getFundFullName() {
        return fundFullName;
    }

    public void setFundFullName(String fundFullName) {
        this.fundFullName = fundFullName;
    }

    public String getFundShortName() {
        return fundShortName;
    }

    public void setFundShortName(String fundShortName) {
        this.fundShortName = fundShortName;
    }

    public String getFundType() {
        return fundType;
    }

    public void setFundType(String fundType) {
        this.fundType = fundType;
    }

    public String getMajorEventTagName() {
        return majorEventTagName;
    }

    public void setMajorEventTagName(String majorEventTagName) {
        this.majorEventTagName = majorEventTagName;
    }

    public String getNewsListName() {
        return newsListName;
    }

    public void setNewsListName(String newsListName) {
        this.newsListName = newsListName;
    }

    public String getNewsListUrl() {
        return newsListUrl;
    }

    public void setNewsListUrl(String newsListUrl) {
        this.newsListUrl = newsListUrl;
    }

    public String getOssUrl() {
        return ossUrl;
    }

    public void setOssUrl(String ossUrl) {
        this.ossUrl = ossUrl;
    }

    public Timestamp getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Timestamp publishTime) {
        this.publishTime = publishTime;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
