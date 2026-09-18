package com.smalaca.trainingcenter.opentrainings.domain.training.events;

import com.smalaca.trainingcenter.opentrainings.domain.eventid.EventId;
import com.smalaca.trainingcenter.opentrainings.domain.training.TrainerId;
import com.smalaca.trainingcenter.opentrainings.domain.training.TrainingDefinitionId;
import com.smalaca.trainingcenter.opentrainings.domain.training.TrainingId;

public class TrainingAcceptedEvent {
    private final EventId eventId;
    private final TrainingId trainingId;
    private final TrainerId trainerId;
    private final TrainingDefinitionId trainingDefinitionId;

    private TrainingAcceptedEvent(EventId eventId, TrainingId trainingId, TrainerId trainerId, TrainingDefinitionId trainingDefinitionId) {
        this.eventId = eventId;
        this.trainingId = trainingId;
        this.trainerId = trainerId;
        this.trainingDefinitionId = trainingDefinitionId;
    }

    public static TrainingAcceptedEvent create(
            TrainingId trainingId, TrainerId trainerId, TrainingDefinitionId trainingDefinitionId) {
        return new TrainingAcceptedEvent(
                EventId.create(), trainingId, trainerId, trainingDefinitionId);
    }
}
