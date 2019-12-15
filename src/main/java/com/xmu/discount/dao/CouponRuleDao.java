package com.xmu.discount.dao;

import com.xmu.discount.domain.CouponRule;
import com.xmu.discount.domain.CouponRulePo;
import com.xmu.discount.mapper.CouponRuleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @Author Zhang BingYuan
 * @Date 2019/12/8 15:20
 */
@Repository
public class CouponRuleDao {
    @Autowired
    public CouponRuleMapper couponRuleMapper;
    /**
     * 增加一个CouponRule
     * @param couponRulePo
     * @return
     */
    public CouponRulePo addCouponRulePo(CouponRulePo couponRulePo) {
        LocalDateTime localDateTime=LocalDateTime.now();
        couponRulePo.setGmtModified(localDateTime);
        couponRulePo.setGmtCreate(localDateTime);
        couponRulePo.setBeDeleted(false);
        boolean bool = couponRuleMapper.addCouponRulePo(couponRulePo);
        if (bool) {
            return couponRulePo;
        }
        return null;
    }
    /**
     * 根据id删除CouponRule
     * @param id
     * @return
     */
    public Object deleteCouponRuleById(Integer id) {
        couponRuleMapper.deleteCouponRuleById(id);
        return null;
    }
    /**
     * 通过id更新CouponRule
     * @param id
     * @param couponRulePo
     * @return
     */
    public CouponRulePo updateCouponRulePo(Integer id, CouponRulePo couponRulePo) {
        couponRulePo.setId(id);
        LocalDateTime localDateTime = LocalDateTime.now();
        couponRulePo.setGmtModified(localDateTime);
        boolean bool = couponRuleMapper.updateCouponRulePo(couponRulePo);
        if (bool) {
            return couponRulePo;
        }
        else {
            return null;
        }
    }
    /**
     * 通过id查找CouponRule
     * @param id
     * @return
     */
    public CouponRulePo findCouponRulePoById(Integer id) {
        CouponRulePo couponRulePoById = couponRuleMapper.findCouponRulePoById(id);
        return couponRulePoById;
    }

    /**
     * 管理员查看规则列表
     *
     * @return
     */
    public List<CouponRulePo> getAllCouponRulePos() {
        List<CouponRulePo> allCouponRulePos=couponRuleMapper.getAllCouponRulePos();
        return allCouponRulePos;
    }
}
