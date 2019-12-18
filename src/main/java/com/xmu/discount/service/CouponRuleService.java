package com.xmu.discount.service;

import com.xmu.discount.domain.CartItem;
import com.xmu.discount.domain.Coupon;
import com.xmu.discount.domain.CouponRule;
import com.xmu.discount.domain.CouponRulePo;

import java.util.List;

/**
 * @Author Zhang BingYuan
 * @Date 2019/12/8 12:03
 */
public interface CouponRuleService {
    /**
     * 增加一个CouponRule
     * @param couponRulePo
     * @return
     */
    public CouponRulePo addCouponRulePo(CouponRulePo couponRulePo);

    /**
     * 根据id查找CouponRule
     * @param id
     * @return
     */
    public Object deleteCouponRulePoById(Integer id);

    /**
     * 通过id更新CouponRule
     * @param id
     * @param couponRulePo
     * @return
     */
    public CouponRulePo updateCouponRulePo(Integer id,CouponRulePo couponRulePo);

    /**
     * 通过id查找CouponRule
     * @param id
     * @return
     * @throws Exception
     */
    public CouponRulePo findCouponRulePoById(Integer id) throws Exception;


    /**
     * 分页获取所有的优惠券规则
     * @param page
     * @param limit
     * @return
     */
    public List<CouponRulePo> adminGetAllCouponRulePos(Integer page, Integer limit);
}
