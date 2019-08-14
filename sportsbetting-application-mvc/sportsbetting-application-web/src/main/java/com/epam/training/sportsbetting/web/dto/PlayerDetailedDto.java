package com.epam.training.sportsbetting.web.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.epam.training.sportsbetting.domain.Currency;
import com.epam.training.sportsbetting.domain.Player;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PlayerDetailedDto {

	public PlayerDetailedDto(Player player) {
		name = player.getName();
		balance = player.getBalance();
		currency = player.getCurrency();
		accountNumber = player.getAccountNumber();
		birth = player.getBirth();
	} 

	@NotNull
	@NotEmpty
    private String name;

	@NotNull
	@Min(value = 0)
	private BigDecimal balance;

	@NotNull
	private Currency currency;

	@NotNull
	private int accountNumber;

	private LocalDate birth;

}
