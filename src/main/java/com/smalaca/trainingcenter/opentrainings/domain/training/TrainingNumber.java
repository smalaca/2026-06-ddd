package com.smalaca.trainingcenter.opentrainings.domain.training;

import java.util.UUID;

// Value Object
class TrainingNumber {
    private final String value;

    private TrainingNumber(String value) {
        this.value = value;
    }

    // Factory
    static TrainingNumber create() {
        return new TrainingNumber(UUID.randomUUID() + "/Training");
    }
}
