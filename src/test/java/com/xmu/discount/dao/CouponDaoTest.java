package com.xmu.discount.dao;

import com.xmu.discount.domain.Coupon;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author Zhang BingYuan
 * @Date 2019/12/8 19:30
 */
@RunWith(SpringRunner.class)
@SpringBootTest
class CouponDaoTest {
    static Coupon coupon=new Coupon();
    @BeforeAll
    public static void getCoupon() {

        coupon.setUserId(111);
        coupon.setCouponSn("aksuh");
    }

    @Test
    void findCouponById() {
    }

    @Test
    void addCoupon(Coupon coupon) {
    }

    @Test
    void updateCouponById() {
    }

    @Test
    void deleteCouponById() {
    }
}