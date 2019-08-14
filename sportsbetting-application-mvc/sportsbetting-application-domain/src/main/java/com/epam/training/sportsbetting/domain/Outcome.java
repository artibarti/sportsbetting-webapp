package com.epam.training.sportsbetting.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Version;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Representing a possible outcome of an event.
 */
@Entity
@NoArgsConstructor
@Data
public class Outcome {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private long id;

    @Version
    private long version;

    @Column(name = "VALUE")
    private String description;
    
    @ManyToOne
    private Bet bet;
    
    public Outcome(Bet bet, String desc) {
    	this.bet = bet;
    	description = desc;
    }
}
