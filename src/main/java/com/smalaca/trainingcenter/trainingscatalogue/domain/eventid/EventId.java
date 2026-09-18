package com.smalaca.trainingcenter.trainingscatalogue.domain.eventid;

import java.time.LocalDate;
import java.util.UUID;

public record EventId(UUID eventId, UUID traceId, LocalDate creationDate) {
    public static EventId create() {
        return new EventId(UUID.randomUUID(), UUID.randomUUID(), LocalDate.now());
    }
}
