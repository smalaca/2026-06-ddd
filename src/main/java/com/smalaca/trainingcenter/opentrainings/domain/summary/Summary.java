package com.smalaca.trainingcenter.opentrainings.domain.summary;

// Aggregate Root
// Entity
public class Summary {
    private final SummaryNumber summaryNumber;

    private Summary(SummaryNumber summaryNumber) {
        this.summaryNumber = summaryNumber;
    }

    // Factory
    public static Summary create() {
        return new Summary(SummaryNumber.create());
    }
}
