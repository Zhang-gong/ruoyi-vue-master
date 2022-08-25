package com.ruoyi.system.domain;

import java.sql.Time;
import java.text.ParseException;
import java.lang.Object;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.ServletUtils;
import eu.bitwalker.useragentutils.UserAgent;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import com.ruoyi.common.utils.ip.IpUtils;
import com.ruoyi.common.utils.SecurityUtils;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.text.Format;
import java.util.*;
import java.util.logging.Formatter;
/**
 * 产品类别维护对象 sys_product
 * 
 * @author ruoyi
 * @date 2022-08-23
 */
public class SysProduct extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 产品编号 */
    private Long productId;

    /** 产品类别 */
    @Excel(name = "产品类别")
    private String productType;

    /** 产品备注 */
    @Excel(name = "产品备注")
    private String productRemark;

    /** 最后修改日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "最后修改日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date productLastDate;

    /** 最后修改时间 */
    @JsonFormat(pattern = "HH:mm:ss")
    @Excel(name = "最后修改时间", width = 30, dateFormat = "HH:mm:ss")
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
    private String roductIp;

    public void setProductId(Long productId) 
    {
        this.productId = productId;
    }

    public Long getProductId() 
    {
        return productId;
    }
    public void setProductType(String productType) 
    {
        this.productType = productType;
    }

    public String getProductType() 
    {
        return productType;
    }
    public void setProductRemark(String productRemark) 
    {
        this.productRemark = productRemark;
    }

    public String getProductRemark() 
    {
        return productRemark;
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
    public void setRoductIp(String roductIp) 
    {
        this.roductIp = roductIp;
    }

    public String getRoductIp() 
    {
        return roductIp;
    }

    public Date formatString(String str) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return simpleDateFormat.parse(str);
    }
    public Date formatString1(String str) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh:mm:ss");
        return simpleDateFormat.parse(str);
    }
    /**
     * 新增或修改设置SysProduct默认值
     * @param sysProduct
     * @return
     */
    public  SysProduct setDefaultSysProduct(SysProduct sysProduct){
        String timeNow = DateUtils.getTime();
        String date = timeNow.substring(0,10);
        String time =timeNow.substring(11);
        String ip=IpUtils.getIpAddr(ServletUtils.getRequest());
        final UserAgent userAgent = UserAgent.parseUserAgentString(ServletUtils.getRequest().getHeader("User-Agent"));
        String browser = userAgent.getBrowser().getName();
        String userName = SecurityUtils.getUsername();
        try{Date dateTypedate=formatString(date);sysProduct.setProductLastDate(dateTypedate);}
        catch(Exception e){System.out.println(e);}
        try{Date dateTypetime=formatString1(time);sysProduct.setProductLastTime(dateTypetime);}
        catch(Exception e){System.out.println(e);}

        sysProduct.setRoductIp(ip);
        sysProduct.setProductLastTcode("WEB-产品型号维护");
        sysProduct.setProductTerminal(browser);
        sysProduct.setProductLastName(userName);
        return sysProduct;

    }
    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("productId", getProductId())
            .append("productType", getProductType())
            .append("productRemark", getProductRemark())
            .append("productLastDate", getProductLastDate())
            .append("productLastTime", getProductLastTime())
            .append("productLastName", getProductLastName())
            .append("productLastTcode", getProductLastTcode())
            .append("productTerminal", getProductTerminal())
            .append("roductIp", getRoductIp())
            .toString();
    }
}
