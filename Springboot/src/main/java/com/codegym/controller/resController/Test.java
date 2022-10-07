package com.codegym.controller.resController;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Test {
    @GetMapping("/hello")
    public ResponseEntity<?> test(){
        return new ResponseEntity<>("hello",HttpStatus.OK);
    }
}
