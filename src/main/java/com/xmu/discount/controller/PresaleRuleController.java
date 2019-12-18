package com.xmu.discount.controller;

import com.xmu.discount.domain.PresaleRule;
import com.xmu.discount.service.impl.PresaleRuleServiceImpl;
import com.xmu.discount.vo.PresaleRuleVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Zhang Bingyuan
 * @version 1.0
 * @date 2019/12/16 22:23
 */
@RestController
@RequestMapping(value = "/presale", produces = "application/json;charset=UTF-8", consumes = "application/json;charset=UTF-8")
public class PresaleRuleController {

    @Autowired
    PresaleRuleServiceImpl presaleRuleService;

    /**
     *管理员根据条件查询预售信息
     * @param goodsId
     * @param page
     * @param limit
     * @return
     */
    @GetMapping("/presaleRules")
    public List<PresaleRuleVo> getPresaleRuleVoByInf(@RequestParam("goodsId") Integer goodsId,
                                                     @RequestParam("page") Integer page,
                                                     @RequestParam("limit") Integer limit) {
        List<PresaleRuleVo> presaleRuleVos = presaleRuleService.findPresaleRuleVosByGoodsId(goodsId,page,limit);
        return presaleRuleVos;
    }

    /**
     *发布预售信息
     * @param presaleRule
     * @return
     */
    @PostMapping("/presaleRules")
    public PresaleRule addPresaleRule(@RequestBody PresaleRule presaleRule) {
        PresaleRule presaleRule1 = presaleRuleService.addPresaleRule(presaleRule);
        return presaleRule1;
    }

    /**
     *修改预售信息
     * @param id
     * @param PresaleRule
     * @return
     */
    @PutMapping("/presaleRules/{id}")
    public PresaleRule updatePresaleRuleById(@PathVariable Integer id, @RequestBody PresaleRule PresaleRule) {

        return null;

    }

    /**
     *查看预售信息详情
     * @param id
     * @return
     */
    @GetMapping("/presaleRules/{id}")
    public PresaleRuleVo getPresaleRuleVoById(@PathVariable Integer id) {
        return null;

    }
}
