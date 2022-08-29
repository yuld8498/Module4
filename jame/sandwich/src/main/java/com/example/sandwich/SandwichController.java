package com.example.sandwich;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
public class SandwichController {

    @GetMapping("/")
    public String goIndex(){
        return "home";
    }

    @GetMapping("/{text}")
    @ResponseBody
    //trả về text chứ không phải là 1 link
    public String hello(@PathVariable String text){
        return text;
    }

    @PostMapping("/sandwich")
    public String save(@RequestParam("sandwich") String[] sandwich, ModelMap modelMap){
        modelMap.addAttribute("sandwich", sandwich);
        return "list";
    }
}
