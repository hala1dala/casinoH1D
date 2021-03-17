package com.bta.casino.casinodemo.controller;

import com.bta.casino.casinodemo.model.SimpleGameResult;
import com.bta.casino.casinodemo.repository.SimpleGameResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleGameResultController {

    @Autowired
    private SimpleGameResultRepository simpleGameResultRepository;

    @GetMapping("/simple-game/results")
    public Iterable<SimpleGameResult> getAllResults() {
        return simpleGameResultRepository.findAll();
    }
}

