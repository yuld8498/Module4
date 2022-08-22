package com.example.jame1;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Currency {
    @GetMapping("/curency")
    public String convert(){
        return "currencyconvert";
    }
    @GetMapping("/currency")
    public String convert(@RequestParam String USD, Model model){
        model.addAttribute("USD",USD);
        return "currencyconvert";
    }
}
