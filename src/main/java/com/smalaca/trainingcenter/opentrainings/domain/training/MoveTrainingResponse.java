package com.smalaca.trainingcenter.opentrainings.domain.training;

import com.smalaca.trainingcenter.opentrainings.domain.training.events.AttendeeMovedEvent;

import java.util.List;

public record MoveTrainingResponse(AttendeeMovedEvent event, List<Training> trainings) {
}
