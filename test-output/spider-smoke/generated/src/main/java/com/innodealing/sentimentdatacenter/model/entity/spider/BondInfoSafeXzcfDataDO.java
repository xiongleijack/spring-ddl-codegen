package com.innodealing.sentimentdatacenter.model.entity.spider;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * 外汇管理局处罚信息表表实体对象
 * <p>
 * 实现 SpiderAnnouncementEntity；无对应列的契约方法为 stub（return null），可按 mapping 再 override。
 *
 * @author xionglei
 */
@Table(name = "bond_info_safe_xzcf_data")
public class BondInfoSafeXzcfDataDO implements SpiderAnnouncementEntity {

    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    /**
     * 涉及对象
     */
    @Column
    private String comChiName;

    /**
     * 附件
     */
    @Column
    private String ossUrl;

    /**
     * 文号
     */
    @Column
    private String documentNum;

    /**
     * 处罚决定日期
     */
    @Column
    private Date penaltyDecisionDt;

    /**
     * 发布时间
     */
    @Column
    private Timestamp publishTime;

    /**
     * 创建时间
     */
    @Column
    private Timestamp createTime;

    /**
     * 更新时间
     */
    @Column
    private Timestamp updateTime;

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setComChiName(String comChiName) {
        this.comChiName = comChiName;
    }

    public void setOssUrl(String ossUrl) {
        this.ossUrl = ossUrl;
    }

    public String getDocumentNum() {
        return documentNum;
    }

    public void setDocumentNum(String documentNum) {
        this.documentNum = documentNum;
    }

    public Date getPenaltyDecisionDt() {
        return penaltyDecisionDt;
    }

    public void setPenaltyDecisionDt(Date penaltyDecisionDt) {
        this.penaltyDecisionDt = penaltyDecisionDt;
    }

    public void setPublishTime(Timestamp publishTime) {
        this.publishTime = publishTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = Objects.isNull(createTime) ? null : new Timestamp(createTime.getTime());
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = Objects.isNull(updateTime) ? null : new Timestamp(updateTime.getTime());
    }

    @Override
    public String getBulletinTitle() {
        return null;
    }

    @Override
    public void setBulletinTitle(String bulletinTitle) {
        // 表无对应列；流水线可能回写清洗后的标题
    }

    @Override
    public String getAttachmentTitle() {
        return null;
    }

    @Override
    public void setAttachmentTitle(String attachmentTitle) {
        // 表无对应列；流水线可能回写清洗后的标题
    }

    @Override
    public Timestamp getBulletinDate() {
        return null;
    }

    @Override
    public Timestamp getAttachmentDate() {
        return null;
    }

    @Override
    public Timestamp getPublishTime() {
        return Objects.isNull(publishTime) ? null : new Timestamp(publishTime.getTime());
    }

    @Override
    public String getBondCode() {
        return null;
    }

    @Override
    public String getComChiName() {
        return comChiName;
    }

    @Override
    public String getOssUrl() {
        return ossUrl;
    }

    @Override
    public Timestamp getCreateTime() {
        return Objects.isNull(createTime) ? null : new Timestamp(createTime.getTime());
    }

    @Override
    public Timestamp getUpdateTime() {
        return Objects.isNull(updateTime) ? null : new Timestamp(updateTime.getTime());
    }

}
