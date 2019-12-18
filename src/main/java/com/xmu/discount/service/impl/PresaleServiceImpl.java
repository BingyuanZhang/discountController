package com.xmu.discount.service.impl;

import com.xmu.discount.dao.PresaleDao;
import com.xmu.discount.domain.PresaleRule;
import com.xmu.discount.service.PresaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Zhang Bingyuan
 * @version 1.0
 * @date 2019/12/18 17:54
 */
@Service
public class PresaleServiceImpl implements PresaleService {

    @Autowired
    PresaleDao presaleDao;
    /**
     * 数据库中增加一个PresaleRule
     * @param presaleRule
     * @return PresaleRule
     */
    @Override
    public PresaleRule addPresaleRule(PresaleRule presaleRule) {
        PresaleRule presaleRule1 = presaleDao.addPresaleRule(presaleRule);
        return presaleRule1;
    }

}
