package com.xmu.discount.mapper;

import com.xmu.discount.domain.Coupon;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**Mapper接口，用于和数据库交互
 * @Author Zhang BingYuan
 * @Date 2019/12/8 15:25
 */
@Mapper
@Repository
public interface CouponMapper {
    public boolean addCoupon(Coupon coupon);

    public boolean deleteCouponById(Integer id);

    public boolean updateCoupon(Coupon coupon);

    public Coupon findCouponById(Integer id);


}
