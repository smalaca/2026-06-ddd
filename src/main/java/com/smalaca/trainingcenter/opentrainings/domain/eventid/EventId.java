package com.smalaca.trainingcenter.opentrainings.domain.eventid;

import java.time.LocalDate;
import java.util.UUID;

public record EventId(UUID eventId, UUID traceId, LocalDate creationDate) {
    public static EventId create() {
        return new EventId(UUID.randomUUID(), UUID.randomUUID(), LocalDate.now());
    }
}
