package com.comic.site.controller;

import com.comic.site.entity.TestUser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/hello")
    public  String test(){
        TestUser testUser = new TestUser();
        testUser.setAge(2);
        testUser.setName("wer");
        String eee = null;
        eee.equals("aaa");
        return  "wewqrrqww";
    }
}
