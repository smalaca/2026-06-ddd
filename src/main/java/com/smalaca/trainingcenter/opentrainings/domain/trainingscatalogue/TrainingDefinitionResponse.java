package com.smalaca.trainingcenter.opentrainings.domain.trainingscatalogue;

import com.smalaca.trainingcenter.opentrainings.domain.training.Price;
import com.smalaca.trainingcenter.opentrainings.domain.training.TrainingDefinitionId;

public record TrainingDefinitionResponse(
        TrainingDefinitionId trainingDefinitionId, Price price, int duration) {
}
