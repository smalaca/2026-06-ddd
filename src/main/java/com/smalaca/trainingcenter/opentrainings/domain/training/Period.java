package com.smalaca.trainingcenter.opentrainings.domain.training;

import com.smalaca.trainingcenter.opentrainings.domain.clock.Clock;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

// Value object
public class Period {
    private final LocalDate startDate;
    private final LocalDate endDate;

    private Period(LocalDate startDate, LocalDate endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
    }

    // factory
    public static Period from(Clock clock, LocalDate startDate, LocalDate endDate) {
        if (clock.now().plusMonths(1).isAfter(startDate)) {
            throw PeriodException.toEarlyStart(startDate);
        }
        if (startDate.isAfter(endDate)) {
            throw PeriodException.invalidRange(startDate, endDate);
        }
        return new Period(startDate, endDate);
    }

    public boolean hasDurationEqualTo(int duration) {
        return ChronoUnit.DAYS.between(startDate, endDate) == duration;
    }
}
