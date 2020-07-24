package com.example.provider;


import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

@RestController
@Log4j2
public class ProTestController {

    Random random=new Random();
    @GetMapping("provider/getname")
    public String GetName(@RequestParam("name") String name) throws Exception {
        log.info("被调用");
        int i=random.nextInt(10);
        if(i/2==0){
            log.error("尝试除以零");
            throw  new Exception("尝试除以零");
        }
        return name+"--"+getNowDate();
    }

    public static String getNowDate() {
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = formatter.format(currentTime);
        return  dateString;
//        ParsePosition pos = new ParsePosition(8);
//        Date currentTime_2 = formatter.parse(dateString, pos);
//        return currentTime_2;
    }
}
