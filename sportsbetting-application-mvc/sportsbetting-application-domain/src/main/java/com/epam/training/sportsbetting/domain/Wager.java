package com.epam.training.sportsbetting.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Version;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Wager {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", nullable = false)
    private long id;

    @Version
    private long version;

    @ManyToOne
    private SportEvent event;
    
    @ManyToOne(fetch = FetchType.EAGER)
    private Player player;
    
    @Column(name = "AMOUNT", nullable=false)
    private BigDecimal amount;

    @ManyToOne
    private OutcomeOdd outcomeOdd;
    
    @Column(name = "WINNER")
    private boolean winner;

    @Column(name = "PROCESSED")
    private boolean processed;

    @Column(name = "CREATED")
    private LocalDateTime created;
    
    public Wager(SportEvent event, Player player, BigDecimal amount, OutcomeOdd outcomeOdd) {
        this.player = player;
        this.amount = amount;
        this.outcomeOdd = outcomeOdd;
        this.created = LocalDateTime.now();
    }
}
