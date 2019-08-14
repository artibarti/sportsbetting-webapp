package com.epam.training.sportsbetting.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.epam.training.sportsbetting.web.service.SportsBettingDatabasePopulator;

@Controller
public class DatabasePopulatingController {
	
	@Autowired
	SportsBettingDatabasePopulator populator;

	@RequestMapping(value = "/database/populate", method = RequestMethod.GET)
	public String populateDatabase() {
		populator.populate();
		return "redirect:/home";
	}

	@RequestMapping(value = "/database/clear", method = RequestMethod.GET)
	public String clearDatabase() {
		populator.clear();
		return "redirect:/home";
	}
}
