package com.xmu.discount.dao;

import com.github.pagehelper.PageHelper;
import com.xmu.discount.domain.CouponRulePo;
import com.xmu.discount.discountDo.CouponRuleDo;
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
    CouponRuleMapper couponRuleMapper;

    /**
     * 增加一个CouponRule
     *
     * @param couponRulePo
     * @return
     */
    public CouponRulePo addCouponRulePo(CouponRulePo couponRulePo) {
        LocalDateTime localDateTime = LocalDateTime.now();
        couponRulePo.setGmtModified(localDateTime);
        couponRulePo.setGmtCreate(localDateTime);
        boolean bool = couponRuleMapper.addCouponRulePo(couponRulePo);
        if (bool) {
            return couponRulePo;
        }
        return null;
    }

    /**
     * 根据id删除CouponRule
     *
     * @param id
     * @return
     */
    public Integer deleteCouponRulePoById(Integer id) {
        try {
            couponRuleMapper.deleteCouponRulePoById(id);
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
        return id;
    }

    /**
     * 通过id更新CouponRule
     *
     * @param id
     * @param couponRulePo
     * @return
     */
    public CouponRulePo updateCouponRulePo(Integer id, CouponRulePo couponRulePo) {
        couponRulePo.setId(id);
        LocalDateTime localDateTime = LocalDateTime.now();
        couponRulePo.setGmtModified(localDateTime);
        try {
            Integer integer = couponRuleMapper.updateCouponRulePo(couponRulePo);
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
        return couponRulePo;

    }

    /**
     * 通过id查找CouponRule
     *
     * @param id
     * @return
     */
    public CouponRulePo findCouponRulePoById(Integer id) {
        CouponRulePo couponRulePoById = couponRuleMapper.findCouponRulePoById(id);
        return couponRulePoById;
    }

    /**
     * 管理员查看部分规则列表
     *
     * @return
     */
    public List<CouponRulePo> adminGetAllCouponRulePos(Integer page, Integer limit) {
        PageHelper.startPage(page, limit);
        List<CouponRulePo> CouponRulePos = couponRuleMapper.adminGetAllCouponRulePos();
        return CouponRulePos;
    }


    /**
     * 用户查看部分规则列表
     *
     * @return
     */
    public List<CouponRulePo> userGetAllCouponRulePos(Integer page, Integer limit) {
        PageHelper.startPage(page, limit);
        LocalDateTime localDateTime = LocalDateTime.now();
        List<CouponRulePo> CouponRulePos = couponRuleMapper.userGetAllCouponRulePos();
        for (CouponRulePo couponRulePo : CouponRulePos) {
            if (couponRulePo.getEndTime().isBefore(localDateTime) || couponRulePo.getBeginTime().isAfter(localDateTime)) {
                CouponRulePos.remove(couponRulePo);
            }
        }
        return CouponRulePos;
    }

    /**
     * 获取所有的CouponRule的id和goodsListn
     *
     * @return
     */
    public List<CouponRuleDo> getAllCouponRuleVos() {
        List<CouponRuleDo> allCouponRuleDos = couponRuleMapper.getAllCouponRuleVos();
        return allCouponRuleDos;
    }

    /**
     * 通过多个id获取多个couponRule
     *
     * @param couponRuleIdString
     * @return
     */
    public List<CouponRulePo> getCouponRulePosByIds(String couponRuleIdString) {
        List<CouponRulePo> couponRulePosByIds = couponRuleMapper.getCouponRulePosByIds(couponRuleIdString);
        return couponRulePosByIds;
    }


}
