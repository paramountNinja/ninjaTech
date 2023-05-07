package com.ninja.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sys")
public class SysController {

    @RequestMapping("/test")
    public String test() {
        return "ok";
    }
}
