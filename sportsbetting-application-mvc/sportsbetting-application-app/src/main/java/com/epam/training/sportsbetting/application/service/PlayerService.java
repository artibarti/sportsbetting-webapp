package com.epam.training.sportsbetting.application.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Service;

import com.epam.training.sportsbetting.domain.Player;
import com.epam.training.sportsbetting.domain.Wager;

/**
 * Necessary {@link Player} manipulation functionality.
 */
@Service
public interface PlayerService {

    /**
     * Finds player in database according to the given id.
     * @param id The id of the player.
     * @return The player if found.
     */
    Player findPlayerById(Long id);

    /**
     * Endorse the player's balance according to the given bets.
     * @param wagers The wagers to use during the update.
     */
    void probateWagers(List<Wager> wagers);

    /**
     * Finds player in database according to the given name.
     * @param name The name of the player.
     * @return The player if found.
     */
    Player findPlayerByName(String name);

    /**
     * Finds player in database according to the given name.
     * @param email The email of the player.
     * @return The player if found.
     */
    Player findPlayerByEmail(String email);

    /**
     * Increase the given player's balance by the given amount.
     * @param player The player to increase the balance for.
     * @param amount The amount of money to add.
     */
    void increaseBalanceForPlayer(Player player, BigDecimal amount);

    /**
     * Decrease the given player's balance by the given amount.
     * @param player The player to decrease the balance for.
     * @param amount The amount of money to subtract.
     */
    void decreaseBalanceForPlayer(Player player, BigDecimal amount);

    /**
     * Return all bets for the given player.
     * @param player The player to find the bets for.
     * @return All bets for the given player.
     */
    List<Wager> findWagersForPlayer(Player player);

    /**
     * Saves player.
     * @param player The player to save.
     */
    void savePlayer(Player player);

    /**
     * Finds player in database according to the given email.
     * @param email The email of the player.
     * @param password The password of the player.
     * @return The player if found.
     */
    Player findByEmailAndPassword(String email, String password);

    /**
     * Deletes all player.
     */
    void removeAll();

    /**
     * Returns all players.
     * @return All players.
     */
    List<Player> findAll();
}
