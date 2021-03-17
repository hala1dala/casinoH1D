package com.bta.casino.casinodemo.repository;

import com.bta.casino.casinodemo.model.SimpleGameResult;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SimpleGameResultRepository extends CrudRepository<SimpleGameResult, Long> {
}
