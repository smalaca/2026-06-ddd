package com.smalaca.trainingcenter.opentrainings.domain.summary;

import com.smalaca.trainingcenter.opentrainings.domain.training.TrainingId;

// Aggregate Root
// Entity
public class Summary {
    private SummaryId summaryId;
    private final SummaryNumber summaryNumber;
    private final TrainingId trainingId;

    private Summary(SummaryNumber summaryNumber, TrainingId trainingId) {
        this.summaryNumber = summaryNumber;
        this.trainingId = trainingId;
    }

    // Factory
    public static Summary create(TrainingId trainingId) {
        return new Summary(SummaryNumber.create(), trainingId);
    }
}
