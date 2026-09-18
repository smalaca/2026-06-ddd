package com.smalaca.trainingcenter.opentrainings.domain.training;

import com.google.common.collect.ImmutableList;

public class TrainingDomainService {
    public ImmutableList<Training> move(Training trainingFrom, Training trainingTo, AttendeeId attendeeId) {
        trainingFrom.removeAttendee(attendeeId);
        trainingTo.addAttendee(attendeeId);

        return ImmutableList.of(trainingFrom, trainingTo);
    }
}
