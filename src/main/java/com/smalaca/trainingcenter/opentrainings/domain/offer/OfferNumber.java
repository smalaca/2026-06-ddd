package com.smalaca.trainingcenter.opentrainings.domain.offer;

import java.util.UUID;

// Value Object
class OfferNumber {
    private final String value;

    private OfferNumber(String value) {
        this.value = value;
    }

    // Factory
    public static OfferNumber create() {
        return new OfferNumber("Offer/" + UUID.randomUUID());
    }
}
