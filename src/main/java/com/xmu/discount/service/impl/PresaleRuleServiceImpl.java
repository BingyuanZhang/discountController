package com.xmu.discount.service.impl;

import com.github.pagehelper.PageHelper;
import com.xmu.discount.dao.GoodsDao;
import com.xmu.discount.dao.PresaleRuleDao;
import com.xmu.discount.domain.GoodsPo;
import com.xmu.discount.domain.PresaleRule;
import com.xmu.discount.service.PresaleRuleService;
import com.xmu.discount.vo.PresaleRuleVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Zhang Bingyuan
 * @version 1.0
 * @date 2019/12/18 17:54
 */
@Service
public class PresaleRuleServiceImpl implements PresaleRuleService {

    @Autowired
    PresaleRuleDao presaleRuleDao;
    @Autowired
    GoodsDao goodsDao;

    /**
     * 数据库中增加一个PresaleRule
     *
     * @param presaleRule
     * @return PresaleRule
     */
    @Override
    public PresaleRule addPresaleRule(PresaleRule presaleRule) {
        PresaleRule presaleRule1 = presaleRuleDao.addPresaleRule(presaleRule);
        return presaleRule1;
    }

    /**
     * 通过goodsId获取presaleRules
     *
     * @param goodsId
     * @param page
     * @param limit
     * @return
     */
    @Override
    public List<PresaleRuleVo> findPresaleRuleVosByGoodsId(Integer goodsId, Integer page, Integer limit) {
        /**
         * 获得List<PresaleRule>和GoodsPo对象
         */
        List<PresaleRule> presaleRules = presaleRuleDao.findPresaleRulesByGoodsId(goodsId, page, limit);
        GoodsPo goodsPo = goodsDao.findGoodsPoById(goodsId);

        List<PresaleRuleVo> presaleRuleVos = new ArrayList<>(presaleRules.size());

        for (PresaleRule presaleRule : presaleRules) {
            PresaleRuleVo presaleRuleVo = new PresaleRuleVo();
            presaleRuleVo.setPresaleRule(presaleRule);
            presaleRuleVo.setGoodsPo(goodsPo);
            presaleRuleVos.add(presaleRuleVo);
        }
        return presaleRuleVos;
    }

    /**
     * 修改预售信息
     *
     * @param id
     * @param presaleRule
     * @return
     */
    @Override
    public PresaleRule updatePresaleRuleById(Integer id, PresaleRule presaleRule) {
        PresaleRule presaleRule1 = presaleRuleDao.updatePresaleRuleById(id, presaleRule);
        return presaleRule1;
    }

    /**
     * 通过id获得PresaleRuleVo
     * @param id
     * @return
     */
    @Override
    public PresaleRuleVo findPresaleRuleVoById(Integer id) {
        PresaleRuleVo presaleRuleVo = new PresaleRuleVo();
        PresaleRule presaleRuleById = presaleRuleDao.findPresaleRuleById(id);
        GoodsPo goodsPoById = goodsDao.findGoodsPoById(presaleRuleById.getGoodsId());
        if (presaleRuleById.equals(null)||goodsPoById.equals(null)) {
            return null;
        }
        presaleRuleVo.setGoodsPo(goodsPoById);
        presaleRuleVo.setPresaleRule(presaleRuleById);
        return presaleRuleVo;
    }

}
