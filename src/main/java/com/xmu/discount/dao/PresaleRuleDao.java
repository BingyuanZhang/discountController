package com.xmu.discount.dao;

import com.xmu.discount.domain.PresaleRule;
import com.xmu.discount.mapper.PresaleRuleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
        Boolean bool = presaleRuleMapper.addPresaleRule(presaleRule);
        if (bool.equals(true)) {
            return presaleRule;
        }
        return null;
    }
}
