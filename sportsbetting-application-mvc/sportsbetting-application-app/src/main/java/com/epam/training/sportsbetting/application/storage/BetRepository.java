package com.epam.training.sportsbetting.application.storage;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.epam.training.sportsbetting.domain.Bet;
import com.epam.training.sportsbetting.domain.SportEvent;

/**
 * Repository for bets. 
 */
@Repository
public interface BetRepository extends JpaRepository<Bet, Long> {

	/**
	 * Finds a bet by id.
	 * @param id The id of the bet
	 * @return The bet with the specified id
	 */
	Bet findById(long id);

    /**
     * Return all {@link Bet} for a sport event.
     * @param sportEvent The event.
     * @return All bets for an event.
     */
    List<Bet> findByEvent(SportEvent sportEvent);
}
