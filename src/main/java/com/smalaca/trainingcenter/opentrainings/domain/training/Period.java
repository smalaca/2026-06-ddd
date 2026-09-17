package com.smalaca.trainingcenter.opentrainings.domain.training;

import java.time.LocalDate;

// Value object
public class Period {
    private final LocalDate startDate;
    private final LocalDate endDate;

    public Period(LocalDate startDate, LocalDate endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
    }
}
