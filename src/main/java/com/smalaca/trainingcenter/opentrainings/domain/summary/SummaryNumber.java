package com.smalaca.trainingcenter.opentrainings.domain.summary;

import java.util.UUID;

// Value Object
class SummaryNumber {
    private final String value;

    private SummaryNumber(String value) {
        this.value = value;
    }

    // Factory
    public static SummaryNumber create() {
        return new SummaryNumber("Summary/" + UUID.randomUUID());
    }
}
