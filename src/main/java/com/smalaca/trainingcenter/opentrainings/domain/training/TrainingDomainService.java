package com.smalaca.trainingcenter.opentrainings.domain.training;

import com.google.common.collect.ImmutableList;
import com.smalaca.trainingcenter.opentrainings.domain.training.events.AttendeeMovedEvent;

public class TrainingDomainService {
    public MoveTrainingResponse move(Training trainingFrom, Training trainingTo, AttendeeId attendeeId) {
        // opcja 1
        trainingFrom.removeAttendee(attendeeId);
        trainingTo.addAttendee(attendeeId);
        // opcja 2
        // trainingFrom.moveTo(attendeeId, trainingTo);

        AttendeeMovedEvent event = AttendeeMovedEvent.create(
                trainingFrom.getId(), trainingTo.getId(), attendeeId);

        return new MoveTrainingResponse(event, ImmutableList.of(trainingFrom, trainingTo));
    }
}
