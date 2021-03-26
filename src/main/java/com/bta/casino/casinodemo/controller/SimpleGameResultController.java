package com.bta.casino.casinodemo.controller;

import com.bta.casino.casinodemo.model.SimpleGameResult;
import com.bta.casino.casinodemo.repository.SimpleGameResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@RestController
public class SimpleGameResultController {

    @Autowired
    private SimpleGameResultRepository simpleGameResultRepository;

    /*@GetMapping("/simple-game/results")
    public Iterable<SimpleGameResult> getAllResults() {
        return simpleGameResultRepository.findAll();
    }
     */

    @GetMapping("/bet/results")
    public ModelAndView getAllResultsView(){
        final Map<String, Object> model = new HashMap<>();
        model.put("results", simpleGameResultRepository.findAll());

        return new ModelAndView("bet/results", model) ;
    }
}

