package com.example.spider.model.entity.dwdbond.group;

import javax.persistence.Column;
import java.sql.Date;

/**
 * 按主体唯一编码分组
 *
 * @author xionglei
 */
public class OnshoreBondFilterV5ComUniCodeGroupDO {

    /**
     * 主体唯一编码
     */
    @Column
    private Long comUniCode;

    /**
     * 最晚发行起始日
     */
    @Column(name = "max(issue_start_date)")
    private Date maxIssueStartDate;

    public Long getComUniCode() {
        return comUniCode;
    }

    public void setComUniCode(Long comUniCode) {
        this.comUniCode = comUniCode;
    }

    public Date getMaxIssueStartDate() {
        return maxIssueStartDate == null ? null : new Date(maxIssueStartDate.getTime());
    }

    public void setMaxIssueStartDate(Date maxIssueStartDate) {
        this.maxIssueStartDate = maxIssueStartDate == null ? null : new Date(maxIssueStartDate.getTime());
    }

}
