package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 产品型号维护对象 category_product
 * 
 * @author zhanggong
 * @date 2022-08-25
 */
public class CategoryProduct extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 产品编号 */
    private Long productId;

    /** 产品型号 */
    @Excel(name = "产品型号")
    private String productModel;

    /** 产品类别 */
    @Excel(name = "产品类别")
    private String productCategory;

    /** 备注 */
    @Excel(name = "备注")
    private String productComment;

    /** 最后修改日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "最后修改日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date productLastDate;

    /** 最后修改时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "最后修改时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date productLastTime;

    /** 最后修改人 */
    @Excel(name = "最后修改人")
    private String productLastName;

    /** 最后修改tcode */
    @Excel(name = "最后修改tcode")
    private String productLastTcode;

    /** 终端 */
    @Excel(name = "终端")
    private String productTerminal;

    /** ip地址 */
    @Excel(name = "ip地址")
    private String productIp;

    public void setProductId(Long productId) 
    {
        this.productId = productId;
    }

    public Long getProductId() 
    {
        return productId;
    }
    public void setProductModel(String productModel) 
    {
        this.productModel = productModel;
    }

    public String getProductModel() 
    {
        return productModel;
    }
    public void setProductCategory(String productCategory) 
    {
        this.productCategory = productCategory;
    }

    public String getProductCategory() 
    {
        return productCategory;
    }
    public void setProductComment(String productComment) 
    {
        this.productComment = productComment;
    }

    public String getProductComment() 
    {
        return productComment;
    }
    public void setProductLastDate(Date productLastDate) 
    {
        this.productLastDate = productLastDate;
    }

    public Date getProductLastDate() 
    {
        return productLastDate;
    }
    public void setProductLastTime(Date productLastTime) 
    {
        this.productLastTime = productLastTime;
    }

    public Date getProductLastTime() 
    {
        return productLastTime;
    }
    public void setProductLastName(String productLastName) 
    {
        this.productLastName = productLastName;
    }

    public String getProductLastName() 
    {
        return productLastName;
    }
    public void setProductLastTcode(String productLastTcode) 
    {
        this.productLastTcode = productLastTcode;
    }

    public String getProductLastTcode() 
    {
        return productLastTcode;
    }
    public void setProductTerminal(String productTerminal) 
    {
        this.productTerminal = productTerminal;
    }

    public String getProductTerminal() 
    {
        return productTerminal;
    }
    public void setProductIp(String productIp) 
    {
        this.productIp = productIp;
    }

    public String getProductIp() 
    {
        return productIp;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("productId", getProductId())
            .append("productModel", getProductModel())
            .append("productCategory", getProductCategory())
            .append("productComment", getProductComment())
            .append("productLastDate", getProductLastDate())
            .append("productLastTime", getProductLastTime())
            .append("productLastName", getProductLastName())
            .append("productLastTcode", getProductLastTcode())
            .append("productTerminal", getProductTerminal())
            .append("productIp", getProductIp())
            .toString();
    }
}
