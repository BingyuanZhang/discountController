package com.xmu.discount.service;

import com.xmu.discount.domain.CartItem;
import com.xmu.discount.domain.Coupon;
import com.xmu.discount.domain.CouponPo;

import java.util.List;

/**
 * @Author Zhang BingYuan
 * @Date 2019/12/8 12:02
 */
public interface CouponService {

    /**
     * 用id找到Coupon对象
     * @param id
     * @return
     */
    public Coupon findCouponById(Integer id);

    /**
     *增加Coupon对象
     * @param couponPo
     * @return
     */
    public CouponPo addCouponPo(CouponPo couponPo);

    /**
     * 用id更新Coupon对象
     * @param id
     * @param coupon
     * @return
     */
    public boolean updateCouponById(Integer id,Coupon coupon);

    /**
     * 用id删除Coupon对象
     * @param id
     * @return
     */
    public boolean deleteCouponById(Integer id);

    /**
     * 获取所有优惠券
     * @return
     */
    public List<Coupon> getAllCoupons() throws Exception;

    /**
     * 获取可用的优惠券
     * @param cartItemList
     * @return
     */
    public List<Coupon> getAvailableCoupons(List<CartItem> cartItemList) throws Exception;
}
