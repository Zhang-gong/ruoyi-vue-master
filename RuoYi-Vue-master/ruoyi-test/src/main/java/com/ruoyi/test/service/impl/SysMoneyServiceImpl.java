package com.ruoyi.test.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.test.mapper.SysMoneyMapper;
import com.ruoyi.test.domain.SysMoney;
import com.ruoyi.test.service.ISysMoneyService;

/**
 * 资金信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-08-17
 */
@Service
public class SysMoneyServiceImpl implements ISysMoneyService 
{
    @Autowired
    private SysMoneyMapper sysMoneyMapper;

    /**
     * 查询资金信息
     * 
     * @param moneyId 资金信息主键
     * @return 资金信息
     */
    @Override
    public SysMoney selectSysMoneyByMoneyId(Long moneyId)
    {
        return sysMoneyMapper.selectSysMoneyByMoneyId(moneyId);
    }

    /**
     * 查询资金信息列表
     * 
     * @param sysMoney 资金信息
     * @return 资金信息
     */
    @Override
    public List<SysMoney> selectSysMoneyList(SysMoney sysMoney)
    {
        return sysMoneyMapper.selectSysMoneyList(sysMoney);
    }

    /**
     * 新增资金信息
     * 
     * @param sysMoney 资金信息
     * @return 结果
     */
    @Override
    public int insertSysMoney(SysMoney sysMoney)
    {
        return sysMoneyMapper.insertSysMoney(sysMoney);
    }

    /**
     * 修改资金信息
     * 
     * @param sysMoney 资金信息
     * @return 结果
     */
    @Override
    public int updateSysMoney(SysMoney sysMoney)
    {
        return sysMoneyMapper.updateSysMoney(sysMoney);
    }

    /**
     * 批量删除资金信息
     * 
     * @param moneyIds 需要删除的资金信息主键
     * @return 结果
     */
    @Override
    public int deleteSysMoneyByMoneyIds(Long[] moneyIds)
    {
        return sysMoneyMapper.deleteSysMoneyByMoneyIds(moneyIds);
    }

    /**
     * 删除资金信息信息
     * 
     * @param moneyId 资金信息主键
     * @return 结果
     */
    @Override
    public int deleteSysMoneyByMoneyId(Long moneyId)
    {
        return sysMoneyMapper.deleteSysMoneyByMoneyId(moneyId);
    }
}
