package com.xmu.discount.controller;

import com.xmu.discount.domain.Coupon;
import com.xmu.discount.domain.CouponRule;
import com.xmu.discount.service.CouponRuleService;
import com.xmu.discount.service.impl.CouponServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
     * 添加优惠券
     */
    @PostMapping("/couponRules")
    public Object addCoupon(@RequestBody CouponRule couponRule) {
        if (couponRule == null) {
            System.out.println("错误！！！");
        }
        boolean bool = couponRuleService.addCouponRule(couponRule);
        return bool;
    }

    /**
     * 查看一种优惠券
     */
    @GetMapping("/couponRules/{id}")
    public Object findCoupon(@PathVariable Integer id) {
        CouponRule couponRuleById = couponRuleService.findCouponRuleById(id);
        return couponRuleById;

    }

    /**
     * 修改优惠券信息
     */
    @PutMapping("/couponRules/{id}")
    public Object updateCoupon(@PathVariable Integer id, @RequestBody CouponRule couponRule) {
        boolean bool = couponRuleService.updateCouponRule(id, couponRule);
        return bool;

    }

    /**
     * 删除一种优惠券
     */
    @DeleteMapping("/couponRules/{id}")
    public Object delete(@PathVariable Integer id) {
        boolean bool = couponRuleService.deleteCouponRuleById(id);
        return bool;

    }


    /**
     * 根据条件查找优惠券
     */
    @GetMapping("/couponRules")
    public Object findCoupon(String name, Short type, Short status,
                             @RequestParam(defaultValue = "1") Integer page,
                             @RequestParam(defaultValue = "10") Integer limit,
                             @RequestParam(defaultValue = "add_time") String sort,
                             @RequestParam(defaultValue = "desc") String order) {


        return null;
    }


}
