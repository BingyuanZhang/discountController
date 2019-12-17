package com.xmu.discount.dao;

import com.xmu.discount.domain.CouponRule;
import com.xmu.discount.domain.vo.CouponRuleVo;
import com.xmu.discount.mapper.CouponMapper;
import com.xmu.discount.mapper.CouponRuleMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @Author Zhang BingYuan
 * @Date 2019/12/17 19:24
 */
@RunWith(SpringRunner.class)
@SpringBootTest()
public class CouponRuleDaoTest {
    @Autowired
    CouponRuleDao couponRuleDao;
    @Autowired
    CouponRuleMapper couponRuleMapper;

    @Test
    public void getAllCouponRuleVos()
    {
        List<CouponRuleVo> allCouponRuleVos = couponRuleMapper.getAllCouponRuleVos();
        for (CouponRuleVo allCouponRuleVo : allCouponRuleVos) {
            System.out.println(allCouponRuleVo.toString());
        }
    }
}
