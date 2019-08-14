package com.epam.training.sportsbetting.application.storage;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.epam.training.sportsbetting.domain.SportEvent;

/**
 * Repository for sport events.
 */
@Repository
public interface SportEventRepository extends JpaRepository<SportEvent, Long> {

	/**
	 * Finds SportEvent by id.
	 * @param id The id of the event
	 * @return The event with the specified id
	 */
	SportEvent findById(long id);	
	
    /**
     * Returns the sport event with the given title.
     * @param title The title of the sport event.
     * @return The sport event with the given title.
     */
    SportEvent findFootballSportEventByTitle(String title);
}
