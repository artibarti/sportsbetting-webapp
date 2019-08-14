package com.epam.training.sportsbetting.web.dto;

import java.math.BigDecimal;

import com.epam.training.sportsbetting.domain.OutcomeOdd;

import lombok.Data;

@Data
public class OutcomeListElementDto {

	public OutcomeListElementDto(OutcomeOdd outcomeOdd) {
		id = outcomeOdd.getId();
		outcomeValue = outcomeOdd.getOutcome().getDescription();
		odd = outcomeOdd.getOdd();
		saveWagerUrl = "/wager/save";
	}
	
    private long id;
    private String outcomeValue;
    private BigDecimal odd;
    private String saveWagerUrl;    
}
