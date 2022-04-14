package com.clyao.thymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/thymeleaf")
public class TestController {

    @GetMapping("/index")
    public String index(Model model){
        model.addAttribute("msg", "thymeleaf");
        return "index";
    }

}
