package com.xmu.discount.dao;

import com.xmu.discount.domain.Coupon;
import com.xmu.discount.mapper.CouponMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @Author Zhang BingYuan
 * @Date 2019/12/8 15:19
 */
@Repository
public class CouponDao {
    @Autowired
    public CouponMapper couponMapper;

    public Coupon findCouponById(Integer id) {
    Coupon coupon=couponMapper.findCouponById(id);
    return coupon;
    }

    public boolean addCoupon(Coupon coupon){
        boolean bool=couponMapper.addCoupon(coupon);
        return bool;
    }

    public boolean updateCouponById(Integer id,Coupon coupon){
        coupon.setId(id);
        boolean bool=couponMapper.updateCoupon(coupon);
        return bool;
    }

    public boolean deleteCouponById(Integer id){
        boolean bool = couponMapper.deleteCouponById(id);
        return bool;
    }

}
