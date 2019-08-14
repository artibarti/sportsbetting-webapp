package com.epam.training.sportsbetting.domain;

import java.math.BigDecimal;

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
 * Representing the actual odd of an outcome.
 */
@Entity
@NoArgsConstructor
@Data
public class OutcomeOdd {

	public OutcomeOdd(BigDecimal odd, Outcome outcome) {
		this.odd = odd;
		this.outcome = outcome;
	}

    @Version
    private long version;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private long id;

    @Column(name = "ODD")
    private BigDecimal odd;

    @ManyToOne
    private Outcome outcome;
}
