package com.example.th_module4.controller;


import com.example.th_module4.model.City;
import com.example.th_module4.service.city.ICityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/api/cities")
public class ResCityController {
    @Autowired
    private ICityService cityService;

    @GetMapping
    public ResponseEntity<?> findAllCities(){
        List<City> cities = (List<City>) cityService.findAll();
        return new ResponseEntity<>(cities, HttpStatus.OK);
    }

    @PostMapping("/deleted/{id}")
    public ModelAndView deletedCity(@PathVariable Long id){
        ModelAndView modelAndView = new ModelAndView();
        cityService.remove(id);
        List<City> cities = (List<City>) cityService.findAll();
        modelAndView.addObject("cities", cities);
        modelAndView.setViewName("/ListCities");
        return modelAndView;
    }
}
