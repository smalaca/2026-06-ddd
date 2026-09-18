package com.smalaca.trainingcenter.trainingscatalogue.application.draft;

import java.math.BigDecimal;
import java.util.UUID;

public record PrepareTrainingCommand(UUID draftId, BigDecimal price, int duration) {
}
