package com.smalaca.trainingcenter.opentrainings.domain.training;

import java.time.LocalDate;

// Value object
public class Period {
    private final LocalDate startDate;
    private final LocalDate endDate;

    private Period(LocalDate startDate, LocalDate endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
    }

    // factory
    public static Period from(LocalDate startDate, LocalDate endDate) {
        if (LocalDate.now().plusMonths(1).isAfter(startDate)) {
            throw PeriodException.toEarlyStart(startDate);
        }
        if (startDate.isAfter(endDate)) {
            throw PeriodException.invalidRange(startDate, endDate);
        }
        return new Period(startDate, endDate);
    }
}
