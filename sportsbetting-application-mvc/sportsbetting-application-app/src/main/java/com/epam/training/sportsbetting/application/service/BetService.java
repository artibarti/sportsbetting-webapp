package com.epam.training.sportsbetting.application.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.epam.training.sportsbetting.domain.Bet;
import com.epam.training.sportsbetting.domain.SportEvent;

/**
 * Necessary functionality for {@link Bet} services.
 */
@Service
public interface BetService {

    /**
     * Persists an {@link Bet}.
     * @param bet The {@link Bet} to persist.
     */
    void save(Bet bet);

    /**
     * Removes all bets.
     */
    void removeAll();

    /**
     * Finds an {@link Bet} by id.
     * @param id The id of the {@link Bet}.
     * @return The {@link Bet} with the given id. 
     */
    Bet findById(long id);

    /**
     * Finds all {@link Bet} for a {@link SportEvent}.
     * @param event The {@link SportEvent}.
     * @return All bets for the {@link SportEvent}.
     */
    List<Bet> findbyEvent(SportEvent event);

}
