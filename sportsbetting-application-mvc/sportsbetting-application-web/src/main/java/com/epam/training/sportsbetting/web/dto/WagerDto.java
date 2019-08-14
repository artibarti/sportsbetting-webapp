package com.epam.training.sportsbetting.web.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WagerDto {

	private long outcomeOddId;
	private BigDecimal amount;
}
