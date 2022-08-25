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
import com.ruoyi.system.domain.CategoryProduct;
import com.ruoyi.system.service.ICategoryProductService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 产品型号维护Controller
 * 
 * @author zhanggong
 * @date 2022-08-25
 */
@RestController
@RequestMapping("/system/product_category")
public class CategoryProductController extends BaseController
{
    @Autowired
    private ICategoryProductService categoryProductService;

    /**
     * 查询产品型号维护列表
     */
    @PreAuthorize("@ss.hasPermi('system:product_category:list')")
    @GetMapping("/list")
    public TableDataInfo list(CategoryProduct categoryProduct)
    {
        startPage();
        List<CategoryProduct> list = categoryProductService.selectCategoryProductList(categoryProduct);
        return getDataTable(list);
    }

    /**
     * 导出产品型号维护列表
     */
    @PreAuthorize("@ss.hasPermi('system:product_category:export')")
    @Log(title = "产品型号维护", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, CategoryProduct categoryProduct)
    {
        List<CategoryProduct> list = categoryProductService.selectCategoryProductList(categoryProduct);
        ExcelUtil<CategoryProduct> util = new ExcelUtil<CategoryProduct>(CategoryProduct.class);
        util.exportExcel(response, list, "产品型号维护数据");
    }

    /**
     * 获取产品型号维护详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:product_category:query')")
    @GetMapping(value = "/{productId}")
    public AjaxResult getInfo(@PathVariable("productId") Long productId)
    {
        return AjaxResult.success(categoryProductService.selectCategoryProductByProductId(productId));
    }

    /**
     * 新增产品型号维护
     */
    @PreAuthorize("@ss.hasPermi('system:product_category:add')")
    @Log(title = "产品型号维护", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody CategoryProduct categoryProduct)
    {
        return toAjax(categoryProductService.insertCategoryProduct(categoryProduct));
    }

    /**
     * 修改产品型号维护
     */
    @PreAuthorize("@ss.hasPermi('system:product_category:edit')")
    @Log(title = "产品型号维护", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody CategoryProduct categoryProduct)
    {
        return toAjax(categoryProductService.updateCategoryProduct(categoryProduct));
    }

    /**
     * 删除产品型号维护
     */
    @PreAuthorize("@ss.hasPermi('system:product_category:remove')")
    @Log(title = "产品型号维护", businessType = BusinessType.DELETE)
	@DeleteMapping("/{productIds}")
    public AjaxResult remove(@PathVariable Long[] productIds)
    {
        return toAjax(categoryProductService.deleteCategoryProductByProductIds(productIds));
    }
}
