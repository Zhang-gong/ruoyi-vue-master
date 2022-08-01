package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import com.ruoyi.common.utils.StringUtils;
import org.springframework.transaction.annotation.Transactional;
import com.ruoyi.system.domain.SysCustomer;
import com.ruoyi.system.mapper.SysGoodsMapper;
import com.ruoyi.system.domain.SysGoods;
import com.ruoyi.system.service.ISysGoodsService;

/**
 * 商品Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-08-01
 */
@Service
public class SysGoodsServiceImpl implements ISysGoodsService 
{
    @Autowired
    private SysGoodsMapper sysGoodsMapper;

    /**
     * 查询商品
     * 
     * @param goodsId 商品主键
     * @return 商品
     */
    @Override
    public SysGoods selectSysGoodsByGoodsId(Long goodsId)
    {
        return sysGoodsMapper.selectSysGoodsByGoodsId(goodsId);
    }

    /**
     * 查询商品列表
     * 
     * @param sysGoods 商品
     * @return 商品
     */
    @Override
    public List<SysGoods> selectSysGoodsList(SysGoods sysGoods)
    {
        return sysGoodsMapper.selectSysGoodsList(sysGoods);
    }

    /**
     * 新增商品
     * 
     * @param sysGoods 商品
     * @return 结果
     */
    @Transactional
    @Override
    public int insertSysGoods(SysGoods sysGoods)
    {
        int rows = sysGoodsMapper.insertSysGoods(sysGoods);
        insertSysCustomer(sysGoods);
        return rows;
    }

    /**
     * 修改商品
     * 
     * @param sysGoods 商品
     * @return 结果
     */
    @Transactional
    @Override
    public int updateSysGoods(SysGoods sysGoods)
    {
        sysGoodsMapper.deleteSysCustomerByCustomerId(sysGoods.getGoodsId());
        insertSysCustomer(sysGoods);
        return sysGoodsMapper.updateSysGoods(sysGoods);
    }

    /**
     * 批量删除商品
     * 
     * @param goodsIds 需要删除的商品主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteSysGoodsByGoodsIds(Long[] goodsIds)
    {
        sysGoodsMapper.deleteSysCustomerByCustomerIds(goodsIds);
        return sysGoodsMapper.deleteSysGoodsByGoodsIds(goodsIds);
    }

    /**
     * 删除商品信息
     * 
     * @param goodsId 商品主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteSysGoodsByGoodsId(Long goodsId)
    {
        sysGoodsMapper.deleteSysCustomerByCustomerId(goodsId);
        return sysGoodsMapper.deleteSysGoodsByGoodsId(goodsId);
    }

    /**
     * 新增客户信息
     * 
     * @param sysGoods 商品对象
     */
    public void insertSysCustomer(SysGoods sysGoods)
    {
        List<SysCustomer> sysCustomerList = sysGoods.getSysCustomerList();
        Long goodsId = sysGoods.getGoodsId();
        if (StringUtils.isNotNull(sysCustomerList))
        {
            List<SysCustomer> list = new ArrayList<SysCustomer>();
            for (SysCustomer sysCustomer : sysCustomerList)
            {
                sysCustomer.setCustomerId(goodsId);
                list.add(sysCustomer);
            }
            if (list.size() > 0)
            {
                sysGoodsMapper.batchSysCustomer(list);
            }
        }
    }
}
