package com.epam.training.sportsbetting.application.service;

import org.springframework.stereotype.Service;

import com.epam.training.sportsbetting.domain.Result;
import com.epam.training.sportsbetting.domain.SportEvent;

/**
 * Necessary result handling functionality.
 */
@Service
public interface ResultService {

    /**
     * Provides the results for an event.
     * @param event The event.
     * @return The result for an event.
     */
    Result getResultForEvent(SportEvent event);

    /**
     * Persists a result.
     * @param result The result to save.
     */
    void save(Result result);
}
