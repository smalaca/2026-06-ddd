package com.smalaca.trainingcenter.opentrainings.domain.training.commands;

import com.smalaca.trainingcenter.opentrainings.domain.training.Period;
import com.smalaca.trainingcenter.opentrainings.domain.training.TrainerId;
import com.smalaca.trainingcenter.opentrainings.domain.training.TrainingDefinitionId;

public record AddTrainingDomainCommand(TrainingDefinitionId trainingDefinitionId, TrainerId trainerId, Period period,
                                       com.smalaca.trainingcenter.opentrainings.domain.training.Price price) {
}
