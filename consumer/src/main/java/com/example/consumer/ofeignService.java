package com.example.consumer;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name="provider-service")
public interface ofeignService {
    @GetMapping("provider/getname")
    public String getName(@RequestParam("name")String name);
}
