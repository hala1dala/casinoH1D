package com.bta.casino.casinodemo.repository;

import com.bta.casino.casinodemo.model.SimpleBet;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SimpleBetRepository extends CrudRepository<SimpleBet, Long> {

    //select * from simple_bet where active = true;
    List<SimpleBet> findAllByActiveIsTrue();
}
