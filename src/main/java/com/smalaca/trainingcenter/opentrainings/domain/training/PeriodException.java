package com.smalaca.trainingcenter.opentrainings.domain.training;

import java.time.LocalDate;

class PeriodException extends RuntimeException{
    private PeriodException(String message) {
        super(message);
    }

    static PeriodException toEarlyStart(LocalDate startDate) {
        return new PeriodException("Start date: " + startDate + ", must be at least one month in the future");
    }

    static PeriodException invalidRange(LocalDate startDate, LocalDate endDate) {
        return new PeriodException("End date: " + endDate + ", must be after start date: " + startDate + ".");
    }
}
