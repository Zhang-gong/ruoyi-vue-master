package com.ruoyi.system.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.ColorProduct;
import com.ruoyi.system.service.IColorProductService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 颜色维护Controller
 * 
 * @author ruoyi
 * @date 2022-08-25
 */
@RestController
@RequestMapping("/system/product_color")
public class ColorProductController extends BaseController
{
    @Autowired
    private IColorProductService colorProductService;

    /**
     * 查询颜色维护列表
     */
    @PreAuthorize("@ss.hasPermi('system:product_color:list')")
    @GetMapping("/list")
    public TableDataInfo list(ColorProduct colorProduct)
    {
        startPage();
        List<ColorProduct> list = colorProductService.selectColorProductList(colorProduct);
        return getDataTable(list);
    }

    /**
     * 导出颜色维护列表
     */
    @PreAuthorize("@ss.hasPermi('system:product_color:export')")
    @Log(title = "颜色维护", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ColorProduct colorProduct)
    {
        List<ColorProduct> list = colorProductService.selectColorProductList(colorProduct);
        ExcelUtil<ColorProduct> util = new ExcelUtil<ColorProduct>(ColorProduct.class);
        util.exportExcel(response, list, "颜色维护数据");
    }

    /**
     * 获取颜色维护详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:product_color:query')")
    @GetMapping(value = "/{productId}")
    public AjaxResult getInfo(@PathVariable("productId") Long productId)
    {
        return AjaxResult.success(colorProductService.selectColorProductByProductId(productId));
    }

    /**
     * 新增颜色维护
     */
    @PreAuthorize("@ss.hasPermi('system:product_color:add')")
    @Log(title = "颜色维护", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ColorProduct colorProduct)
    {
        return toAjax(colorProductService.insertColorProduct(colorProduct));
    }

    /**
     * 修改颜色维护
     */
    @PreAuthorize("@ss.hasPermi('system:product_color:edit')")
    @Log(title = "颜色维护", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ColorProduct colorProduct)
    {
        return toAjax(colorProductService.updateColorProduct(colorProduct));
    }

    /**
     * 删除颜色维护
     */
    @PreAuthorize("@ss.hasPermi('system:product_color:remove')")
    @Log(title = "颜色维护", businessType = BusinessType.DELETE)
	@DeleteMapping("/{productIds}")
    public AjaxResult remove(@PathVariable Long[] productIds)
    {
        return toAjax(colorProductService.deleteColorProductByProductIds(productIds));
    }
}
