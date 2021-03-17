package com.bta.casino.casinodemo.service.impl;

import com.bta.casino.casinodemo.service.GameTrigger;
import com.bta.casino.casinodemo.service.SimpleGameService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class GameTriggerImpl implements GameTrigger {

    @Autowired
    private SimpleGameService simpleGameService;

    @Override
    public void startGames(long interval, final int count) {
        final Runnable asyncPlay = () -> {
            int playCount = count;
            while (playCount > 0) {
                simpleGameService.spin();
                playCount--;
                try {
                    Thread.sleep(interval);
                } catch (InterruptedException e) {
                    log.error("Error during running game" + e.getMessage());
                    throw new RuntimeException(e);
                    }
                }
            };
        asyncPlay.run();
    }
}
