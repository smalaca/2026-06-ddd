package com.smalaca.trainingcenter.opentrainings.application.training;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public record AddTrainingCommand(
        UUID trainingDefinitionId, LocalDate startDate, LocalDate endDate, UUID trainerId,
        BigDecimal price) {
}
