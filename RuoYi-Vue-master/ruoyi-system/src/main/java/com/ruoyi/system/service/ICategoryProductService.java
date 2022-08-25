package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.CategoryProduct;

/**
 * 产品型号维护Service接口
 * 
 * @author zhanggong
 * @date 2022-08-25
 */
public interface ICategoryProductService 
{
    /**
     * 查询产品型号维护
     * 
     * @param productId 产品型号维护主键
     * @return 产品型号维护
     */
    public CategoryProduct selectCategoryProductByProductId(Long productId);

    /**
     * 查询产品型号维护列表
     * 
     * @param categoryProduct 产品型号维护
     * @return 产品型号维护集合
     */
    public List<CategoryProduct> selectCategoryProductList(CategoryProduct categoryProduct);

    /**
     * 新增产品型号维护
     * 
     * @param categoryProduct 产品型号维护
     * @return 结果
     */
    public int insertCategoryProduct(CategoryProduct categoryProduct);

    /**
     * 修改产品型号维护
     * 
     * @param categoryProduct 产品型号维护
     * @return 结果
     */
    public int updateCategoryProduct(CategoryProduct categoryProduct);

    /**
     * 批量删除产品型号维护
     * 
     * @param productIds 需要删除的产品型号维护主键集合
     * @return 结果
     */
    public int deleteCategoryProductByProductIds(Long[] productIds);

    /**
     * 删除产品型号维护信息
     * 
     * @param productId 产品型号维护主键
     * @return 结果
     */
    public int deleteCategoryProductByProductId(Long productId);
}
