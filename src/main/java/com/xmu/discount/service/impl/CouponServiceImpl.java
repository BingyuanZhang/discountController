package com.xmu.discount.service.impl;

import com.xmu.discount.dao.CouponDao;
import com.xmu.discount.dao.CouponRuleDao;
import com.xmu.discount.domain.*;
import com.xmu.discount.discountDo.CouponRuleDo;
import com.xmu.discount.service.CouponService;
import com.xmu.discount.util.FatherChildUtil;
import com.xmu.discount.util.JsonObjectUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * @Author Zhang BingYuan
 * @Date 2019/12/8 12:05
 */
@Service
public class CouponServiceImpl implements CouponService {
    @Autowired
    public CouponDao couponDao;
    @Autowired
    public CouponRuleDao couponRuleDao;

    /**
     * 用id找到Coupon对象
     *
     * @param id
     * @return
     */
    @Override
    public Coupon findCouponById(Integer id) {
        Coupon coupon = couponDao.findCouponById(id);
        return coupon;
    }

    /**
     * 增加Coupon对象
     *
     * @param couponPo
     * @return
     */
    @Override
    @Transactional
    public CouponPo addCouponPo(CouponPo couponPo) {
        CouponRulePo couponRulePo = new CouponRulePo();
        couponRulePo = couponRuleDao.findCouponRulePoById(couponPo.getCouponRuleId());
        if (couponRulePo.equals(null)) {
            return null;
        }
        couponRulePo.setCollectedNum(couponRulePo.getCollectedNum() + 1);
        couponRuleDao.updateCouponRulePo(couponRulePo.getId(),couponRulePo);
        CouponPo couponPo1 = couponDao.addCouponPo(couponPo);
        return couponPo1;
    }

    /**
     * 用id更新Coupon对象
     *
     * @param id
     * @param coupon
     * @return
     */
    @Override
    public boolean updateCouponById(Integer id, Coupon coupon) {
        boolean bool = couponDao.updateCouponById(id, coupon);
        return bool;
    }

    /**
     * 用id删除Coupon对象
     *
     * @param id
     * @return
     */
    @Override
    public boolean deleteCouponById(Integer id) {
        boolean bool = couponDao.deleteCouponById(id);
        return bool;
    }

    /**
     * 获取所有特定状态优惠券
     *
     * @return
     */
    @Override
    public List<Coupon> getAllStatusCoupons(Integer page, Integer limit, Integer showType) throws Exception {
        /**
         * 获得特定类型的couponPo
         */
        List<CouponPo> couponPos = couponDao.getAllStatusCouponPos(page, limit, showType);
        String couponRuleIdString = "(";
        for (int i = 0; i < couponPos.size(); i++) {
            CouponPo couponPo = couponPos.get(i);
            couponRuleIdString = couponRuleIdString + couponPo.getCouponRuleId();
            if (i != couponPos.size() - 1) {
                couponRuleIdString = couponRuleIdString + ",";
            }
        }
        couponRuleIdString = couponRuleIdString + ")";
        /**
         * 获得这些couponPo的couponRuleId,然后查到couponRulePo
         */
        List<CouponRulePo> couponRulePos = couponRuleDao.getCouponRulePosByIds(couponRuleIdString);
        List<CouponRule> couponRules = new ArrayList<>();
        for (CouponRulePo couponRulePo : couponRulePos) {
            CouponRule couponRule = new CouponRule();
            FatherChildUtil.fatherToChild(couponRulePo, couponRule);
            couponRule.setCouponStrategy(JsonObjectUtil.getCouponStrategy(couponRule.getStrategy()));
            couponRules.add(couponRule);
        }


        List<Coupon> coupons = new ArrayList<>();
        for (CouponPo couponPo : couponPos) {
            Coupon coupon = new Coupon();
            FatherChildUtil.fatherToChild(couponPo, coupon);

            for (CouponRule couponRule : couponRules) {
                if (coupon.getCouponRuleId().equals(couponRule.getId())) {
                    coupon.setCouponRule(couponRule);
                    break;
                }
            }
            coupons.add(coupon);
        }
        return coupons;
    }

    /**
     * 获取可用的优惠券
     *
     * @param cartItemList
     * @return
     */
    @Override
    public List<Coupon> getAvailableCoupons(List<CartItem> cartItemList) throws Exception {
        List<Coupon> coupons = new ArrayList<>();
        /**
         *获得所有的good的id
         */
        List<Integer> goodIdsList = new ArrayList<>();
        for (CartItem cartItem : cartItemList) {
            goodIdsList.add(cartItem.getProduct().getGoodsId());
        }
        /**
         *消除重复的id
         */
        HashSet<Integer> goodIdsSet = new HashSet<>(goodIdsList);
        goodIdsList.clear();
        goodIdsList.addAll(goodIdsSet);
        /**
         *获取所有的couponRule的id和goodIdList
         */
        List<CouponRuleDo> allCouponRuleDos = couponRuleDao.getAllCouponRuleDos();

        HashMap<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>(allCouponRuleDos.size());
        for (CouponRuleDo allCouponRuleDo : allCouponRuleDos) {
            String goodsIdList1 = allCouponRuleDo.getGoodsList1();
            String goodsIdList2 = allCouponRuleDo.getGoodsList2();
            List<Integer> goodIdList = new ArrayList<Integer>();
            String[] array = new String[5000];
            array = goodsIdList1.split(",");
            for (String s : array) {
                goodIdList.add(Integer.valueOf(s));
            }
            array = goodsIdList2.split(",");
            for (String s : array) {
                goodIdList.add(Integer.valueOf(s));
            }
            map.put(allCouponRuleDo.getId(), goodIdList);
        }
        /**
         * map中已经装有couponRule的id和对应的goodsIds
         */
        /**
         * 用来存被选用的couponRule的id
         */
        List<Integer> couponRuleIds = new ArrayList<>();
        for (Integer key : map.keySet()) {
            List<Integer> goodIds = map.get(key);
            int flag = 0;
            for (Integer goodId1 : goodIds) {
                for (Integer goodId2 : goodIdsList) {
                    if (goodId1.equals(goodId2)) {
                        couponRuleIds.add(key);
                        flag = 1;
                        break;
                    }
                }
                if (flag == 1) {
                    break;
                }
            }
        }
        /**
         * 说明没有可获得的coupon
         */
        if (couponRuleIds.size() == 0) {
            return coupons;
        }
        /**
         * 此时couponRuleIds是所要的couponRule的Id
         * 接下来通过数据库查找没有被删除的，而且couponRuleId是我们要的，的coupon
         */
        String couponRuleIdString = "(";
        for (int i = 0; i < couponRuleIds.size(); i++) {
            Integer couponRuleId = couponRuleIds.get(i);
            couponRuleIdString = couponRuleIdString + "'" + couponRuleId + "'";
            if (i != couponRuleIds.size() - 1) {
                couponRuleIdString = couponRuleIdString + ",";
            }
        }
        couponRuleIdString = couponRuleIdString + ")";

        List<CouponPo> couponPos = new ArrayList<>();
        couponPos = couponDao.getCouponPoByCouponRuleId(couponRuleIdString);
        List<CouponRulePo> couponRulePosByIds = couponRuleDao.getCouponRulePosByIds(couponRuleIdString);

        /**
         * 存放id，couponRule
         */
        HashMap<Integer, CouponRule> hashMap = new HashMap<>();

        for (CouponPo couponPo : couponPos) {
            Coupon coupon = new Coupon();
            FatherChildUtil.fatherToChild(couponPo, coupon);
            for (CouponRulePo couponRulePosById : couponRulePosByIds) {
                if (couponRulePosById.getId().equals(couponPo.getCouponRuleId())) {
                    if (hashMap.containsKey(couponRulePosById.getId())) {
                        coupon.setCouponRule(hashMap.get(couponRulePosById.getId()));
                    }

                    CouponRule couponRule = new CouponRule();
                    FatherChildUtil.fatherToChild(couponRulePosById, couponRule);
                    couponRule.setCouponStrategy(JsonObjectUtil.getCouponStrategy(couponRule.getStrategy()));
                    coupon.setCouponRule(couponRule);
                    break;
                }
            }
            coupons.add(coupon);
        }
        return coupons;
    }
}
