package com.ruoyi.test.mapper;

import java.util.List;
import com.ruoyi.test.domain.SysMoney;

/**
 * 资金信息Mapper接口
 * 
 * @author ruoyi
 * @date 2022-08-17
 */
public interface SysMoneyMapper 
{
    /**
     * 查询资金信息
     * 
     * @param moneyId 资金信息主键
     * @return 资金信息
     */
    public SysMoney selectSysMoneyByMoneyId(Long moneyId);

    /**
     * 查询资金信息列表
     * 
     * @param sysMoney 资金信息
     * @return 资金信息集合
     */
    public List<SysMoney> selectSysMoneyList(SysMoney sysMoney);

    /**
     * 新增资金信息
     * 
     * @param sysMoney 资金信息
     * @return 结果
     */
    public int insertSysMoney(SysMoney sysMoney);

    /**
     * 修改资金信息
     * 
     * @param sysMoney 资金信息
     * @return 结果
     */
    public int updateSysMoney(SysMoney sysMoney);

    /**
     * 删除资金信息
     * 
     * @param moneyId 资金信息主键
     * @return 结果
     */
    public int deleteSysMoneyByMoneyId(Long moneyId);

    /**
     * 批量删除资金信息
     * 
     * @param moneyIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSysMoneyByMoneyIds(Long[] moneyIds);
}
