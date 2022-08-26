package com.ruoyi.system.domain;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.common.utils.ServletUtils;
import com.ruoyi.common.utils.ip.IpUtils;
import eu.bitwalker.useragentutils.UserAgent;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 颜色维护对象 color_product
 * 
 * @author ruoyi
 * @date 2022-08-25
 */
public class ColorProduct extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 产品编号 */
    private Long productId;

    /** 中文颜色 */
    @Excel(name = "中文颜色")
    private String productColorCh;

    /** 英文颜色 */
    @Excel(name = "英文颜色")
    private String productColorEn;

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
    private String productIp;

    public void setProductId(Long productId) 
    {
        this.productId = productId;
    }

    public Long getProductId() 
    {
        return productId;
    }
    public void setProductColorCh(String productColorCh) 
    {
        this.productColorCh = productColorCh;
    }

    public String getProductColorCh() 
    {
        return productColorCh;
    }
    public void setProductColorEn(String productColorEn) 
    {
        this.productColorEn = productColorEn;
    }

    public String getProductColorEn() 
    {
        return productColorEn;
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

    public Date formatString(String str) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return simpleDateFormat.parse(str);
    }
    public Date formatString1(String str) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh:mm:ss");
        return simpleDateFormat.parse(str);
    }

    public  ColorProduct setDefaultProductColor(ColorProduct colorProduct){
        String timeNow = DateUtils.getTime();
        String date = timeNow.substring(0,10);
        String time =timeNow.substring(11);
        String ip= IpUtils.getIpAddr(ServletUtils.getRequest());
        final UserAgent userAgent = UserAgent.parseUserAgentString(ServletUtils.getRequest().getHeader("User-Agent"));
        String browser = userAgent.getBrowser().getName();
        String userName = SecurityUtils.getUsername();
        try{Date dateTypedate=formatString(date);colorProduct.setProductLastDate(dateTypedate);}
        catch(Exception e){System.out.println(e);}
        try{Date dateTypetime=formatString1(time);colorProduct.setProductLastTime(dateTypetime);}
        catch(Exception e){System.out.println(e);}

        colorProduct.setProductIp(ip);
        colorProduct.setProductLastTcode("WEB-产品型号维护");
        colorProduct.setProductTerminal(browser);
        colorProduct.setProductLastName(userName);
        return colorProduct;

    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("productId", getProductId())
            .append("productColorCh", getProductColorCh())
            .append("productColorEn", getProductColorEn())
            .append("productLastDate", getProductLastDate())
            .append("productLastTime", getProductLastTime())
            .append("productLastName", getProductLastName())
            .append("productLastTcode", getProductLastTcode())
            .append("productTerminal", getProductTerminal())
            .append("productIp", getProductIp())
            .toString();
    }
}
