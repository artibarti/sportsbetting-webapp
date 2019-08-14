package com.epam.training.sportsbetting.application.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.epam.training.sportsbetting.domain.Bet;
import com.epam.training.sportsbetting.domain.Outcome;

/**
 * Necessary functionality for {@link Outcome} services.
 */
@Service
public interface OutcomeService {

    /**
     * Persists an {@link Outcome}.
     * @param outcome The outcome to persist.
     */
    void save(Outcome outcome);

    /**
     * Removes all outcomes. 
     */
    void removeAll();

    /**
     * Returns the outcome with the given id.
     * @param id The id of the outcome.
     * @return The outcome with the given id.
     */
    Outcome findById(long id);

    /**
     * Finds all outcomes for a bet.
     * @param bet The bet.
     * @return The outcomes for the bet.
     */
    List<Outcome> findByBet(Bet bet);
}
