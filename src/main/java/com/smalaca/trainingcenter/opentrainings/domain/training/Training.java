package com.smalaca.trainingcenter.opentrainings.domain.training;

import com.smalaca.trainingcenter.opentrainings.domain.clock.Clock;
import com.smalaca.trainingcenter.opentrainings.domain.offer.Offer;
import com.smalaca.trainingcenter.opentrainings.domain.training.events.TrainingAcceptedEvent;

import java.util.ArrayList;
import java.util.List;

// Aggregate Root
// Entity
public class Training {
    private TrainingId trainingId;
    private final TrainingNumber trainingNumber;
    private final TrainingDefinitionId trainingDefinitionId;
    private final TrainerId trainerId;
    private final Period period;
    private final Price price;
    private final List<AttendeeId> attendees = new ArrayList<>();
    private TrainingStatus status;

    Training(
            TrainingNumber trainingNumber, TrainingDefinitionId trainingDefinitionId,
            TrainerId trainerId, Period period, Price price) {
        this.trainingNumber = trainingNumber;
        this.trainingDefinitionId = trainingDefinitionId;
        this.trainerId = trainerId;
        this.period = period;
        this.price = price;
    }

    // factory
    public Offer registerAttendance(Clock clock) {
        return Offer.create(trainingId, price, clock);
    }

    public TrainingAcceptedEvent accept() {
        status = TrainingStatus.ACCEPTED;
        return TrainingAcceptedEvent.create(trainingId, trainerId, trainingDefinitionId);
    }

    public void removeAttendee(AttendeeId attendeeId) {
        if (!attendees.contains(attendeeId)) {
            throw TrainingException.attendeeNotRegistered(attendeeId);
        }

        attendees.remove(attendeeId);
    }

    public void addAttendee(AttendeeId attendeeId) {
        if (attendees.contains(attendeeId)) {
            throw TrainingException.attendeeAlreadyRegistered(attendeeId);
        }

        attendees.add(attendeeId);
    }

    TrainingId getId() {
        return trainingId;
    }
}
