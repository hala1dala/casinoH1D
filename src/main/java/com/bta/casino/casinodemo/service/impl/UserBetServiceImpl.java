package com.bta.casino.casinodemo.service.impl;

import com.bta.casino.casinodemo.model.SimpleBet;
import com.bta.casino.casinodemo.model.SimpleResult;
import com.bta.casino.casinodemo.model.UserAccount;
import com.bta.casino.casinodemo.repository.SimpleBetRepository;
import com.bta.casino.casinodemo.repository.UserAccountRepository;
import com.bta.casino.casinodemo.service.UserBetService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Slf4j
@Service
public class UserBetServiceImpl implements UserBetService {

    @Autowired
    private UserAccountRepository userAccountRepository;

    @Autowired
    private SimpleBetRepository simpleBetRepository;

    @Transactional
    @Override
    public void bet(UserAccount userAccount, int betValue, SimpleResult betResult) {
        log.info("UserBetService.bet(" + userAccount + ", " + betValue + ", " + betResult + ")...");

        final long usedID = userAccount.getId();
        UserAccount userAccountFromDB = userAccountRepository.findById(usedID).orElseThrow(() -> new RuntimeException("User with id = " + usedID + " doesn't exist!"));

        userBalanceCheck(userAccountFromDB, betValue);
        SimpleBet bet = SimpleBet.builder()
                .bet(betResult)
                .betValue(betValue)
                .active(Boolean.TRUE)
                .userAccount(userAccountFromDB)
                .build();

        simpleBetRepository.save(bet);
        userAccountFromDB.setBalance(userAccountFromDB.getBalance() - betValue);
        userAccountRepository.save(userAccountFromDB);
    }

    private void userBalanceCheck(UserAccount userAccount, int betValue) {
        int remain = userAccount.getBalance() - betValue;
        if (remain < 0) {
            throw new RuntimeException("User doesn't have enought money to make a bet!");
        }
    }
}
