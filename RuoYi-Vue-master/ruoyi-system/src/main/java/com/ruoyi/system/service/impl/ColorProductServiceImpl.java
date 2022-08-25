package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.ColorProductMapper;
import com.ruoyi.system.domain.ColorProduct;
import com.ruoyi.system.service.IColorProductService;

/**
 * 颜色维护Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-08-25
 */
@Service
public class ColorProductServiceImpl implements IColorProductService 
{
    @Autowired
    private ColorProductMapper colorProductMapper;

    /**
     * 查询颜色维护
     * 
     * @param productId 颜色维护主键
     * @return 颜色维护
     */
    @Override
    public ColorProduct selectColorProductByProductId(Long productId)
    {
        return colorProductMapper.selectColorProductByProductId(productId);
    }

    /**
     * 查询颜色维护列表
     * 
     * @param colorProduct 颜色维护
     * @return 颜色维护
     */
    @Override
    public List<ColorProduct> selectColorProductList(ColorProduct colorProduct)
    {
        return colorProductMapper.selectColorProductList(colorProduct);
    }

    /**
     * 新增颜色维护
     * 
     * @param colorProduct 颜色维护
     * @return 结果
     */
    @Override
    public int insertColorProduct(ColorProduct colorProduct)
    {
        return colorProductMapper.insertColorProduct(colorProduct);
    }

    /**
     * 修改颜色维护
     * 
     * @param colorProduct 颜色维护
     * @return 结果
     */
    @Override
    public int updateColorProduct(ColorProduct colorProduct)
    {
        return colorProductMapper.updateColorProduct(colorProduct);
    }

    /**
     * 批量删除颜色维护
     * 
     * @param productIds 需要删除的颜色维护主键
     * @return 结果
     */
    @Override
    public int deleteColorProductByProductIds(Long[] productIds)
    {
        return colorProductMapper.deleteColorProductByProductIds(productIds);
    }

    /**
     * 删除颜色维护信息
     * 
     * @param productId 颜色维护主键
     * @return 结果
     */
    @Override
    public int deleteColorProductByProductId(Long productId)
    {
        return colorProductMapper.deleteColorProductByProductId(productId);
    }
}
