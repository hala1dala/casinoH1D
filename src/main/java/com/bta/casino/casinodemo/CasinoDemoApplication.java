package com.bta.casino.casinodemo;

import com.bta.casino.casinodemo.service.GameTrigger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CasinoDemoApplication implements CommandLineRunner {

	@Autowired
	private GameTrigger gameTrigger;

	public static void main(String[] args) {
		SpringApplication.run(CasinoDemoApplication.class, args);
	}

	@Override
	public void run(String... args)throws Exception{
		//gameTrigger.startGames(20000l, 3);

	}

}
