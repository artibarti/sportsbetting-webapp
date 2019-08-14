package com.epam.training.sportsbetting.application.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.epam.training.sportsbetting.domain.SportEvent;

/**
 * Necessary functionality for {@link SportEvent} services.
 */
@Service
public interface EventService {

    /**
     * Returns an {@link SportEvent} with the given id.
     * @param id The id of the {@link SportEvent}.
     * @return The {@link SportEvent} with the given id.
     */
    SportEvent findById(long id);

    /**
     * Saves a {@link SportEvent} to the storage.
     * @param event The {@link SportEvent} to save. 
     */
    void save(SportEvent event);

    /**
     * Removes a {@link SportEvent} from the storage.
     * @param event The {@link SportEvent} to save. 
     */
    void removeEvent(SportEvent event);

    /**
     * Removes all event.
     */
    void removeAll();

    /**
     * Return all events from the storage.
     * @return All events from the storage.
     */
    List<SportEvent> findAllEvents();
}
