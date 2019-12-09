package com.xmu.discount.service.impl;

import com.xmu.discount.dao.CouponDao;
import com.xmu.discount.domain.Coupon;
import com.xmu.discount.service.CouponRuleService;
import com.xmu.discount.service.CouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author Zhang BingYuan
 * @Date 2019/12/8 12:05
 */
@Service
public class CouponServiceImpl implements CouponService {
    @Autowired
    public CouponDao couponDao;

    @Override
    public Coupon findCouponById(Integer id) {
        Coupon coupon = couponDao.findCouponById(id);
        return coupon;
    }


    @Override
    public boolean addCoupon(Coupon coupon) {
        boolean bool = couponDao.addCoupon(coupon);
        return bool;
    }

    @Override
    public boolean updateCouponById(Integer id, Coupon coupon) {
        boolean bool = couponDao.updateCouponById(id, coupon);
        return bool;
    }

    @Override
    public boolean deleteCouponById(Integer id) {
        boolean bool = couponDao.deleteCouponById(id);
        return bool;
    }
}
