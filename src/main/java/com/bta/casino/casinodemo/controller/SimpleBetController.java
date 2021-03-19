package com.bta.casino.casinodemo.controller;

import com.bta.casino.casinodemo.model.SimpleBet;
import com.bta.casino.casinodemo.repository.SimpleBetRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@Controller
public class SimpleBetController {

    @Autowired
    private SimpleBetRepository simpleBetRepository;

    @GetMapping("/bet")
    public String getBetVie(){return "bet";}

    @PostMapping("/bet")
    public ResponseEntity<SimpleBet> makeBet(@ModelAttribute SimpleBet simpleBet) {
        simpleBetRepository.save(simpleBet);
        log.info("Bet made.");

        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    //htpp://localhost:9000/bets
    //@RequestMapping(value = "/bets", method = RequestMethod.GET)
    @GetMapping("/bets")
    public Iterable<SimpleBet> getAllBets() {
        return simpleBetRepository.findAll();
    }
}
