package com.smalaca.trainingcenter.opentrainings.domain.training;

import java.util.UUID;

// Repository
public interface TrainingRepository {
    UUID save(Training training);
}
