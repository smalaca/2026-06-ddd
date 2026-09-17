package com.smalaca.trainingcenter.opentrainings.domain.training;

import com.smalaca.trainingcenter.opentrainings.domain.training.commands.AddTrainingDomainCommand;

// Aggregate Root
// Entity
public class Training {
    private TrainingId trainingId;
    private final TrainingNumber trainingNumber;
    private final TrainingDefinitionId trainingDefinitionId;
    private final TrainerId trainerId;
    private final Period period;

    private Training(TrainingNumber trainingNumber, TrainingDefinitionId trainingDefinitionId, TrainerId trainerId, Period period) {
        this.trainingNumber = trainingNumber;
        this.trainingDefinitionId = trainingDefinitionId;
        this.trainerId = trainerId;
        this.period = period;
    }

    // Factory
    public static Training create(AddTrainingDomainCommand command) {
        TrainingNumber trainingNumber = TrainingNumber.create();
        return new Training(trainingNumber, command.trainingDefinitionId(), command.trainerId(), command.period());
    }
}
