package com.epam.training.sportsbetting.web.dto;

import java.time.LocalDateTime;

import com.epam.training.sportsbetting.domain.SportEvent;

import lombok.Data;

@Data
public class EventListElementDto {

	public EventListElementDto(SportEvent event) {
		id = event.getId();
		title = event.getTitle();
		type = "FootballSportEvent";
		validFrom = event.getValidFrom();
		validUntil = event.getValidUntil();
		betsUrl = "/events/" + event.getId() + "/bets";
	}

	private long id;
	private String title;
	private String type;

	private LocalDateTime validFrom;
	private LocalDateTime validUntil;
	private String betsUrl;

}
