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

import com.epam.training.sportsbetting.application.service.EventService;
import com.epam.training.sportsbetting.application.service.BetService;
import com.epam.training.sportsbetting.domain.Bet;
import com.epam.training.sportsbetting.domain.SportEvent;
import com.epam.training.sportsbetting.web.dto.EventDetailedDto;
import com.epam.training.sportsbetting.web.dto.BetListElementDto;

@Controller
public class BetController {

	@Autowired private BetService betService;
	@Autowired private EventService eventService;

	@ModelAttribute
	public void initForm(@PathVariable("eventId") long eventId, Model model) {
		SportEvent event = eventService.findById(eventId);
		
		List<Bet> bets = betService.findbyEvent(event);
		List<BetListElementDto> betDtos = new ArrayList<BetListElementDto>();
		bets.stream().forEach(og -> betDtos.add(new BetListElementDto(og)));
		
		model.addAttribute("bets", betDtos);
		model.addAttribute("event", new EventDetailedDto(event));
	}
	
	@RequestMapping(value = "/events/{eventId}/bets", method = RequestMethod.GET)
	public String getOutcomeGroupsForEvent() {
		return "bets";
	}
}
