package com.epam.training.sportsbetting.web.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.epam.training.sportsbetting.domain.SportEvent;
import com.epam.training.sportsbetting.domain.Outcome;
import com.epam.training.sportsbetting.domain.OutcomeOdd;
import com.epam.training.sportsbetting.domain.Bet;
import com.epam.training.sportsbetting.domain.BetType;
import com.epam.training.sportsbetting.domain.FootballSportEvent;
import com.epam.training.sportsbetting.application.service.EventService;
import com.epam.training.sportsbetting.application.service.OutcomeOddService;
import com.epam.training.sportsbetting.application.service.BetService;
import com.epam.training.sportsbetting.application.service.OutcomeService;
import com.epam.training.sportsbetting.application.service.WagerService;

/**
 * Utility for populating the database. 
 */
@Component
public final class SportsBettingDatabasePopulator {

    @Autowired private EventService eventService;
    @Autowired private BetService betService;
    @Autowired private OutcomeService outcomeService;
    @Autowired private OutcomeOddService outcomeOddService;
    @Autowired private WagerService wagerService;
    
    private final LocalDateTime VALID_FROM = generateLocalDateTime(2000, Month.JANUARY, 1, 12);
    private final LocalDateTime VALID_UNTIL = generateLocalDateTime(2020, Month.JANUARY, 1, 12);

    private SportsBettingDatabasePopulator() {}

    public void populate() {
        generateTestEvents();
    }
    
    private LocalDateTime generateLocalDateTime(int year, Month month, int day, int hour) {
        return LocalDateTime.of(LocalDate.of(year, month, day), LocalTime.of(hour, 0));
    }

    private void generateTestEvents() {
        generateArsenalVsChesea();
        generateLiverpoolTottanham();
    }

    private void generateArsenalVsChesea() {

        SportEvent arsenalVSchelsea = new FootballSportEvent("Arsenal - Chelsea", VALID_FROM, VALID_UNTIL);

        Bet numberOfGoals = new Bet(arsenalVSchelsea, BetType.GOALS, "Number of scored goals");
        Bet winnerOfMatch = new Bet(arsenalVSchelsea, BetType.WINNER, "Winner of the match");
        Bet giroudScores = new Bet(arsenalVSchelsea, BetType.PLAYER_SCORES, "Oliver Giroud scores");
        
        Outcome oneGoal = new Outcome(numberOfGoals, "1");
        Outcome twoGoals = new Outcome(numberOfGoals, "2");
        Outcome threeGoals = new Outcome(numberOfGoals, "3");
        Outcome fourPlusGoals = new Outcome(numberOfGoals, "3+");
        Outcome arsenalWins = new Outcome(winnerOfMatch, "Arsenal");
        Outcome chelseaWins = new Outcome(winnerOfMatch, "Chelsea");
        Outcome giroudReallyScores = new Outcome(giroudScores, "Yes");
        Outcome giroudDoesntScore = new Outcome(giroudScores, "No");
        
        OutcomeOdd oddForOneGoal = new OutcomeOdd(new BigDecimal(2.3), oneGoal);
        OutcomeOdd oddForTwoGoals = new OutcomeOdd(new BigDecimal(1.6), twoGoals);
        OutcomeOdd oddForThreeGoals = new OutcomeOdd(new BigDecimal(1.4), threeGoals);
        OutcomeOdd oddForFourPlusGoals = new OutcomeOdd(new BigDecimal(1.9), fourPlusGoals);

        OutcomeOdd arsenalWinsOdd = new OutcomeOdd(new BigDecimal(1.7), arsenalWins);
        OutcomeOdd chelseaWinsOdd = new OutcomeOdd(new BigDecimal(1.86), chelseaWins);

        OutcomeOdd giroudScoresOdd = new OutcomeOdd(new BigDecimal(3.10), giroudReallyScores);
        OutcomeOdd giroudDoesntScoreOdd = new OutcomeOdd(new BigDecimal(1.2), giroudDoesntScore);

        eventService.save(arsenalVSchelsea);

        betService.save(numberOfGoals);
        betService.save(winnerOfMatch);
        betService.save(giroudScores);

        outcomeService.save(oneGoal);
        outcomeService.save(twoGoals);
        outcomeService.save(threeGoals);
        outcomeService.save(fourPlusGoals);
        outcomeService.save(arsenalWins);
        outcomeService.save(chelseaWins);
        outcomeService.save(giroudReallyScores);
        outcomeService.save(giroudDoesntScore);
    
        outcomeOddService.save(oddForOneGoal);
        outcomeOddService.save(oddForTwoGoals);
        outcomeOddService.save(oddForThreeGoals);
        outcomeOddService.save(oddForFourPlusGoals);
        outcomeOddService.save(arsenalWinsOdd);
        outcomeOddService.save(chelseaWinsOdd);
        outcomeOddService.save(giroudScoresOdd);
        outcomeOddService.save(giroudDoesntScoreOdd);

    }
    
    private void generateLiverpoolTottanham() {

        SportEvent liverpoolVsTottanham = new FootballSportEvent("Liverpool - Tottanham", VALID_FROM, VALID_UNTIL);

        Bet numberOfGoals = new Bet(liverpoolVsTottanham, BetType.GOALS, "Number of scored goals");
        Bet winnerOfMatch = new Bet(liverpoolVsTottanham, BetType.WINNER, "Winner of the match");
        Bet firminoScores = new Bet(liverpoolVsTottanham, BetType.PLAYER_SCORES, "Roberto Firmino scores");
        
        Outcome oneGoal = new Outcome(numberOfGoals, "1");
        Outcome twoGoals = new Outcome(numberOfGoals, "2");
        Outcome threeGoals = new Outcome(numberOfGoals, "3");
        Outcome fourPlusGoals = new Outcome(numberOfGoals, "3+");
        Outcome liverpoolWins = new Outcome(winnerOfMatch, "Liverpool");
        Outcome tottanhamWins = new Outcome(winnerOfMatch, "Tottanham");
        Outcome firminoReallyScores = new Outcome(firminoScores, "Yes");
        Outcome firminoDoesntScore = new Outcome(firminoScores, "No");
        
        OutcomeOdd oneGoalOdd = new OutcomeOdd(new BigDecimal(2.1), oneGoal);
        OutcomeOdd twoGoalOdd = new OutcomeOdd(new BigDecimal(1.95), twoGoals);
        OutcomeOdd threeGoalOdd = new OutcomeOdd(new BigDecimal(1.5), threeGoals);
        OutcomeOdd fourPlusGoalOdd = new OutcomeOdd(new BigDecimal(2.0), fourPlusGoals);
        OutcomeOdd liverpoolWinsOdd = new OutcomeOdd(new BigDecimal(1.4), liverpoolWins);
        OutcomeOdd tottanhamWinsOdd = new OutcomeOdd(new BigDecimal(1.97), tottanhamWins);
        OutcomeOdd firminoReallyScoresOdd = new OutcomeOdd(new BigDecimal(3.0), firminoReallyScores);
        OutcomeOdd firminoDoesntScoreOdd = new OutcomeOdd(new BigDecimal(1.45), firminoDoesntScore);

        eventService.save(liverpoolVsTottanham);

        betService.save(numberOfGoals);
        betService.save(winnerOfMatch);
        betService.save(firminoScores);

        outcomeService.save(oneGoal);
        outcomeService.save(twoGoals);
        outcomeService.save(threeGoals);
        outcomeService.save(fourPlusGoals);
        outcomeService.save(liverpoolWins);
        outcomeService.save(tottanhamWins);
        outcomeService.save(firminoReallyScores);
        outcomeService.save(firminoDoesntScore);

        outcomeOddService.save(oneGoalOdd);
        outcomeOddService.save(twoGoalOdd);
        outcomeOddService.save(threeGoalOdd);
        outcomeOddService.save(fourPlusGoalOdd);
        outcomeOddService.save(liverpoolWinsOdd);
        outcomeOddService.save(tottanhamWinsOdd);
        outcomeOddService.save(firminoReallyScoresOdd);
        outcomeOddService.save(firminoDoesntScoreOdd);
    }
    
    public void clear() {
        wagerService.removeAll();
        outcomeOddService.removeAll();
        outcomeService.removeAll();
        betService.removeAll();
        eventService.removeAll();
    }
}
