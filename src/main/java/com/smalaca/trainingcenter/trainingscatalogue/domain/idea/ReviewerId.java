package com.smalaca.trainingcenter.trainingscatalogue.domain.idea;

import java.util.UUID;

// Value Object
public class ReviewerId {
    private final UUID value;

    public ReviewerId(UUID value) {
        this.value = value;
    }
}
