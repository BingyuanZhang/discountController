package com.xmu.discount.controller;

import com.xmu.discount.domain.*;
import com.xmu.discount.service.CouponRuleService;
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
    public CouponRuleService couponRuleService;

    /**
     * 添加优惠券规则
     */
    @PostMapping("/couponRules")
    public Object addCouponRulePo(@RequestBody CouponRulePo couponRulePo) {
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
    public Object findCouponRule(@PathVariable Integer id) throws Exception {
        CouponRule couponRulePoById = couponRuleService.findCouponRuleById(id);
        return couponRulePoById;

    }

    /**
     * 修改优惠券规则
     */
    @PutMapping("/couponRules/{id}")
    public Object updateCouponRule(@PathVariable Integer id, @RequestBody CouponRulePo couponRulePo) {
        CouponRulePo couponRulePo1 = couponRuleService.updateCouponRulePo(id, couponRulePo);
        return couponRulePo1;

    }

    /**
     * 删除一种优惠券规则
     */
    @DeleteMapping("/couponRules/{id}")
    public Object deleteCouponRule(@PathVariable Integer id) {
        couponRuleService.deleteCouponRuleById(id);
        return null;

    }

    /**
     * 管理员查看规则列表
     */
    @GetMapping("/couponRules")
    public List<CouponRule> getAllCouponRules() throws Exception {
        List<CouponRule> allCouponRules = couponRuleService.getAllCouponRules();
        return allCouponRules;
    }


    /**
     * 获取所有的优惠券
     */
    @GetMapping("/coupons")
    public List<Coupon> getAllCoupons() throws Exception {
        List<Coupon> allCoupons = couponService.getAllCoupons();
        return allCoupons;
    }

    @PostMapping("/coupons")
    public Object addCoupon(@RequestBody CouponPo couponPo) {
        CouponPo couponPo1 = couponService.addCouponPo(couponPo);
        return couponPo1;
    }

    @GetMapping("/coupons/availableCoupons")
    public Object getAvailableCoupons(@RequestBody List<CartItem> cartItemList) {
        return null;
    }

    @GetMapping("/payment/withPromotion")
    public Payment getPayment(@RequestBody Order order) {
        return null;
    }

    @GetMapping("/orderItem/withCouponPrice")
    public List<OrderItem> getNewOrderItem(@RequestBody List<OrderItem> orderItems) {
        return null;
    }
}
