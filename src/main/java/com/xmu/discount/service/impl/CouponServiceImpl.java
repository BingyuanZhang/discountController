package com.xmu.discount.service.impl;

import com.xmu.discount.dao.CouponDao;
import com.xmu.discount.dao.CouponRuleDao;
import com.xmu.discount.domain.CartItem;
import com.xmu.discount.domain.Coupon;
import com.xmu.discount.domain.CouponPo;
import com.xmu.discount.domain.CouponRulePo;
import com.xmu.discount.domain.vo.CouponRuleVo;
import com.xmu.discount.service.CouponService;
import com.xmu.discount.util.FatherChildUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public CouponPo addCouponPo(CouponPo couponPo) {
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
     * 获取所有优惠券
     *
     * @return
     */
    @Override
    public List<Coupon> getAllCoupons() throws Exception {
        List<CouponPo> allCouponPos = couponDao.getAllCouponPos();
        List<Coupon> allCoupons = new ArrayList<>();
        for (CouponPo couponPo : allCouponPos) {
            Coupon coupon = new Coupon();
            FatherChildUtil.fatherToChild(couponPo, coupon);
            allCoupons.add(coupon);
        }
        return allCoupons;
    }

    /**
     * 获取可用的优惠券
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
        List<CouponRuleVo> allCouponRuleVos = couponRuleDao.getAllCouponRuleVos();

        HashMap<Integer,List<Integer>> map = new HashMap<Integer, List<Integer>>(allCouponRuleVos.size());
        for (CouponRuleVo allCouponRuleVo : allCouponRuleVos) {
            String goodsIdList1 = allCouponRuleVo.getGoodsList1();
            String goodsIdList2 = allCouponRuleVo.getGoodsList2();
            List<Integer> goodIdList= new ArrayList<Integer>();
            String[] array = new String[5000];
            array = goodsIdList1.split(",");
            for (String s : array) {
                goodIdList.add(Integer.valueOf(s));
            }
            array = goodsIdList2.split(",");
            for (String s : array) {
                goodIdList.add(Integer.valueOf(s));
            }
            map.put(allCouponRuleVo.getId(),goodIdList);
        }
        /**
         * map中已经装有couponRule的id和对应的goodsId
         */

        /**
         * 用来存被选用的couponRule的id
         */
        List<Integer> couponRuleIds = new ArrayList<>();
        for(Integer key:map.keySet())
        {
            List<Integer> goodIds = map.get(key);
            int flag=0;
            for (Integer goodId1 : goodIds) {
                if (flag==1) {
                    break;
                }
                for (Integer goodId2 : goodIdsList) {
                    if (goodId1.equals(goodId2)) {
                        couponRuleIds.add(key);
                        flag=1;
                        break;
                    }
                }
            }
        }
        if (couponRuleIds.size()==0) {
            return coupons;
        }

        /**
         * 此时couponRuleIds是所要的couponRule的Id
         * 接下来通过数据库查找没有被删除的，而且couponRuleId是我们要的，的coupon
         */

        String couponRuleIdString = "(";
        for (int i = 0; i < couponRuleIds.size(); i++) {
            Integer couponRuleId = couponRuleIds.get(i);
            couponRuleIdString = couponRuleIdString+"'"+couponRuleId+"'";
            if (i!=couponRuleIds.size()-1) {
                couponRuleIdString=couponRuleIdString+",";
            }
        }
        couponRuleIdString=couponRuleIdString+")";

        List<CouponPo> couponPos = new ArrayList<>();
        couponPos = couponDao.getCouponPoByCouponRuleId(couponRuleIdString);

        for (CouponPo couponPo : couponPos) {
            Coupon coupon = new Coupon();
            FatherChildUtil.fatherToChild(couponPo,coupon);
            coupons.add(coupon);
        }

        /**
         * 此处已经获得coupon，但是它的couponRule属性还没有获得，下一步就是获取这个
         */

        List<CouponRulePo> couponRulePosByIds = couponRuleDao.getCouponRulePosByIds(couponRuleIdString);


        return null;
    }
}
