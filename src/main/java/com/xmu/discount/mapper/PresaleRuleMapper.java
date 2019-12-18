package com.xmu.discount.mapper;

import com.xmu.discount.domain.PresaleRule;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Zhang Bingyuan
 * @version 1.0
 * @date 2019/12/18 17:59
 */
@Mapper
@Repository
public interface PresaleRuleMapper {

    /**
     * 数据库中增加一个PresaleRule
     *
     * @param presaleRule
     * @return
     */
    public Boolean addPresaleRule(PresaleRule presaleRule);

    /**
     * 查找goodsId为所查的，的presaleRule
     *
     * @param goodsId
     * @return
     */
    public List<PresaleRule> findPresaleRulesByGoodsId(Integer goodsId);

    /**
     * 根据id更新PresaleRule
     *
     * @param presaleRule
     * @return
     */
    public Boolean updatePresaleRuleById(PresaleRule presaleRule);

    /**
     * 通过id查找PresaleRule
     * @param id
     * @return
     */
    public PresaleRule findPresaleRuleById(Integer id);
}
