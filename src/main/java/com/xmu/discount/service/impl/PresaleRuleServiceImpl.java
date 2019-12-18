package com.xmu.discount.service.impl;

import com.github.pagehelper.PageHelper;
import com.xmu.discount.dao.PresaleRuleDao;
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
    /**
     * 数据库中增加一个PresaleRule
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
     * @param goodsId
     * @param page
     * @param limit
     * @return
     */
    @Override
    public List<PresaleRuleVo> findPresaleRuleVosByGoodsId(Integer goodsId, Integer page, Integer limit) {
        List<PresaleRule> presaleRules = presaleRuleDao.findPresaleRulesByGoodsId(goodsId, page, limit);

        return null;
    }

}
