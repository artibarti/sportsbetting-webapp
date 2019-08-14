package com.epam.training.sportsbetting.application.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.epam.training.sportsbetting.application.storage.BetRepository;
import com.epam.training.sportsbetting.domain.Bet;
import com.epam.training.sportsbetting.domain.SportEvent;
import static com.google.common.base.Preconditions.checkNotNull; 

/**
 * Default implementation for bet service.
 */
public class DefaultBetService implements BetService {

    @Autowired
    private BetRepository betRepository;

    @Override
    public void save(Bet bet) {
    	checkNotNull(bet, "Bet can not be null");
    	betRepository.save(bet);
    }

    @Override
    public void removeAll() {
    	betRepository.deleteAll();
    }

    @Override
    public Bet findById(long id) {
        return betRepository.findById(id);
    }

    @Override
    public List<Bet> findbyEvent(SportEvent event) {
    	checkNotNull(event, "Event cn not be null");
        return betRepository.findByEvent(event);
    }
}
