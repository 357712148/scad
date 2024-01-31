package com.dunshan.cloud.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "dunshan-home")
public interface ShoppingHomeAPi {
    @GetMapping("/h/getHome")
    public Object getHomeInfo();
}
