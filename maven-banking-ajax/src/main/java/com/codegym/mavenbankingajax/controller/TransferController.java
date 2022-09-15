package com.codegym.mavenbankingajax.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/transfers")
public class TransferController {
    @GetMapping
    public ModelAndView listTransfer(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("transfer/list");
        return modelAndView;
    }
}
