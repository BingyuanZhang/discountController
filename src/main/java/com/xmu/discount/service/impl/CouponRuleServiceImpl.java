package com.xmu.discount.service.impl;

import com.xmu.discount.dao.CouponRuleDao;
import com.xmu.discount.domain.CouponRule;
import com.xmu.discount.domain.CouponRulePo;
import com.xmu.discount.service.CouponRuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.xmu.discount.util.FatherChildUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Zhang BingYuan
 * @Date 2019/12/8 12:05
 */
@Service
public class CouponRuleServiceImpl implements CouponRuleService {

    @Autowired
    public CouponRuleDao couponRuleDao;
    /**
     * 增加一个CouponRule
     * @param couponRulePo
     * @return
     */
    @Override
    public CouponRulePo addCouponRulePo(CouponRulePo couponRulePo) {
        CouponRulePo couponRulePo1 = couponRuleDao.addCouponRulePo(couponRulePo);
        return couponRulePo1;
    }
    /**
     * 根据id查找CouponRule
     * @param id
     * @return
     */
    @Override
    public Object deleteCouponRuleById(Integer id) {
        couponRuleDao.deleteCouponRuleById(id);
        return null;
    }
    /**
     * 通过id更新CouponRule
     * @param id
     * @param couponRulePo
     * @return
     */
    @Override
    public CouponRulePo updateCouponRulePo(Integer id, CouponRulePo couponRulePo) {
        CouponRulePo couponRulePo1 = couponRuleDao.updateCouponRulePo(id,couponRulePo);
        return couponRulePo1;
    }

    /**
     * 通过id查找CouponRule
     * @param id
     * @return
     */
    @Override
    public CouponRule findCouponRuleById(Integer id) throws Exception {
        CouponRulePo couponRulePo = couponRuleDao.findCouponRulePoById(id);
        if (couponRulePo==null) {
            return null;
        }
        CouponRule couponRule = new CouponRule();
        FatherChildUtil.fatherToChild(couponRulePo,couponRule);
        return couponRule;
    }
    /**
     *  管理员查看规则列表
     * @return
     */
    @Override
    public List<CouponRule> getAllCouponRules() throws Exception {
        List<CouponRulePo> allCouponRulePos = couponRuleDao.getAllCouponRulePos();
        List<CouponRule> allCouponRules = new ArrayList<>();
        for (CouponRulePo couponRulePo : allCouponRulePos) {
            CouponRule couponRule = new CouponRule();
            FatherChildUtil.fatherToChild(couponRulePo,couponRule);
            allCouponRules.add(couponRule);
        }
        return allCouponRules;

    }
}
