package com.epam.training.sportsbetting.web.controller;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.epam.training.sportsbetting.application.service.PlayerService;
import com.epam.training.sportsbetting.domain.Currency;
import com.epam.training.sportsbetting.domain.Player;
import com.epam.training.sportsbetting.web.dto.PlayerRegisterDto;

@Controller
public class RegistrationController {

	@Autowired private PasswordEncoder passwordEncoder;
	@Autowired private PlayerService playerService;
	
	@ModelAttribute
	public void addRegisterDto(Model model) {
		if (!model.containsAttribute("playerRegisterDto")) {
			model.addAttribute("playerRegisterDto", new PlayerRegisterDto());
		}
	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String getRegistrationForm() {
		return "register";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registerPlayer(@Valid PlayerRegisterDto playerRegisterDto, BindingResult result) {
		if (result.hasErrors()) {
			return "register";
		} else {
			register(playerRegisterDto, result);
			return "redirect:/login";
		}
	}
	
	private Player register(PlayerRegisterDto playerRegisterDto, BindingResult result) {

		Player registeredPlayer = new Player();
		registeredPlayer.setAccountNumber(12345678);
		registeredPlayer.setBalance(new BigDecimal(2000));
		registeredPlayer.setBirth(LocalDate.now());
		registeredPlayer.setCurrency(Currency.EUR);
		registeredPlayer.setName(playerRegisterDto.getName());
		registeredPlayer.setEmail(playerRegisterDto.getEmailAddress());
		registeredPlayer.setPassword(passwordEncoder.encode(playerRegisterDto.getPassword()));
		playerService.savePlayer(registeredPlayer);
	    
	    return registeredPlayer;
	}
}
