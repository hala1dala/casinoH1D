package com.bta.casino.casinodemo.controller;

import com.bta.casino.casinodemo.model.SimpleBet;
import com.bta.casino.casinodemo.repository.SimpleBetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleBetController {

    @Autowired
    private SimpleBetRepository simpleBetRepository;

    //htpp://localhost:9000/bets
    //@RequestMapping(value = "/bets", method = RequestMethod.GET)
    @GetMapping("/bets")
    public Iterable<SimpleBet> getAllBets() {
        return simpleBetRepository.findAll();
    }
}
