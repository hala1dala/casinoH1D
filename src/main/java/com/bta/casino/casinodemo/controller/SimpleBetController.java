package com.bta.casino.casinodemo.controller;

import com.bta.casino.casinodemo.model.SimpleBet;
import com.bta.casino.casinodemo.model.UserAccount;
import com.bta.casino.casinodemo.repository.UserAccountRepository;
import com.bta.casino.casinodemo.service.UserBetService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/bet")
public class SimpleBetController {

    @Autowired
    private UserBetService userBetService;

    @Autowired UserAccountRepository userAccountRepository;

    @GetMapping
    public String getNewBetView() {
        return "bet/new";
    }

    @PostMapping
    public ResponseEntity<SimpleBet> saveBet(@ModelAttribute SimpleBet bet) {
        final UserAccount userAccount = userAccountRepository.findByUsername("om");
        userBetService.bet(userAccount, bet.getBetValue(), bet.getBet());
        return new ResponseEntity<>(bet, HttpStatus.OK);
    }
}
