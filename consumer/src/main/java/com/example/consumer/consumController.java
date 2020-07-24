package com.example.consumer;

import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j2
public class consumController {
    @Autowired
    ofeignService service;

    @GetMapping("consumer/getname")
    public String getName(@RequestParam("name")String name) {
        log.info("开始调用");
        String s = service.getName(name);
        return s;
    }
}
