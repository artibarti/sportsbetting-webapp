package com.epam.training.sportsbetting.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Version;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Representing a group of outcomes which are all refer to
 * the same segment of an event.
 */
@Entity
@Data
@NoArgsConstructor
public class Bet {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ID")
    private long id;

    @Version
    private long version;

    @ManyToOne
    private SportEvent event;

    @Enumerated(EnumType.STRING)
    @Column(name="TYPE", nullable=false)    
    private BetType betType;

    @Column(name="DESCRIPTION", nullable=false)
    private String description;
    
    public Bet(SportEvent sportEvent, BetType type, String desc) {
    	betType = type;
        description = desc;
        event = sportEvent;
    }    
}
