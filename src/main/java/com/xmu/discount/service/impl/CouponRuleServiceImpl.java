package com.xmu.discount.service.impl;

import com.xmu.discount.dao.CouponRuleDao;
import com.xmu.discount.domain.Coupon;
import com.xmu.discount.domain.CouponRule;
import com.xmu.discount.service.CouponRuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author Zhang BingYuan
 * @Date 2019/12/8 12:05
 */
@Service
public class CouponRuleServiceImpl implements CouponRuleService {

    @Autowired
    public CouponRuleDao couponRuleDao;
    @Override
    public boolean addCouponRule(CouponRule couponRule) {
        boolean bool = couponRuleDao.addCouponRule(couponRule);
        return bool;
    }

    @Override
    public boolean deleteCouponRuleById(Integer id) {
        boolean bool = couponRuleDao.deleteCouponRuleById(id);
        return bool;
    }

    @Override
    public boolean updateCouponRule(Integer id, CouponRule couponRule) {
        boolean bool = couponRuleDao.updateCouponRule(id,couponRule);
        return bool;
    }


    @Override
    public CouponRule findCouponRuleById(Integer id) {
        CouponRule couponRule = couponRuleDao.findCouponRuleById(id);
        return couponRule;
    }
}
