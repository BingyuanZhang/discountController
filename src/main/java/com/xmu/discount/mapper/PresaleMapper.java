package com.xmu.discount.mapper;

import com.xmu.discount.domain.PresaleRule;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author Zhang Bingyuan
 * @version 1.0
 * @date 2019/12/18 17:59
 */
@Mapper
@Repository
public interface PresaleMapper {

    /**
     * 数据库中增加一个PresaleRule
     * @param presaleRule
     * @return
     */
    public Boolean addPresaleRule(PresaleRule presaleRule);
}
