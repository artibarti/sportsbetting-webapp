package com.epam.training.sportsbetting.web.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.epam.training.sportsbetting.application.service.PlayerService;
import com.epam.training.sportsbetting.domain.Player;
import com.epam.training.sportsbetting.web.dto.PlayerDetailedDto;
import com.epam.training.sportsbetting.web.service.UserService;

@Controller
public class UpdatePlayerController {

	@Autowired private PlayerService playerService;
	@Autowired private UserService userService;
	
	@RequestMapping(value = "/player/update", method = RequestMethod.POST)
	public String updatePlayerInfo(@Valid PlayerDetailedDto playerDetailedDto, BindingResult result,
		RedirectAttributes redirectAttributes) {

		if (result.hasErrors()) {
            redirectAttributes.addFlashAttribute("playerDetails", playerDetailedDto);
			return "redirect:/home?error";
		} else {
			merge(playerDetailedDto, userService.getLoggedInPlayer());
			return "redirect:/home";
		}
	}
	
	private void merge(PlayerDetailedDto playerDetailedDto, Player player) {
		player.setName(playerDetailedDto.getName());
		player.setBirth(playerDetailedDto.getBirth());
		player.setBalance(playerDetailedDto.getBalance());
		player.setCurrency(playerDetailedDto.getCurrency());
		player.setAccountNumber(playerDetailedDto.getAccountNumber());
		playerService.savePlayer(player);
	}
}
