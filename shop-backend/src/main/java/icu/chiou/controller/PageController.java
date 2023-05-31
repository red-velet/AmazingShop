package icu.chiou.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Author: chiou
 * Date: 2023/5/4
 * Time: 17:35
 * Description: 页面控制器，用于处理用户相关的请求
 */
@Api(tags = "页面跳转接口")
@Slf4j
@RequestMapping("page")
@Controller
public class PageController {

    @RequestMapping("{pageName}")
    @ApiOperation("页面跳转")
    public String pageShow(@PathVariable String pageName) {
        return pageName;
    }

    @GetMapping("item-add")
    public String itemAddPage() {
        return "item-add";
    }

    @GetMapping("item-list")
    public String itemListPage() {
        return "item-list";
    }

    @GetMapping("item-param-list")
    public String itemParamList() {
        return "item-param-list";
    }
}
