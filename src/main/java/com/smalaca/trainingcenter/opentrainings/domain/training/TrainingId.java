package com.smalaca.trainingcenter.opentrainings.domain.training;

import java.util.UUID;

// Value Object
public class TrainingId {
    private final UUID value;

    public TrainingId(UUID value) {
        this.value = value;
    }
}
