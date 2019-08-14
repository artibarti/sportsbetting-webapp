package com.epam.training.sportsbetting.application.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.epam.training.sportsbetting.application.storage.SportEventRepository;
import com.epam.training.sportsbetting.domain.SportEvent;
import static com.google.common.base.Preconditions.checkNotNull; 

/**
 * Default implementation for {@link SportEvent} functionality.
 */
public class DefaultEventService implements EventService {

    @Autowired
    private SportEventRepository eventRepository;

    @Override
    public void save(SportEvent event) {
    	checkNotNull(event, "Event can not be null");
        eventRepository.save(event);
    }

    @Override
    public void removeEvent(SportEvent event) {
    	checkNotNull(event, "Event can not be null");
        eventRepository.delete(event);
    }

    @Override
    public List<SportEvent> findAllEvents() {
        return eventRepository.findAll();
    }

    @Override
    public SportEvent findById(long id) {
        return eventRepository.findById(id);
    }

    @Override
    public void removeAll() {
        eventRepository.deleteAll();
    }
}
