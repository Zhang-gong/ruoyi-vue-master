package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.CategoryProductMapper;
import com.ruoyi.system.domain.CategoryProduct;
import com.ruoyi.system.service.ICategoryProductService;

/**
 * 产品型号维护Service业务层处理
 * 
 * @author zhanggong
 * @date 2022-08-25
 */
@Service
public class CategoryProductServiceImpl implements ICategoryProductService 
{
    @Autowired
    private CategoryProductMapper categoryProductMapper;

    /**
     * 查询产品型号维护
     * 
     * @param productId 产品型号维护主键
     * @return 产品型号维护
     */
    @Override
    public CategoryProduct selectCategoryProductByProductId(Long productId)
    {
        return categoryProductMapper.selectCategoryProductByProductId(productId);
    }

    /**
     * 查询产品型号维护列表
     * 
     * @param categoryProduct 产品型号维护
     * @return 产品型号维护
     */
    @Override
    public List<CategoryProduct> selectCategoryProductList(CategoryProduct categoryProduct)
    {
        return categoryProductMapper.selectCategoryProductList(categoryProduct);
    }

    /**
     * 新增产品型号维护
     * 
     * @param categoryProduct 产品型号维护
     * @return 结果
     */
    @Override
    public int insertCategoryProduct(CategoryProduct categoryProduct)
    {
        return categoryProductMapper.insertCategoryProduct(categoryProduct);
    }

    /**
     * 修改产品型号维护
     * 
     * @param categoryProduct 产品型号维护
     * @return 结果
     */
    @Override
    public int updateCategoryProduct(CategoryProduct categoryProduct)
    {
        return categoryProductMapper.updateCategoryProduct(categoryProduct);
    }

    /**
     * 批量删除产品型号维护
     * 
     * @param productIds 需要删除的产品型号维护主键
     * @return 结果
     */
    @Override
    public int deleteCategoryProductByProductIds(Long[] productIds)
    {
        return categoryProductMapper.deleteCategoryProductByProductIds(productIds);
    }

    /**
     * 删除产品型号维护信息
     * 
     * @param productId 产品型号维护主键
     * @return 结果
     */
    @Override
    public int deleteCategoryProductByProductId(Long productId)
    {
        return categoryProductMapper.deleteCategoryProductByProductId(productId);
    }
}
