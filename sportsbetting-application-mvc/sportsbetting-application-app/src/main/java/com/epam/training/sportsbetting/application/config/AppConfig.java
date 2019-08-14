package com.epam.training.sportsbetting.application.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.epam.training.sportsbetting.application.service.BetService;
import com.epam.training.sportsbetting.application.service.DefaultBetService;
import com.epam.training.sportsbetting.application.service.DefaultEventService;
import com.epam.training.sportsbetting.application.service.DefaultOutcomeOddService;
import com.epam.training.sportsbetting.application.service.DefaultOutcomeService;
import com.epam.training.sportsbetting.application.service.DefaultPlayerService;
import com.epam.training.sportsbetting.application.service.DefaultResultService;
import com.epam.training.sportsbetting.application.service.DefaultWagerService;
import com.epam.training.sportsbetting.application.service.EventService;
import com.epam.training.sportsbetting.application.service.OutcomeOddService;
import com.epam.training.sportsbetting.application.service.OutcomeService;
import com.epam.training.sportsbetting.application.service.PlayerService;
import com.epam.training.sportsbetting.application.service.ResultService;
import com.epam.training.sportsbetting.application.service.WagerService;

/**
 * Bean configuration for the module. 
 */
@Configuration
@Import(SpringDataSourceConfig.class)
@ComponentScan(basePackages = "com.epam.training.sportsbetting.application.*")
public class AppConfig {
	
    @Bean
    WagerService wagerService() {
        return new DefaultWagerService();
    }

    @Bean
    PlayerService playerService() {
        return new DefaultPlayerService();
    }

    @Bean
    EventService eventService() {
        return new DefaultEventService();
    }

    @Bean
    ResultService resultService() {
        return new DefaultResultService();
    }

    @Bean
    BetService betService() {
        return new DefaultBetService();
    }

    @Bean
    OutcomeService outcomeService() {
        return new DefaultOutcomeService();
    }

    @Bean
    OutcomeOddService outcomeOddService() {
        return new DefaultOutcomeOddService();
    }
}
