package com.bta.casino.casinodemo.repository;

import com.bta.casino.casinodemo.model.SimpleBet;
import com.bta.casino.casinodemo.model.UserAccount;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserAccountRepository extends CrudRepository<UserAccount, Long> {
    //select * from User_Account where username = ?
    UserAccount findByUsername(String username);
    UserAccount findByEmail(String email);
    UserAccount findByTaxNumber(long taxNumber);
    List<UserAccount> findAllByUsername(String username);
}
