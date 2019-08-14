package com.epam.training.sportsbetting.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.epam.training.sportsbetting.application.service.OutcomeOddService;
import com.epam.training.sportsbetting.application.service.PlayerService;
import com.epam.training.sportsbetting.application.service.WagerService;
import com.epam.training.sportsbetting.domain.OutcomeOdd;
import com.epam.training.sportsbetting.domain.Player;
import com.epam.training.sportsbetting.domain.Wager;
import com.epam.training.sportsbetting.web.dto.WagerDto;
import com.epam.training.sportsbetting.web.service.UserService;

@Controller
public class SaveWagerController {

	@Autowired private WagerService wagerService;
	@Autowired private OutcomeOddService outcomeOddService;
	@Autowired private PlayerService playerService;
	@Autowired private UserService userService;

	@RequestMapping(value = "/wager/save", method = RequestMethod.POST)
	public String saveWager(WagerDto wagerDto) {
		save(wagerDto);
		return "redirect:/home";
	}
	
	private void save(WagerDto wagerDto) {
		OutcomeOdd outcomeOdd = outcomeOddService.findById(wagerDto.getOutcomeOddId());
		Player loggedInPlayer = userService.getLoggedInPlayer();

		Wager wager = new Wager();
		wager.setOutcomeOdd(outcomeOdd);
		wager.setAmount(wagerDto.getAmount());
		wager.setEvent(outcomeOdd.getOutcome().getBet().getEvent());
		wager.setWinner(false);
		wager.setProcessed(false);
		wager.setPlayer(loggedInPlayer);

		wagerService.addWager(wager);
		playerService.decreaseBalanceForPlayer(loggedInPlayer, wager.getAmount());
	}
}
