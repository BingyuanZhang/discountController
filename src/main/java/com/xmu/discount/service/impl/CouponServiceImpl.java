package com.xmu.discount.service.impl;

import com.xmu.discount.dao.CouponDao;
import com.xmu.discount.domain.Coupon;
import com.xmu.discount.domain.CouponPo;
import com.xmu.discount.service.CouponService;
import com.xmu.discount.util.FatherChildUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Zhang BingYuan
 * @Date 2019/12/8 12:05
 */
@Service
public class CouponServiceImpl implements CouponService {
    @Autowired
    public CouponDao couponDao;

    /**
     * 用id找到Coupon对象
     *
     * @param id
     * @return
     */
    @Override
    public Coupon findCouponById(Integer id) {
        Coupon coupon = couponDao.findCouponById(id);
        return coupon;
    }

    /**
     * 增加Coupon对象
     *
     * @param couponPo
     * @return
     */
    @Override
    public CouponPo addCouponPo(CouponPo couponPo) {
        CouponPo couponPo1 = couponDao.addCouponPo(couponPo);
            return couponPo1;
    }

    /**
     * 用id更新Coupon对象
     *
     * @param id
     * @param coupon
     * @return
     */
    @Override
    public boolean updateCouponById(Integer id, Coupon coupon) {
        boolean bool = couponDao.updateCouponById(id, coupon);
        return bool;
    }

    /**
     * 用id删除Coupon对象
     *
     * @param id
     * @return
     */
    @Override
    public boolean deleteCouponById(Integer id) {
        boolean bool = couponDao.deleteCouponById(id);
        return bool;
    }

    /**
     * 获取所有优惠券
     *
     * @return
     */
    @Override
    public List<Coupon> getAllCoupons() throws Exception {
        List<CouponPo> allCouponPos = couponDao.getAllCouponPos();
        List<Coupon> allCoupons = new ArrayList<>();
        for (CouponPo couponPo : allCouponPos) {
            Coupon coupon = new Coupon();
            FatherChildUtil.fatherToChild(couponPo, coupon);
            allCoupons.add(coupon);
        }
        return allCoupons;
    }
}
