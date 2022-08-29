package com.example.jame4bt1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/email")
public class EmailController {
    private static List<String> languages = new ArrayList<>();

    @GetMapping("/configuration")
    public String changeConfiguration(Model model){
        model.addAttribute("languages",languages);
        return "configuration";
    }
}
