package com.smalaca.trainingcenter.opentrainings.domain.offer;

import java.util.UUID;

// value object
class OfferId {
    private final UUID value;

    OfferId(UUID value) {
        this.value = value;
    }
}
