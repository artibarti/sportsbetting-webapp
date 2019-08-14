package com.epam.training.sportsbetting.application.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.epam.training.sportsbetting.application.storage.OutcomeRepository;
import com.epam.training.sportsbetting.domain.Bet;
import com.epam.training.sportsbetting.domain.Outcome;
import static com.google.common.base.Preconditions.checkNotNull; 

/**
 * Default implementation for outcome service.
 */
public class DefaultOutcomeService implements OutcomeService {

    @Autowired
    private OutcomeRepository outcomeRepository;

    @Override
    public List<Outcome> findByBet(Bet bet) {
    	checkNotNull(bet, "Bet can not be null");
    	return outcomeRepository.findByBet(bet);
    }

    @Override
    public void save(Outcome outcome) {
    	checkNotNull(outcome, "Outcome can not be null");
    	outcomeRepository.save(outcome);
    }

    @Override
    public void removeAll() {
        outcomeRepository.deleteAll();
    }

    @Override
    public Outcome findById(long id) {
        return outcomeRepository.findById(id);
    }
}
