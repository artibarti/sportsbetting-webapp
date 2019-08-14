package com.epam.training.sportsbetting.domain;

/**
 * Type of an outcome. OutcomeType is used
 * to enrich {@link OutcomeGroup} class.
 */
public enum BetType {

    WINNER("Winner"), GOALS("Goals"), PLAYER_SCORES("Scorers"), NUMBER_OF_SETS("Number of sets");

    private String outcomeType;

    BetType(String type) {
        this.outcomeType = type;
    }

    @Override
    public String toString() {
        return outcomeType;
    }
}
