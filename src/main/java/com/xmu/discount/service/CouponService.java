package com.xmu.discount.service;

import com.xmu.discount.domain.Coupon;

/**
 * @Author Zhang BingYuan
 * @Date 2019/12/8 12:02
 */
public interface CouponService {

    /**
     * 用id找到Coupon对象
     *
     * @param id
     * @return
     */
    public Coupon findCouponById(Integer id);

    /**
     *增加Coupon对象
     * @param coupon
     * @return
     */
    public boolean addCoupon(Coupon coupon);

    /**
     *用id更新Coupon对象
     * @param id
     * @return
     */
    public boolean updateCouponById(Integer id,Coupon coupon);

    /**
     * 用id删除Coupon对象
     * @param id
     * @return
     */
    public boolean deleteCouponById(Integer id);

}
