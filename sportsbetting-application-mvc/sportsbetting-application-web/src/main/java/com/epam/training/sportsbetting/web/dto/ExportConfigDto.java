package com.epam.training.sportsbetting.web.dto;

import java.time.LocalDate;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ExportConfigDto {

	private LocalDate startDate;
	private LocalDate endDate;
}
