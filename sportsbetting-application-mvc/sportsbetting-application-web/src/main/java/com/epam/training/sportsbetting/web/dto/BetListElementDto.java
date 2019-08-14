package com.epam.training.sportsbetting.web.dto;

import com.epam.training.sportsbetting.domain.Bet;

import lombok.Data;

@Data
public class BetListElementDto {

	public BetListElementDto(Bet bet) {
		id = bet.getId();
		betType = bet.getBetType().toString();
		description = bet.getDescription();
		outcomesUrl = "/events/" + bet.getEvent().getId()
			+ "/bets/" + bet.getId() + "/outcomes";
	}
	
	private long id;      
    private String betType;
    private String description;
    private String outcomesUrl;    
}
