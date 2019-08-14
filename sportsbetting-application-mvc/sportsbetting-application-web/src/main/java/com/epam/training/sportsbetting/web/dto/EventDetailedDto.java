package com.epam.training.sportsbetting.web.dto;

import com.epam.training.sportsbetting.domain.SportEvent;

import lombok.Data;

@Data
public class EventDetailedDto {

	public EventDetailedDto(SportEvent event) {
		id = event.getId();
		title = event.getTitle();
		type = "Football sport event";
		validFrom = event.getValidFrom().toString();
		validUntil = event.getValidUntil().toString();
	}

    private long id;
    private String title;
    private String type;
    private String validFrom;
    private String validUntil;
}
