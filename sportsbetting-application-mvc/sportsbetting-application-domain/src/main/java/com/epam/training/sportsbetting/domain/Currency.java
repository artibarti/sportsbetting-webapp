package com.epam.training.sportsbetting.domain;

/**
 * Representing the possible currencies can
 * be rendered to the balance of a player.
 */
public enum Currency {

    HUF("HUF"), EUR("EUR"), USD("USD");

    private String currency;

    Currency(String currency) {
        this.currency = currency;
    }

    @Override
    public String toString() {
        return currency;
    }
}
