package com.bta.casino.casinodemo.controller;

import com.bta.casino.casinodemo.service.SimpleGameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SimpleGameController {

    @Autowired
    private SimpleGameService simpleGameService;

    @GetMapping("/spin")
    public ResponseEntity triggerSimpleGame(){
        simpleGameService.spin();
        return new ResponseEntity(null, HttpStatus.OK);
    }
}