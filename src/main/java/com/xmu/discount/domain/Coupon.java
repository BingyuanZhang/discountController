package com.xmu.discount.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.ibatis.type.Alias;

import javax.swing.plaf.synth.SynthListUI;

/**
 * @Author: 数据库与对象模型标准组
 * @Description:优惠券对象
 * @Data:Created in 14:50 2019/12/11
 **/
@Getter
@Setter
@ToString
@EqualsAndHashCode(callSuper = true)
public class Coupon extends CouponPo {
    private CouponRule couponRule;
}
