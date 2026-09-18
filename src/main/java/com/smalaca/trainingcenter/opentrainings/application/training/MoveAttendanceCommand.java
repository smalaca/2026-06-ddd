package com.smalaca.trainingcenter.opentrainings.application.training;

import java.util.UUID;

public record MoveAttendanceCommand(UUID attendeeId, UUID trainingIdFrom, UUID trainingIdTo) {
}
