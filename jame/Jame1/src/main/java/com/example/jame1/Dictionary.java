package com.example.jame1;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Controller
public class Dictionary {
    Map<String, String> dictionary = new HashMap<>();
    @GetMapping("/dictionary")
    public String dictionary(){
        return "dictionary";
    }
    @GetMapping("/dictionarys")
    public String convert(@RequestParam String value, Model model){
        dictionary.put("xin chao", "hello");
        dictionary.put("tam biet", "good bye");
        dictionary.put("so", "number");
        dictionary.put("mot", "one");
        dictionary.put("hai", "two");
        dictionary.put("ba", "three");
        String test = dictionary.get(value);
        model.addAttribute("value",test);
        return "dictionary";
    }
}
