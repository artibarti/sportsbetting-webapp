package com.epam.training.sportsbetting.application.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.epam.training.sportsbetting.application.storage.WagerRepository;
import com.epam.training.sportsbetting.domain.Player;
import com.epam.training.sportsbetting.domain.Wager;
import static com.google.common.base.Preconditions.checkNotNull; 

/**
 * Default implementation for bet functionality.
 */
public class DefaultWagerService implements WagerService {

    @Autowired private WagerRepository wagerRepository;

    @Override
    public void calculateResultsForWagers(List<Wager> wagers) {
    	checkNotNull(wagers, "Wager list can not be null");
        for (int wagerIndex = 0; wagerIndex < wagers.size(); wagerIndex++) {
            Wager wager = wagers.get(wagerIndex);
            wager.setWinner(wagerIndex%2 == 0);
            wagerRepository.save(wager);
        }
    }

    @Override
    public void addWager(Wager wager) {
    	checkNotNull(wager, "Wager can not be null");
        wagerRepository.save(wager);
    }

    @Override
    public void removeWager(Wager wager) {
    	checkNotNull(wager, "Wager can not be null");
    	wagerRepository.delete(wager);
    }

    @Override
    public void removeAll() {
        wagerRepository.deleteAll();
    }

    @Override
    public Wager findById(long id) {
        return wagerRepository.findById(id);
    }

	@Override
	public List<Wager> findByPlayer(Player player) {
    	checkNotNull(player, "Player can not be null");    			
		return wagerRepository.findByPlayer(player);
	}
}
