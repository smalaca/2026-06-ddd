package com.smalaca.trainingcenter.opentrainings.application.training;

import com.smalaca.trainingcenter.opentrainings.domain.training.Training;
import com.smalaca.trainingcenter.opentrainings.domain.training.TrainingRepository;

import java.util.UUID;

public class TrainingApplicationService {
    private final TrainingRepository trainingRepository;

    public TrainingApplicationService(TrainingRepository trainingRepository) {
        this.trainingRepository = trainingRepository;
    }

    public UUID addTraining() {
        Training training = Training.create();

        return trainingRepository.save(training);
    }
}
