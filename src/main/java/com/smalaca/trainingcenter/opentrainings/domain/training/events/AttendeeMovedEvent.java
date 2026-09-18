package com.smalaca.trainingcenter.opentrainings.domain.training.events;

import com.smalaca.trainingcenter.opentrainings.domain.eventid.EventId;
import com.smalaca.trainingcenter.opentrainings.domain.training.AttendeeId;
import com.smalaca.trainingcenter.opentrainings.domain.training.TrainingId;

public class AttendeeMovedEvent {
    private final EventId eventId;
    private final TrainingId trainingFromId;
    private final TrainingId trainingToId;
    private final AttendeeId attendeeId;

    private AttendeeMovedEvent(
            EventId eventId, TrainingId trainingFromId, TrainingId trainingToId, AttendeeId attendeeId) {
        this.eventId = eventId;
        this.trainingFromId = trainingFromId;
        this.trainingToId = trainingToId;
        this.attendeeId = attendeeId;
    }

    public static AttendeeMovedEvent create(
            TrainingId trainingFromId, TrainingId trainingToId, AttendeeId attendeeId) {
        return new AttendeeMovedEvent(EventId.create(), trainingFromId, trainingToId, attendeeId);
    }
}
