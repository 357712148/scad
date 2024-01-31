package com.dunshan.cloud.controller;

import com.dunshan.cloud.RequestDataService;
import com.dunshan.cloud.feign.ShoppingHomeAPi;
import jakarta.annotation.Resource;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;

@Log4j2
@RestController
@RequestMapping("/c")
public class IndexPageController {

    @Resource
    ShoppingHomeAPi shoppingHomeAPi;


    @GetMapping("/getUserInfo")
    public Object getUserinfo() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("ok", "data");
        map.put("date", new Date());
        map.put("home", shoppingHomeAPi.getHomeInfo());
        if (RequestDataService.isPerTest()) {
            log.info("我是压测流量");
            map.put("验证压测标识", "我是压测流量");
            return map;
        }
        log.info("我是正常流量");
        map.put("验证压测标识", "我是正常流量");
        return map;
    }


}
