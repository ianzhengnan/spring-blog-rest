package com.ian.sblog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyController extends BaseController{

    @GetMapping("/main")
    public String personMain(){
        return "main";
    }
}
