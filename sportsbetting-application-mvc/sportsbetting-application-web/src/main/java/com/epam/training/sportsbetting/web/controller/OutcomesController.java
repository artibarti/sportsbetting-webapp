package com.epam.training.sportsbetting.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.epam.training.sportsbetting.application.service.BetService;
import com.epam.training.sportsbetting.application.service.OutcomeOddService;
import com.epam.training.sportsbetting.application.service.OutcomeService;
import com.epam.training.sportsbetting.domain.Bet;
import com.epam.training.sportsbetting.domain.Outcome;
import com.epam.training.sportsbetting.domain.OutcomeOdd;
import com.epam.training.sportsbetting.domain.Player;
import com.epam.training.sportsbetting.web.dto.OutcomeListElementDto;
import com.epam.training.sportsbetting.web.dto.WagerDto;
import com.epam.training.sportsbetting.web.service.UserService;

@Controller
public class OutcomesController {

	@Autowired private OutcomeService outcomeService;
	@Autowired private OutcomeOddService outcomeOddService;
	@Autowired private BetService betService;
	@Autowired private UserService userService;

	@ModelAttribute
	public void addOutcomes(Model model, @PathVariable("betId") long betId) {
		Bet bet = betService.findById(betId);
		List<Outcome> outcomes = outcomeService.findByBet(bet);
		List<OutcomeOdd> outcomeOdds = new ArrayList<OutcomeOdd>();
		outcomes.stream().forEach(o -> outcomeOdds.addAll(outcomeOddService.findByOutcome(o)));
		List<OutcomeListElementDto> outcomeDtos = new ArrayList<OutcomeListElementDto>();
		outcomeOdds.stream().forEach(o -> outcomeDtos.add(new OutcomeListElementDto(o)));
		model.addAttribute("outcomes", outcomeDtos);
	}
	
	@ModelAttribute
	public void addBalance(Model model) {
		Player loggedInPlayer = userService.getLoggedInPlayer();
		model.addAttribute("balance", loggedInPlayer.getBalance());
	}

	@ModelAttribute
	public void addWagerDto(Model model) {
		model.addAttribute("wager", new WagerDto());
	}

	@RequestMapping(value = "/events/{eventId}/bets/{betId}/outcomes", method = RequestMethod.GET)
	public String getOutcomesForOutcomeGroup() {
		return "outcomes";
	}
}
