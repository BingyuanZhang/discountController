package com.xmu.discount.service;

import com.xmu.discount.domain.PresaleRule;
import com.xmu.discount.vo.PresaleRuleVo;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * @author Zhang Bingyuan
 * @version 1.0
 * @date 2019/12/18 17:55
 */
public interface PresaleRuleService {

    /**
     * 数据库中增加一个PresaleRule
     *
     * @param presaleRule
     * @return
     */
    public PresaleRule addPresaleRule(PresaleRule presaleRule);

    /**
     * 通过goodsId获取presaleRules
     *
     * @param goodsId
     * @param page
     * @param limit
     * @return
     */
    public List<PresaleRuleVo> findPresaleRuleVosByGoodsId(Integer goodsId, Integer page, Integer limit);

    /**
     * 修改预售信息
     *
     * @param id
     * @param presaleRule
     * @return
     */
    public PresaleRule updatePresaleRuleById(Integer id, PresaleRule presaleRule);

    /**
     * 通过id获得PresaleRuleVo
     * @param id
     * @return
     */
    public PresaleRuleVo findPresaleRuleVoById(Integer id);
}
