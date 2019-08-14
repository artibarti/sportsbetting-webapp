package com.epam.training.sportsbetting.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Version;

import lombok.Data;

@Data
@Entity
public class Result {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private long id;

    @Version
    private long version;

    @OneToMany(fetch = FetchType.EAGER)
    private List<Outcome> winnerOutcomes = new ArrayList<Outcome>();
    
    @OneToOne
    private SportEvent event;
    
    public void addWinnerOutcome(Outcome outcome) {
        winnerOutcomes.add(outcome);
    }
}
