package com.bta.casino.casinodemo.service.impl;

import com.bta.casino.casinodemo.model.SimpleGameResult;
import com.bta.casino.casinodemo.model.SimpleResult;
import com.bta.casino.casinodemo.model.UserAccount;
import com.bta.casino.casinodemo.repository.SimpleBetRepository;
import com.bta.casino.casinodemo.repository.SimpleGameResultRepository;
import com.bta.casino.casinodemo.repository.UserAccountRepository;
import com.bta.casino.casinodemo.service.SimpleGameService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Slf4j
@Service
public class SimpleGameServiceImpl implements SimpleGameService {

    @Autowired
    private SimpleGameResultRepository SimpleGameResultRepository;

    @Autowired
    private SimpleBetRepository simpleBetRepository;

    @Autowired
    private UserAccountRepository userAccountRepository;

    @Override
    public SimpleGameResult spin() {
        log.info("SimpleGameServiceImpl.spin()...");
        final SimpleGameResult result = SimpleGameResultRepository.save(generateSimpleGameResult());
        log.info("Game result: " + result);

/*      final List<SimpleBet> activeBets = simpleBetRepository.findAllByActiveIsTrue();
        for (SimpleBet bet : activeBets) {
            final SimpleResult simpleBet = bet.getBet();
            final SimpleResult simpleResult = result.getResult();
            if (simpleBet == simpleResult) {
                UserAccount userAccount = bet.getUserAccount();
                int beforeGameBalance = userAccount.getBalance();
                int afterGameBalance = beforeGameBalance + (2 * bet.getBetValue());
                userAccount.setBalance(afterGameBalance);
                userAccountRepository.save(userAccount);
            }
        }
        return result;
*/
        simpleBetRepository.findAllByActiveIsTrue().stream()
                .peek(sb -> sb.setActive(Boolean.FALSE))
                .peek(sb -> simpleBetRepository.save(sb))
                .filter(sb -> sb.getBet() == result.getResult())
                .forEach(sb -> {
                    final UserAccount userAccount = sb.getUserAccount();
                    userAccount.setBalance(userAccount.getBalance() + (2 * sb.getBetValue()));
                    userAccountRepository.save(userAccount);
                });
        return result;
    }

    private SimpleGameResult generateSimpleGameResult() {
        final SimpleResult[] values = SimpleResult.values();
        final int randomIndex = getRandom(0, values.length);
        final SimpleResult randomResult = values[randomIndex];

        return SimpleGameResult.builder()
                .result(randomResult)
                .dateTime(LocalDateTime.now())
                .build();
    }

    private int getRandom(int from, int till) {
        return (int) (Math.random() * (till - from)) + from;
    }
}
