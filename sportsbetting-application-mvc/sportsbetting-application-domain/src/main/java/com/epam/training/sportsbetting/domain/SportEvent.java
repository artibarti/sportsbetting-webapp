package com.epam.training.sportsbetting.domain;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public abstract class SportEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", nullable = false)
    protected long id;

    @Version
    private long version;

    @Column(name = "TITLE", nullable = false)
    protected String title;

    @Column(name = "VALID_FROM", nullable = false)
    protected LocalDateTime validFrom;

    @Column(name = "VALID_UNTIL", nullable = false)
    protected LocalDateTime validUntil;
    
    public SportEvent(String eventTitle, LocalDateTime availableFrom, LocalDateTime availableUntil) {
        title = eventTitle;
        validFrom = availableFrom;
        validUntil = availableUntil;
    }
}
