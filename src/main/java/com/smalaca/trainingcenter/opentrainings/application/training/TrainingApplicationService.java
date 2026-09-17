package com.smalaca.trainingcenter.opentrainings.application.training;

import java.util.UUID;

public class TrainingApplicationService {
    private final TraningRepository trainingRepository;

    public TrainingApplicationService(TraningRepository trainingRepository) {
        this.trainingRepository = trainingRepository;
    }

    public UUID addTraining() {
        Training training = Training.create();

        return trainingRepository.save(training);
    }
}
