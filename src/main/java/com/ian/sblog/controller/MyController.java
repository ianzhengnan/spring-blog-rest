package com.ian.sblog.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController extends BaseController{

    @GetMapping("/main")
    public String personMain(){
        return "main";
    }
}
