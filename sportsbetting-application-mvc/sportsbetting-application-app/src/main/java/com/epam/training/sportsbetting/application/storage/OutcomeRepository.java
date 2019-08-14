package com.epam.training.sportsbetting.application.storage;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.epam.training.sportsbetting.domain.Bet;
import com.epam.training.sportsbetting.domain.Outcome;

/**
 * Repository for outcomes.
 */
@Repository
public interface OutcomeRepository extends JpaRepository<Outcome, Long> {

	/**
	 * Finds outcomes by id.
	 * @param id The id of the outcome
	 * @return The outcome with the specified id
	 */
	Outcome findById(long id);

    /**
     * Give back all outcomes for a bet.
     * @param bet The bet.
     * @return All outcomes for the bet.
     */
    List<Outcome> findByBet(Bet bet);
}
