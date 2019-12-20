package com.xmu.discount.controller;

import com.xmu.discount.domain.PresaleRule;
import com.xmu.discount.service.PresaleRuleService;
import com.xmu.discount.service.impl.PresaleRuleServiceImpl;
import com.xmu.discount.util.ResponseUtil;
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
    PresaleRuleService presaleRuleService;

    /**
     * 管理员根据条件查询预售信息
     *
     * @param goodsId
     * @param page
     * @param limit
     * @return
     */
    @GetMapping("/presaleRules")
    public Object getPresaleRuleVoByInf(@RequestParam("goodsId") Integer goodsId,
                                                     @RequestParam("page") Integer page,
                                                     @RequestParam("limit") Integer limit) {
        List<PresaleRuleVo> presaleRuleVos = presaleRuleService.findPresaleRuleVosByGoodsId(goodsId, page, limit);
        return ResponseUtil.ok(presaleRuleVos);
    }

    /**
     * 发布预售信息
     *
     * @param presaleRule
     * @return
     */
    @PostMapping("/presaleRules")
    public Object addPresaleRule(@RequestBody PresaleRule presaleRule) {
        PresaleRule presaleRule1 = presaleRuleService.addPresaleRule(presaleRule);
        if (presaleRule1.equals(null)) {
            ResponseUtil.presaleInsertFail();
        }
        return ResponseUtil.ok(presaleRule1);
    }

    /**
     * 修改预售信息
     *
     * @param id
     * @param presaleRule
     * @return
     */
    @PutMapping("/presaleRules/{id}")
    public Object updatePresaleRuleById(@PathVariable Integer id, @RequestBody PresaleRule presaleRule) {
        PresaleRule presaleRule1 = presaleRuleService.updatePresaleRuleById(id, presaleRule);
        if (presaleRule1.equals(null)) {
            ResponseUtil.presaleUpdateFail();
        }
        return ResponseUtil.ok(presaleRule1);
    }

    /**
     * 查看预售信息详情
     *
     * @param id
     * @return
     */
    @GetMapping("/presaleRules/{id}")
    public Object getPresaleRuleVoById(@PathVariable Integer id) {
        PresaleRuleVo presaleRuleVoById = presaleRuleService.findPresaleRuleVoById(id);
        if (presaleRuleVoById.equals(null)) {
            ResponseUtil.presaleRuleUnknown();
        }
        return ResponseUtil.ok(presaleRuleVoById);
    }
}
