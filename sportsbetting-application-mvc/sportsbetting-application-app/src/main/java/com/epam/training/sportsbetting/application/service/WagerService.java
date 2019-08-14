package com.epam.training.sportsbetting.application.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.epam.training.sportsbetting.domain.Outcome;
import com.epam.training.sportsbetting.domain.Player;
import com.epam.training.sportsbetting.domain.Wager;

/**
 * Necessary functionality for bet services.
 */
@Service
public interface WagerService {

    /**
     * Calculate the results for the persisted wagers.
     * @param wagers The wagers to calculate the results for.
     */
    void calculateResultsForWagers(List<Wager> wagers);

    /**
     * Saves a wager.
     * @param wager The wager to save.
     */
    void addWager(Wager wager);

    /**
     * Finds a bet by its id.
     * @param id The id of the bet.
     * @return The bet with the given id.
     */
    Wager findById(long id);

    /**
     * Deletes a wager.
     * @param wager The wager to delete.
     */
    void removeWager(Wager wager);

    /**
     * Deletes all wagers in the storage.
     */
    void removeAll();

    /**
     * Finds wagers by player.
     * @param player The player.
     * @return All wagers for the given player.
     */
    List<Wager> findByPlayer(Player player);
}
