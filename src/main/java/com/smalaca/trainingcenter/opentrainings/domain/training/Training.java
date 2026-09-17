package com.smalaca.trainingcenter.opentrainings.domain.training;

// Aggregate Root
// Entity
public class Training {
    private final TrainingNumber trainingNumber;

    private Training(TrainingNumber trainingNumber) {
        this.trainingNumber = trainingNumber;
    }

    // Factory
    public static Training create() {
        TrainingNumber trainingNumber = TrainingNumber.create();
        return new Training(trainingNumber);
    }
}
