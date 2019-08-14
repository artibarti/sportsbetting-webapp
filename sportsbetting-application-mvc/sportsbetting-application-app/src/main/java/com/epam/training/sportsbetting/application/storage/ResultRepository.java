package com.epam.training.sportsbetting.application.storage;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.epam.training.sportsbetting.domain.Result;
import com.epam.training.sportsbetting.domain.SportEvent;

/**
 * Repository for results. 
 */
@Repository
public interface ResultRepository extends JpaRepository<Result, Long> {

	/**
	 * Finds results by id.
	 * @param id The id of the result
	 * @return The result with the specified id
	 */
	Result findById(long id);

    /**
     * Provides the result for a sport event.
     * @param sportEvent The event.
     * @return The result for the given event.
     */
    Result findByEvent(SportEvent sportEvent);
}
