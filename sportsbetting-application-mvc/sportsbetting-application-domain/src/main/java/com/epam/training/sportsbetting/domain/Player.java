package com.epam.training.sportsbetting.domain;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Representing a player with basic details.
 */
@Entity
@Data
@EqualsAndHashCode(callSuper=true)
@NoArgsConstructor
@ToString
public class Player extends User {

    @Column(name = "NAME")
    private String name;

    @Column(name = "BALANCE")
    private BigDecimal balance;

    @Enumerated(EnumType.STRING)
    @Column(name = "CURRENCY")
    private Currency currency;

    @Column(name = "ACCOUNT_NUMBER")
    private int accountNumber;
    
    @Column(name = "BIRTH_DATE")
    private LocalDate birth;
}
