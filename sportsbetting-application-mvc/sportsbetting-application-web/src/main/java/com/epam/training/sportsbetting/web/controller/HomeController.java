package com.epam.training.sportsbetting.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.epam.training.sportsbetting.application.service.PlayerService;
import com.epam.training.sportsbetting.domain.Currency;
import com.epam.training.sportsbetting.domain.Wager;
import com.epam.training.sportsbetting.web.dto.PlayerDetailedDto;
import com.epam.training.sportsbetting.web.dto.WagerListElementDto;
import com.epam.training.sportsbetting.web.service.UserService;

@Controller
public class HomeController {

	@Autowired private PlayerService playerService;
	@Autowired private UserService userService;

	@ModelAttribute
	public void addPlayerDetails(Model model) {
		if (!model.containsAttribute("playerDetails")) {
			model.addAttribute("playerDetails", new PlayerDetailedDto(userService.getLoggedInPlayer()));			
		}
	}
	
	@ModelAttribute
	public void addCurrencies(Model model) {
        model.addAttribute("currencies", Currency.values());
	}

	@ModelAttribute
	public void addErrorMessageIfNeeded(Model model, @RequestParam(required = false) String error) {
		if (error != null) {
			model.addAttribute("errorMessage", "Player details are invalid");
		}
	}

	@ModelAttribute
	public void addWagerList(Model model) {
		List<Wager> wagers = playerService.findWagersForPlayer(userService.getLoggedInPlayer());
		List<WagerListElementDto> wagerDtos = new ArrayList<WagerListElementDto>();
		wagers.stream().forEach(w -> wagerDtos.add(new WagerListElementDto(w)));
		model.addAttribute("wagers", wagerDtos);
	}

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String getHomePage() {
		return "homepage";
	}
}
