package com.smalaca.trainingcenter.opentrainings.domain.training;

import com.google.common.collect.ImmutableList;
import com.smalaca.trainingcenter.opentrainings.domain.training.events.AttendeeMovedEvent;

public class TrainingDomainService {
    public MoveTrainingResponse moveAttendee(Training trainingFrom, Training trainingTo, AttendeeId attendeeId) {
        // opcja 1
        trainingFrom.removeAttendee(attendeeId);
        trainingTo.addAttendee(attendeeId);

        // opcja 2
//         trainingFrom.moveTo(attendeeId, trainingTo);

        AttendeeMovedEvent event = AttendeeMovedEvent.create(
                trainingFrom.getId(), trainingTo.getId(), attendeeId);

        return new MoveTrainingResponse(event, ImmutableList.of(trainingFrom, trainingTo));
    }

    public void moveTrainer(Training trainingFrom, Training trainingTo) {
        TrainerId trainerIdFrom = trainingFrom.getTrainerId();
        TrainerId trainerIdTo = trainingTo.getTrainerId();
        trainingFrom.change(trainerIdTo);
        trainingTo.change(trainerIdFrom);
    }
}
