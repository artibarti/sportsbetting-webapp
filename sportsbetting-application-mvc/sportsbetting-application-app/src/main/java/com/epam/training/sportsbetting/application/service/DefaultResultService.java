package com.epam.training.sportsbetting.application.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.epam.training.sportsbetting.application.storage.ResultRepository;
import com.epam.training.sportsbetting.domain.Result;
import com.epam.training.sportsbetting.domain.SportEvent;
import static com.google.common.base.Preconditions.checkNotNull; 

/**
 * Default implementation for result service.
 */
public class DefaultResultService implements ResultService {

    @Autowired private ResultRepository resultRepository;

    @Override
    public Result getResultForEvent(SportEvent event) {
    	checkNotNull(event, "Event can not be null");
    	return resultRepository.findByEvent(event);
    }

    @Override
    public void save(Result result) {
    	checkNotNull(result, "Result can not be null");
        resultRepository.save(result);
    }
}
