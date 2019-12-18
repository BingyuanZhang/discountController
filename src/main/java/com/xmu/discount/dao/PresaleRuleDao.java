package com.xmu.discount.dao;

import com.github.pagehelper.PageHelper;
import com.xmu.discount.domain.PresaleRule;
import com.xmu.discount.mapper.PresaleRuleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Zhang Bingyuan
 * @version 1.0
 * @date 2019/12/18 17:58
 */
@Repository
public class PresaleRuleDao {
    @Autowired
    PresaleRuleMapper presaleRuleMapper;

    /**
     * 数据库中增加一个PresaleRule
     *
     * @param presaleRule
     * @return
     */
    public PresaleRule addPresaleRule(PresaleRule presaleRule) {
        LocalDateTime localDateTime = LocalDateTime.now();
        presaleRule.setGmtCreate(localDateTime);
        presaleRule.setGmtModified(localDateTime);
        Boolean bool = presaleRuleMapper.addPresaleRule(presaleRule);
        if (bool.equals(true)) {
            return presaleRule;
        }
        return null;
    }

    public List<PresaleRule> findPresaleRulesByGoodsId(Integer goodsId, Integer page, Integer limit) {
        PageHelper.startPage(page, limit);
        List<PresaleRule> presaleRulesByGoodsId = presaleRuleMapper.findPresaleRulesByGoodsId(goodsId);
        return presaleRulesByGoodsId;
    }

    /**
     * 修改预售信息
     *
     * @param id
     * @param presaleRule
     * @return
     */
    public PresaleRule updatePresaleRuleById(Integer id, PresaleRule presaleRule) {
        presaleRule.setId(id);
        LocalDateTime localDateTime = LocalDateTime.now();
        presaleRule.setGmtModified(localDateTime);
        presaleRule.setGmtCreate(localDateTime);
        Boolean bool = presaleRuleMapper.updatePresaleRuleById(presaleRule);
        if (bool) {
            return presaleRule;
        }
        return null;
    }

    /**
     * 通过id查找PresaleRule
     * @param id
     * @return
     */
    public PresaleRule findPresaleRuleById(Integer id) {
        PresaleRule presaleRule = presaleRuleMapper.findPresaleRuleById(id);
        return  presaleRule;
    }
}
