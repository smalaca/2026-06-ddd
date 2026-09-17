package com.smalaca.trainingcenter.opentrainings.domain.training;

import java.util.UUID;

// Value object
public class TrainerId {
    private final UUID value;

    public TrainerId(UUID value) {
        this.value = value;
    }
}
