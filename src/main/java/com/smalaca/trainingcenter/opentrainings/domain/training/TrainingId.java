package com.smalaca.trainingcenter.opentrainings.domain.training;

import java.util.UUID;

// Value Object
class TrainingId {
    private final UUID value;

    TrainingId(UUID value) {
        this.value = value;
    }
}
