package com.ad.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SpringSecAppController {

    @GetMapping("/login")
    public String greet() {
        return "login";
    }

    @GetMapping("/success")
    public String displaySuccess() {
        return "success";
    }

    @GetMapping("/demo")
    public String displayDemo() {
        return "demo";
    }
}
