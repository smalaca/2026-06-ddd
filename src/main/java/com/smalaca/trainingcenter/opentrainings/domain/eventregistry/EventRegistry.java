package com.smalaca.trainingcenter.opentrainings.domain.eventregistry;

import com.smalaca.trainingcenter.opentrainings.domain.training.events.TrainingAcceptedEvent;
import com.smalaca.trainingcenter.opentrainings.domain.training.events.TrainingAddedEvent;

public interface EventRegistry {
    void register(TrainingAddedEvent event);

    void register(TrainingAcceptedEvent event);
}
