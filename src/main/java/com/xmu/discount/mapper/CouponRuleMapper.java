package com.xmu.discount.mapper;

import com.xmu.discount.domain.Coupon;
import com.xmu.discount.domain.CouponRule;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**Mapper接口，用于和数据库交互
 * @Author Zhang BingYuan
 * @Date 2019/12/8 15:25
 */
@Mapper
@Repository
public interface CouponRuleMapper {
    public boolean addCouponRule(CouponRule couponRule);

    public boolean deleteCouponRuleById(Integer id);

    public boolean updateCouponRule(CouponRule couponRule);

    public CouponRule findCouponRuleById(Integer id);
}
