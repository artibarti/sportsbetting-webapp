package com.epam.training.sportsbetting.application.storage;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.epam.training.sportsbetting.domain.Outcome;
import com.epam.training.sportsbetting.domain.OutcomeOdd;

/**
 * Repository for outcome odds. 
 */
public interface OutcomeOddRepository extends JpaRepository<OutcomeOdd, Long> {

	/**
	 * Finds outcome odds by id.
	 * @param id The id of the outcome odd
	 * @return The outcome odd with the specified id
	 */
	OutcomeOdd findById(long id);

    /**
     * Give back all outcome odds for an outcome.
     * @param outcome The outcome.
     * @return All outcome odds for the outcome.
     */
    List<OutcomeOdd> findByOutcome(Outcome outcome);
}
