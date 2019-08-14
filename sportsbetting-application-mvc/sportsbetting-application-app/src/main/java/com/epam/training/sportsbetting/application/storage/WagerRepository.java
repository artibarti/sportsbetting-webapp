package com.epam.training.sportsbetting.application.storage;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.epam.training.sportsbetting.domain.Outcome;
import com.epam.training.sportsbetting.domain.Player;
import com.epam.training.sportsbetting.domain.Wager;

/**
 * Repository for wagers. 
 */
@Repository
public interface WagerRepository extends JpaRepository<Wager, Long> {

	/**
	 * Finds wagers by id.
	 * @param id The id of the wager
	 * @return The wager with the specified id
	 */
	Wager findById(long id);
	
    /**
     * Returns the wagers for a player.
     * @param player The player.
     * @return The wagers for the given player.
     */
    List<Wager> findByPlayer(Player player);
}
