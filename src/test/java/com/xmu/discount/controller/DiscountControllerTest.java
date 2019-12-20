package com.xmu.discount.controller;

import com.xmu.discount.domain.CouponRulePo;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @Author Zhang BingYuan
 * @Date 2019/12/20 10:40
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class DiscountControllerTest {
    @Autowired
    DiscountController discountController;

    static CouponRulePo couponRulePo = new CouponRulePo();
    @Before
    public void getCouponRulePo() {
        System.out.println("DiscountControllerTest");

        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime time = LocalDateTime.now();
        String localTime = df.format(time);
        LocalDateTime beginTime = LocalDateTime.parse("2019-09-28 17:07:05",df);
        LocalDateTime endTime = LocalDateTime.parse("2020-09-28 17:07:05",df);

        couponRulePo.setName("优惠券规则");
        couponRulePo.setBeginTime(beginTime);
        couponRulePo.setEndTime(endTime);
        couponRulePo.setValidPeriod(100);
        couponRulePo.setTotal(100);
        couponRulePo.setCollectedNum(0);
        couponRulePo.setStrategy("{\"name\":\"NumberStrategy\", \"obj\":{\"threshold\":4, \"offCash\":9.98}}");
        couponRulePo.setBrief("This is a couponrule");
        couponRulePo.setGoodsList1("1,2,3,4,7,8,9");
        couponRulePo.setGoodsList2("");
        couponRulePo.setPicUrl("url");
    }


    @Test
    public void adminGetAllCouponRulePos() throws Exception {
        discountController.getAllCoupons(3,3,0);
    }

    @Test
    public void addCouponRulePo() {
        System.out.println(couponRulePo);
        for (int i = 100; i > 0; i--) {
            Object o = discountController.addCouponRulePo(couponRulePo);
        }
    }
}
