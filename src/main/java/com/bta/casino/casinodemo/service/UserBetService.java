package com.bta.casino.casinodemo.service;

import com.bta.casino.casinodemo.model.SimpleResult;
import com.bta.casino.casinodemo.model.UserAccount;

public interface UserBetService {
    void bet(UserAccount userAccount, int betValue, SimpleResult betResult);
}
