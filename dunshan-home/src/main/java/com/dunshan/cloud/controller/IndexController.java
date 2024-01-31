package com.dunshan.cloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/h")
public class IndexController {
    @GetMapping("/getHome")
    public Object getHomeInfo() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("ok", "data");
        map.put("msg", "我是首页");
        return map;
    }
}
