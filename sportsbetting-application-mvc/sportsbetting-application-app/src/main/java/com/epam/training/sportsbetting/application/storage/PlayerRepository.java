package com.epam.training.sportsbetting.application.storage;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.epam.training.sportsbetting.domain.Player;

/**
 * Repository for players.
 */
@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {

	/**
	 * Finds players by id.
	 * @param id The id of the player
	 * @return The player with the specified id
	 */
	Player findById(long id);

    /**
     * Return the player with the given name.
     * @param name The name of the player.
     * @return The player with the given name.
     */
    Player findByName(String name);

    /**
     * Finds account with the given authentication parameters.
     * @param email The email of the player.
     * @param password The password of the player.
     * @return The player with the given email address and password.
     */
    Player findByEmailAndPassword(String email, String password);

    /**
     * Return the player with the given name.
     * @param email The email address of the player.
     * @return The player with the given email address.
     */
    Player findByEmail(String email);
}
