package com.smalaca.trainingcenter.opentrainings.domain.training;

import com.smalaca.trainingcenter.opentrainings.domain.training.events.TrainingAddedEvent;

public record AddTrainingResponse(Training training, TrainingAddedEvent event) {
}
