package com.archive.susu.controller;

import com.archive.susu.constant.PageUrl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(PageUrl.TEST_AREA)
public class TestLayoutController {
    @RequestMapping("header")
    public String testHeader(){
        int x = 10;
        return "fragment/header";
    }
}
