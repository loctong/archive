package com.archive.susu.controller;

import com.archive.susu.business.entities.SusuModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Calendar;
import java.util.Date;

@Controller
public class TestController {
    @RequestMapping(value = "/test1")
    public String index(Model model) {
        SusuModel susuModel = new SusuModel();
        susuModel.setDob(new Date());
        model.addAttribute("model", susuModel);
        return "test";
    }

    @RequestMapping({"/", "/seedstartermng"})
    public String showSeedstarters(final SusuModel seedStarter) {
        seedStarter.setDob(Calendar.getInstance().getTime());
        return "test";
    }
}
