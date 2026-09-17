package com.smalaca.trainingcenter.opentrainings.domain.training;

import java.util.UUID;

// Value object
public class TrainingDefinitionId {
    private final UUID value;

    public TrainingDefinitionId(UUID value) {
        this.value = value;
    }
}
