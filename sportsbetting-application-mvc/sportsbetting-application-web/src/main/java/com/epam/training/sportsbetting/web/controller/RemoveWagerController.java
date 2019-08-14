package com.epam.training.sportsbetting.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.epam.training.sportsbetting.application.service.PlayerService;
import com.epam.training.sportsbetting.application.service.WagerService;
import com.epam.training.sportsbetting.domain.Player;
import com.epam.training.sportsbetting.domain.Wager;
import com.epam.training.sportsbetting.web.service.UserService;

@Controller
public class RemoveWagerController {

	@Autowired private WagerService wagerService;
	@Autowired private PlayerService playerService;
	@Autowired private UserService userService;

	@RequestMapping(value = "/wager/{wagerId}/remove", method = RequestMethod.GET)
	public String removeWager(@PathVariable("wagerId") long wagerId) {
		remove(wagerId);
		return "redirect:/home";
	}
	
	private void remove(long wagerId) {
		Player loggedInPlayer = userService.getLoggedInPlayer();
		Wager wager = wagerService.findById(wagerId);
		if (wager != null && wager.getPlayer().equals(loggedInPlayer)) {
			wagerService.removeWager(wager);
			playerService.increaseBalanceForPlayer(loggedInPlayer, wager.getAmount());
		}
	}
}
