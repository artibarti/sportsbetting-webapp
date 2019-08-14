package com.epam.training.sportsbetting.domain;

import java.time.LocalDateTime;

import javax.persistence.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@EqualsAndHashCode(callSuper=true)
@NoArgsConstructor
public class FootballSportEvent extends SportEvent {

	public FootballSportEvent(String title, LocalDateTime validFrom, LocalDateTime validUntil) {
		super(title, validFrom, validUntil);
	}
}
