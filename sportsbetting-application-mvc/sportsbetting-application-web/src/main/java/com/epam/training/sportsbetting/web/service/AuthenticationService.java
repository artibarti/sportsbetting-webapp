package com.epam.training.sportsbetting.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.epam.training.sportsbetting.application.storage.PlayerRepository;
import com.epam.training.sportsbetting.domain.Player;

@Service
@Transactional
public class AuthenticationService implements UserDetailsService {

    @Autowired
    private PlayerRepository playerRepository;

    public UserDetails loadUserByUsername(String email)
      throws UsernameNotFoundException {
  
        Player player = playerRepository.findByEmail(email);
        if (player == null) {
        	throw new UsernameNotFoundException("No user found with username: "+ email);
        }
        return new UserPrincipal(player);        
    }     
}
