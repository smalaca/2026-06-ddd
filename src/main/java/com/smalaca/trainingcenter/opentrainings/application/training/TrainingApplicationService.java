package com.smalaca.trainingcenter.opentrainings.application.training;

import com.smalaca.trainingcenter.opentrainings.domain.training.*;
import com.smalaca.trainingcenter.opentrainings.domain.training.commands.AddTrainingDomainCommand;

import java.util.UUID;

public class TrainingApplicationService {
    private final TrainingRepository trainingRepository;

    public TrainingApplicationService(TrainingRepository trainingRepository) {
        this.trainingRepository = trainingRepository;
    }

    public UUID addTraining(AddTrainingCommand command) {
        TrainingDefinitionId trainingDefinitionId = new TrainingDefinitionId(command.trainingDefinitionId());
        TrainerId trainerId = new TrainerId(command.trainerId());
        Period period = new Period(command.startDate(), command.endDate());
        Price price = Price.from(command.price());
        AddTrainingDomainCommand domainCommand = new AddTrainingDomainCommand(
                trainingDefinitionId, trainerId, period);

        Training training = Training.create(domainCommand);

        return trainingRepository.save(training);
    }
}
