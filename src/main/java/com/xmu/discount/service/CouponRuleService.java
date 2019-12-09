package com.xmu.discount.service;

import com.xmu.discount.domain.CouponRule;

/**
 * @Author Zhang BingYuan
 * @Date 2019/12/8 12:03
 */
public interface CouponRuleService {
    public boolean addCouponRule(CouponRule couponRule);

    public boolean deleteCouponRuleById(Integer id);

    public boolean updateCouponRule(Integer id,CouponRule couponRule);

    public CouponRule findCouponRuleById(Integer id);
}
