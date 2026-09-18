package com.smalaca.trainingcenter.opentrainings.domain.trainingscatalogue;

import com.smalaca.trainingcenter.opentrainings.domain.training.TrainingDefinitionId;

public interface TrainingsCatalogue {
    TrainingDefinitionResponse find(TrainingDefinitionId trainingDefinitionId);
}
