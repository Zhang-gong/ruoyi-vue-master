package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.ColorProduct;

/**
 * 颜色维护Mapper接口
 * 
 * @author ruoyi
 * @date 2022-08-25
 */
public interface ColorProductMapper 
{
    /**
     * 查询颜色维护
     * 
     * @param productId 颜色维护主键
     * @return 颜色维护
     */
    public ColorProduct selectColorProductByProductId(Long productId);

    /**
     * 查询颜色维护列表
     * 
     * @param colorProduct 颜色维护
     * @return 颜色维护集合
     */
    public List<ColorProduct> selectColorProductList(ColorProduct colorProduct);

    /**
     * 新增颜色维护
     * 
     * @param colorProduct 颜色维护
     * @return 结果
     */
    public int insertColorProduct(ColorProduct colorProduct);

    /**
     * 修改颜色维护
     * 
     * @param colorProduct 颜色维护
     * @return 结果
     */
    public int updateColorProduct(ColorProduct colorProduct);

    /**
     * 删除颜色维护
     * 
     * @param productId 颜色维护主键
     * @return 结果
     */
    public int deleteColorProductByProductId(Long productId);

    /**
     * 批量删除颜色维护
     * 
     * @param productIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteColorProductByProductIds(Long[] productIds);
}
