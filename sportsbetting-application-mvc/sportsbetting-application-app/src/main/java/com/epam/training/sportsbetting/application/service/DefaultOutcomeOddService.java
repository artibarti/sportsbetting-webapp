package com.epam.training.sportsbetting.application.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.epam.training.sportsbetting.application.storage.OutcomeOddRepository;
import com.epam.training.sportsbetting.domain.Outcome;
import com.epam.training.sportsbetting.domain.OutcomeOdd;
import static com.google.common.base.Preconditions.checkNotNull; 

public class DefaultOutcomeOddService implements OutcomeOddService {

	@Autowired
	private OutcomeOddRepository outcomeOddRepository;

	@Override
	public void save(OutcomeOdd outcomeOdd) {
		checkNotNull(outcomeOdd, "Outcome odd can not be null");
		outcomeOddRepository.save(outcomeOdd);
	}

	@Override
	public void removeAll() {
		outcomeOddRepository.deleteAll();
	}

	@Override
	public OutcomeOdd findById(long id) {
		return outcomeOddRepository.findById(id);
	}

	@Override
	public List<OutcomeOdd> findByOutcome(Outcome outcome) {
		checkNotNull(outcome, "Outcome can not be null");
		return outcomeOddRepository.findByOutcome(outcome);
	}

}
