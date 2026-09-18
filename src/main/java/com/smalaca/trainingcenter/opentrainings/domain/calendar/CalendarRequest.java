package com.smalaca.trainingcenter.opentrainings.domain.calendar;

import com.smalaca.trainingcenter.opentrainings.domain.training.Period;
import com.smalaca.trainingcenter.opentrainings.domain.training.TrainerId;

public record CalendarRequest(TrainerId trainerId, Period period) {
}
