package com.qf.springbootnew.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("page")
@Slf4j
public class PageController {

    @RequestMapping("hello")
    public String hello(Model model){
        model.addAttribute("name" , "东湖搜房");

        log.error("你说");
        return "hello";
    }
}
