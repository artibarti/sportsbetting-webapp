package com.epam.training.sportsbetting.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.epam.training.sportsbetting.application.service.EventService;
import com.epam.training.sportsbetting.domain.SportEvent;
import com.epam.training.sportsbetting.web.dto.EventListElementDto;

@Controller
public class EventController {

	@Autowired
	private EventService eventService;
	
	@ModelAttribute
	public void findAllEvents(Model model) {
		List<SportEvent> events = eventService.findAllEvents();
		List<EventListElementDto> eventDtos = new ArrayList<EventListElementDto>();
		events.stream().forEach(e -> eventDtos.add(new EventListElementDto(e)));
		model.addAttribute("events", eventDtos);
	}
	
	@RequestMapping(value = "/events", method = RequestMethod.GET)
	public String getEventsPage() {
		return "events";
	}	
}