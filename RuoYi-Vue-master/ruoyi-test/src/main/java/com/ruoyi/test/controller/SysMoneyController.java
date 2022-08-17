package com.ruoyi.test.controller;

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
import com.ruoyi.test.domain.SysMoney;
import com.ruoyi.test.service.ISysMoneyService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 资金信息Controller
 * 
 * @author ruoyi
 * @date 2022-08-17
 */
@RestController
@RequestMapping("/money/money")
public class SysMoneyController extends BaseController
{
    @Autowired
    private ISysMoneyService sysMoneyService;

    /**
     * 查询资金信息列表
     */
    @PreAuthorize("@ss.hasPermi('money:money:list')")
    @GetMapping("/list")
    public TableDataInfo list(SysMoney sysMoney)
    {
        startPage();
        List<SysMoney> list = sysMoneyService.selectSysMoneyList(sysMoney);
        return getDataTable(list);
    }

    /**
     * 导出资金信息列表
     */
    @PreAuthorize("@ss.hasPermi('money:money:export')")
    @Log(title = "资金信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SysMoney sysMoney)
    {
        List<SysMoney> list = sysMoneyService.selectSysMoneyList(sysMoney);
        ExcelUtil<SysMoney> util = new ExcelUtil<SysMoney>(SysMoney.class);
        util.exportExcel(response, list, "资金信息数据");
    }

    /**
     * 获取资金信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('money:money:query')")
    @GetMapping(value = "/{moneyId}")
    public AjaxResult getInfo(@PathVariable("moneyId") Long moneyId)
    {
        return AjaxResult.success(sysMoneyService.selectSysMoneyByMoneyId(moneyId));
    }

    /**
     * 新增资金信息
     */
    @PreAuthorize("@ss.hasPermi('money:money:add')")
    @Log(title = "资金信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SysMoney sysMoney)
    {
        return toAjax(sysMoneyService.insertSysMoney(sysMoney));
    }

    /**
     * 修改资金信息
     */
    @PreAuthorize("@ss.hasPermi('money:money:edit')")
    @Log(title = "资金信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SysMoney sysMoney)
    {
        return toAjax(sysMoneyService.updateSysMoney(sysMoney));
    }

    /**
     * 删除资金信息
     */
    @PreAuthorize("@ss.hasPermi('money:money:remove')")
    @Log(title = "资金信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{moneyIds}")
    public AjaxResult remove(@PathVariable Long[] moneyIds)
    {
        return toAjax(sysMoneyService.deleteSysMoneyByMoneyIds(moneyIds));
    }
}
