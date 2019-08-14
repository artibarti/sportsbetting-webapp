package com.epam.training.sportsbetting.application.service;

import java.util.List;

import com.epam.training.sportsbetting.domain.Outcome;
import com.epam.training.sportsbetting.domain.OutcomeOdd;

public interface OutcomeOddService {

    /**
     * Persists an {@link OutcomeOdd}.
     * @param outcomeOdd The outcome odd to persist.
     */
    void save(OutcomeOdd outcomeOdd);

    /**
     * Removes all outcome odds. 
     */
    void removeAll();

    /**
     * Returns the outcome odd with the given id.
     * @param id The id of the outcome odd.
     * @return The outcome odd with the given id.
     */
    OutcomeOdd findById(long id);

    /**
     * Finds all outcomes odds for an outcome.
     * @param outcome The outcome.
     * @return The outcome odds for the outcome.
     */
    List<OutcomeOdd> findByOutcome(Outcome outcome);

}
