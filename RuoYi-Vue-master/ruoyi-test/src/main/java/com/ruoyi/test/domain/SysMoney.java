package com.ruoyi.test.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 资金信息对象 sys_money
 * 
 * @author ruoyi
 * @date 2022-08-17
 */
public class SysMoney extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 编号 */
    private Long moneyId;

    /** 资金用处 */
    @Excel(name = "资金用处")
    private String moneyName;

    /** 状态（0支出 1收入） */
    @Excel(name = "状态", readConverterExp = "0=支出,1=收入")
    private String moneyStatus;

    /** 使用日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "使用日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date moneyDate;

    public void setMoneyId(Long moneyId) 
    {
        this.moneyId = moneyId;
    }

    public Long getMoneyId() 
    {
        return moneyId;
    }
    public void setMoneyName(String moneyName) 
    {
        this.moneyName = moneyName;
    }

    public String getMoneyName() 
    {
        return moneyName;
    }
    public void setMoneyStatus(String moneyStatus) 
    {
        this.moneyStatus = moneyStatus;
    }

    public String getMoneyStatus() 
    {
        return moneyStatus;
    }
    public void setMoneyDate(Date moneyDate) 
    {
        this.moneyDate = moneyDate;
    }

    public Date getMoneyDate() 
    {
        return moneyDate;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("moneyId", getMoneyId())
            .append("moneyName", getMoneyName())
            .append("moneyStatus", getMoneyStatus())
            .append("moneyDate", getMoneyDate())
            .toString();
    }
}
