package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.SysProduct;

/**
 * 产品类别维护Service接口
 * 
 * @author ruoyi
 * @date 2022-08-23
 */
public interface ISysProductService 
{
    /**
     * 查询产品类别维护
     * 
     * @param productId 产品类别维护主键
     * @return 产品类别维护
     */
    public SysProduct selectSysProductByProductId(Long productId);

    /**
     * 查询产品类别维护列表
     * 
     * @param sysProduct 产品类别维护
     * @return 产品类别维护集合
     */
    public List<SysProduct> selectSysProductList(SysProduct sysProduct);

    /**
     * 新增产品类别维护
     * 
     * @param sysProduct 产品类别维护
     * @return 结果
     */
    public int insertSysProduct(SysProduct sysProduct);

    /**
     * 修改产品类别维护
     * 
     * @param sysProduct 产品类别维护
     * @return 结果
     */
    public int updateSysProduct(SysProduct sysProduct);

    /**
     * 批量删除产品类别维护
     * 
     * @param productIds 需要删除的产品类别维护主键集合
     * @return 结果
     */
    public int deleteSysProductByProductIds(Long[] productIds);

    /**
     * 删除产品类别维护信息
     * 
     * @param productId 产品类别维护主键
     * @return 结果
     */
    public int deleteSysProductByProductId(Long productId);
}
