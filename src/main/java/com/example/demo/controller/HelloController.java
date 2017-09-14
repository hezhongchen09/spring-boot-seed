package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by hezhongchen on 2017/9/14.
 */
@RestController
public class HelloController {
    @RequestMapping("hello")
    public Map<String, String> index() {
        Map<String, String> result = new HashMap<>();
        result.put("code", "200");
        result.put("message", "Hello World");

        return result;
    }
}
