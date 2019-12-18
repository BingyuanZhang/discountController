package com.xmu.discount.service;

import com.xmu.discount.domain.PresaleRule;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author Zhang Bingyuan
 * @version 1.0
 * @date 2019/12/18 17:55
 */
public interface PresaleService {

    /**
     * 数据库中增加一个PresaleRule
     * @param presaleRule
     * @return
     */
    public PresaleRule addPresaleRule(PresaleRule presaleRule);


}
