package com.xmu.discount.controller;

import com.xmu.discount.domain.*;
import com.xmu.discount.service.CouponRuleService;
import com.xmu.discount.service.impl.CouponRuleServiceImpl;
import com.xmu.discount.service.impl.CouponServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author Zhang BingYuan
 * @Date 2019/12/8 11:30
 */
@RestController
@RequestMapping(value = "/discount", produces = "application/json;charset=UTF-8", consumes = "application/json;charset=UTF-8")
public class discountController {
    private static final Logger logger = LoggerFactory.getLogger(discountController.class);
    @Autowired
    public CouponServiceImpl couponService;
    @Autowired
    public CouponRuleServiceImpl couponRuleService;


    /**
     * 管理员查看部分优惠券列表
     *
     * @param page
     * @param limit
     * @return
     */
    @GetMapping("/admin/couponRules")
    public List<CouponRulePo> adminGetAllCouponRulePos(@RequestParam("page") Integer page, @RequestParam("limit") Integer limit) {
        List<CouponRulePo> couponRulePos = couponRuleService.adminGetAllCouponRulePos(page, limit);
        return couponRulePos;
    }

    /**
     * 普通用户查看优惠券
     */
    @GetMapping("/couponRules")
    public List<CouponRulePo> userGetAllCouponRulePos(@RequestParam("page") Integer page, @RequestParam("limit") Integer limit) {
        List<CouponRulePo> couponRulePos = couponRuleService.userGetAllCouponRulePos(page, limit);
        return couponRulePos;
    }


    /**
     * 添加优惠券规则
     */
    @PostMapping("/couponRules")
    public CouponRulePo addCouponRulePo(@RequestBody CouponRulePo couponRulePo) {
        if (couponRulePo == null) {
            System.out.println("错误！！！");
        }

        CouponRulePo couponRulePo1 = couponRuleService.addCouponRulePo(couponRulePo);
        return couponRulePo1;
    }

    /**
     * 查看一种优惠券规则
     */
    @GetMapping("/couponRules/{id}")
    public CouponRulePo findCouponRule(@PathVariable Integer id) throws Exception {
        CouponRulePo couponRulePoById = couponRuleService.findCouponRulePoById(id);
        return couponRulePoById;

    }

    /**
     * 修改优惠券规则
     */
    @PutMapping("/couponRules/{id}")
    public CouponRulePo updateCouponRule(@PathVariable Integer id, @RequestBody CouponRulePo couponRulePo) {
        CouponRulePo couponRulePo1 = couponRuleService.updateCouponRulePo(id, couponRulePo);
        return couponRulePo1;

    }

    /**
     * 删除一种优惠券规则
     */
    @DeleteMapping("/couponRules/{id}")
    public void deleteCouponRulePo(@PathVariable Integer id) {
        couponRuleService.deleteCouponRulePoById(id);
    }


    /**
     * 获取特定类型的的优惠券
     */
    @GetMapping("/coupons")
    public List<Coupon> getAllCoupons(@RequestParam("page") Integer page, @RequestParam("limit") Integer limit, @RequestParam("showType") Integer showType) throws Exception {
        List<Coupon> Coupons = couponService.getAllStatusCoupons(page, limit, showType);
        return Coupons;
    }


    @PostMapping("/coupons")
    public Object addCoupon(@RequestBody CouponPo couponPo) {
        CouponPo couponPo1 = couponService.addCouponPo(couponPo);
        return couponPo1;
    }

    /**
     * 获取可用的优惠券
     *
     * @param cartItemList
     * @return
     */
    @GetMapping("/coupons/availableCoupons")
    public Object getAvailableCoupons(@RequestBody List<CartItem> cartItemList) throws Exception {
        List<Coupon> availableCoupons = couponService.getAvailableCoupons(cartItemList);
        return availableCoupons;
    }


}
