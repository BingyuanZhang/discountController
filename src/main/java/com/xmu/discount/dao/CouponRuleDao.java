package com.xmu.discount.dao;

import com.xmu.discount.domain.Coupon;
import com.xmu.discount.domain.CouponRule;
import com.xmu.discount.mapper.CouponRuleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @Author Zhang BingYuan
 * @Date 2019/12/8 15:20
 */
@Repository
public class CouponRuleDao {
    @Autowired
    public CouponRuleMapper couponRuleMapper;

    public boolean addCouponRule(CouponRule couponRule) {
        boolean bool = couponRuleMapper.addCouponRule(couponRule);
        return bool;
    }

    public boolean deleteCouponRuleById(Integer id) {
        boolean bool = couponRuleMapper.deleteCouponRuleById(id);
        return bool;
    }

    public boolean updateCouponRule(Integer id,CouponRule couponRule) {
        couponRule.setId(id);
        boolean bool = couponRuleMapper.updateCouponRule(couponRule);
        return bool;
    }

    public CouponRule findCouponRuleById(Integer id) {
        CouponRule couponRuleById = couponRuleMapper.findCouponRuleById(id);
        return null;
    }
}
