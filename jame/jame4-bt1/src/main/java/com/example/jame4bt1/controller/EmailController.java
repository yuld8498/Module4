package com.example.jame4bt1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/email")
public class EmailController {
    private static List<String> languages = new ArrayList<>();
    static {
        languages.add("English");
        languages.add("Vietnamese");
        languages.add("Japanese");
        languages.add("Chinese");
    }

    @GetMapping("")
    public String changeConfiguration(){
        System.out.println("ddddddd");
        return "index";
    }
}
