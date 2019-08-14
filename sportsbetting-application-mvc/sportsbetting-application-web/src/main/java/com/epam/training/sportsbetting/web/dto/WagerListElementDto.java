package com.epam.training.sportsbetting.web.dto;

import java.math.BigDecimal;

import com.epam.training.sportsbetting.domain.Wager;

import lombok.Data;

@Data
public class WagerListElementDto {

	public WagerListElementDto(Wager wager) {
		id = wager.getId();
		eventTitle = wager.getEvent().getTitle();
		eventType = "FootballSportEvent";
		betType = wager.getOutcomeOdd().getOutcome().getBet().getBetType().toString();
		betDescription = wager.getOutcomeOdd().getOutcome().getBet().getDescription();
		outcomeOdd = wager.getOutcomeOdd().getOdd();
		outcomeValue = wager.getOutcomeOdd().getOutcome().getDescription();
		amount = wager.getAmount();
		winner = wager.isProcessed() ? Boolean.toString(wager.isWinner()) : " - ";
		processed = wager.isProcessed();
		removeUrl = "/wager/" + wager.getId() + "/remove";
	}
	
	private long id;
	private String eventTitle;
	private String eventType;
	private String betType;
	private String betDescription;
	private String outcomeValue;
	private BigDecimal outcomeOdd;
	private BigDecimal amount;
	private String winner;
	private boolean processed;
	private String removeUrl;
}
