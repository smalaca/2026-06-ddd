package com.smalaca.trainingcenter.opentrainings.domain.training.events;

import com.smalaca.trainingcenter.opentrainings.domain.eventid.EventId;
import com.smalaca.trainingcenter.opentrainings.domain.training.*;

public class TrainingAddedEvent {
    private final EventId eventId;
    private final TrainingNumber trainingNumber;
    private final TrainingDefinitionId trainingDefinitionId;
    private final TrainerId trainerId;
    private final Period period;
    private final Price price;

    private TrainingAddedEvent(
            EventId eventId, TrainingNumber trainingNumber, TrainingDefinitionId trainingDefinitionId,
            TrainerId trainerId, Period period, Price price) {
        this.eventId = eventId;
        this.trainingNumber = trainingNumber;
        this.trainingDefinitionId = trainingDefinitionId;
        this.trainerId = trainerId;
        this.period = period;
        this.price = price;
    }

    public static TrainingAddedEvent create(
            TrainingNumber trainingNumber, TrainingDefinitionId trainingDefinitionId, TrainerId trainerId, Period period, Price price) {
        return new TrainingAddedEvent(
                EventId.create(), trainingNumber, trainingDefinitionId, trainerId, period, price);
    }
}
