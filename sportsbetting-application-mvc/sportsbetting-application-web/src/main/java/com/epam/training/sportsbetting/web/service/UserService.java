package com.epam.training.sportsbetting.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.epam.training.sportsbetting.application.service.PlayerService;
import com.epam.training.sportsbetting.domain.Player;

@Service
public class UserService {

	@Autowired
	private PlayerService playerService;

	public Player getLoggedInPlayer() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		Player loggedInPlayer = ((UserPrincipal) authentication.getPrincipal()).getPlayer();
		return playerService.findPlayerById(loggedInPlayer.getId());
	}
}
