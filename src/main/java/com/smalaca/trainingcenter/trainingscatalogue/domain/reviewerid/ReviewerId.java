package com.smalaca.trainingcenter.trainingscatalogue.domain.reviewerid;

import java.util.UUID;

// Value Object
public class ReviewerId {
    private final UUID value;

    public ReviewerId(UUID value) {
        this.value = value;
    }
}
