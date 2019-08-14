package com.epam.training.sportsbetting.web.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.epam.training.sportsbetting.web.validation.MatchingPasswords;
import com.epam.training.sportsbetting.web.validation.ValidEmail;

import lombok.Data;

@Data
@MatchingPasswords
public class PlayerRegisterDto {

	@NotNull
	@NotEmpty
	private String name;

	@NotNull
	@NotEmpty
	@ValidEmail
	private String emailAddress;

	@NotNull
	@NotEmpty
	private String password;

	@NotNull
	@NotEmpty
	private String matchingPassword;
}
