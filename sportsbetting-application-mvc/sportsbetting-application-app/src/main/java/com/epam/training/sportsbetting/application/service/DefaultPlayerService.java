package com.epam.training.sportsbetting.application.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.epam.training.sportsbetting.application.storage.PlayerRepository;
import com.epam.training.sportsbetting.application.storage.WagerRepository;
import com.epam.training.sportsbetting.domain.Player;
import com.epam.training.sportsbetting.domain.Wager;
import static com.google.common.base.Preconditions.checkNotNull; 

/**
 * Default implementation for player functionality.
 */
public class DefaultPlayerService implements PlayerService {

    @Autowired private PlayerRepository playerRepository;
    @Autowired private WagerRepository wagerRepository;

    @Override
    public Player findPlayerByName(String name) {
    	checkNotNull(name, "Player name can not be null");
        return playerRepository.findByName(name);
    }

    @Override
    public void increaseBalanceForPlayer(Player player, BigDecimal amount) {
    	checkNotNull(player, "Player can not be null");
    	checkNotNull(amount, "Amount can not be null");
    	player.setBalance(player.getBalance().add(amount));
        playerRepository.save(player);
    }

    @Override
    public void decreaseBalanceForPlayer(Player player, BigDecimal amount) {
    	checkNotNull(player, "Player can not be null");
    	checkNotNull(amount, "Amount can not be null");
    	player.setBalance(player.getBalance().subtract(amount));
        playerRepository.save(player);
    }

    @Override
    public List<Wager> findWagersForPlayer(Player player) {
        return wagerRepository.findByPlayer(player);
    }

    @Override
    public void savePlayer(Player player) {
        playerRepository.save(player);
    }

    @Override
    public void probateWagers(List<Wager> wagers) {

        for (Wager wager: wagers) {
            wager.setProcessed(true);
            if (wager.isWinner()) {
                Player player = wager.getPlayer();
                BigDecimal prize = wager.getAmount().multiply(wager.getOutcomeOdd().getOdd());
                increaseBalanceForPlayer(player, prize);
            }
            wagerRepository.save(wager);
        }
    }

    @Override
    public Player findByEmailAndPassword(String email, String password) {
        return playerRepository.findByEmailAndPassword(email, password);
    }

    @Override
    public Player findPlayerByEmail(String email) {
        return playerRepository.findByEmail(email);
    }

    @Override
    public Player findPlayerById(Long id) {
        return playerRepository.findById(id);
    }

    @Override
    public void removeAll() {
        playerRepository.deleteAll();
    }

    @Override
    public List<Player> findAll() {
        return playerRepository.findAll();
    }
}
