package com.smalaca.trainingcenter.opentrainings.domain.summary;

import java.util.UUID;

// value object
class SummaryId {
    private final UUID value;

    SummaryId(UUID value) {
        this.value = value;
    }
}
