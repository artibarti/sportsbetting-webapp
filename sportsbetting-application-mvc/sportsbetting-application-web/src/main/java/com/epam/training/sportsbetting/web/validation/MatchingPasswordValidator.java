package com.epam.training.sportsbetting.web.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.epam.training.sportsbetting.web.dto.PlayerRegisterDto;

public class MatchingPasswordValidator implements ConstraintValidator<MatchingPasswords, Object> {

	@Override
	public void initialize(MatchingPasswords constraintAnnotation) {
	}

	@Override
	public boolean isValid(Object obj, ConstraintValidatorContext context) {
		PlayerRegisterDto player = (PlayerRegisterDto) obj;
		return player.getPassword().equals(player.getMatchingPassword());
	}

}
