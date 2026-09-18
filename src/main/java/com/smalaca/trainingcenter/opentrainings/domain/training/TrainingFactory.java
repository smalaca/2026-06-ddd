package com.smalaca.trainingcenter.opentrainings.domain.training;

import com.smalaca.trainingcenter.opentrainings.domain.calendar.Calendar;
import com.smalaca.trainingcenter.opentrainings.domain.calendar.CalendarRequest;
import com.smalaca.trainingcenter.opentrainings.domain.training.commands.AddTrainingDomainCommand;
import com.smalaca.trainingcenter.opentrainings.domain.trainingscatalogue.TrainingDefinitionResponse;
import com.smalaca.trainingcenter.opentrainings.domain.trainingscatalogue.TrainingsCatalogue;

import java.math.BigDecimal;

public class TrainingFactory {
    private final TrainingsCatalogue trainingsCatalogue;
    private final Calendar calendar;

    public TrainingFactory(TrainingsCatalogue trainingsCatalogue, Calendar calendar) {
        this.trainingsCatalogue = trainingsCatalogue;
        this.calendar = calendar;
    }

    // Factory
    public Training create(AddTrainingDomainCommand command) {
        if (calendar.isUnavailable(asCalendarRequest(command))) {
            throw TrainingException.notAvailable(command.trainerId(), command.period());
        }

        TrainingDefinitionResponse response = trainingsCatalogue.find(command.trainingDefinitionId());

        if (isInvalid(command.price(), response.price())) {
            throw TrainingException.invalidPrice(command.price(), response.price());
        }

        if (hasDurationEqualTo(response.duration(), command.period())) {
            throw TrainingException.outOfRange(command.period(), response.duration());
        }

        return new Training(
                TrainingNumber.create(), command.trainingDefinitionId(), command.trainerId(),
                command.period(), command.price());
    }

    private static CalendarRequest asCalendarRequest(AddTrainingDomainCommand command) {
        return new CalendarRequest(command.trainerId(), command.period());
    }

    private static boolean hasDurationEqualTo(int duration, Period period) {
        return period.hasDurationEqualTo(duration);
    }

    private static boolean isInvalid(Price givenPrice, Price defaultPrice) {
        if (defaultPrice.minus(new BigDecimal(500)).isGreaterThan(givenPrice)) {
            return false;
        }

        if (defaultPrice.times(2).isLowerThan(givenPrice)) {
            return false;
        }

        return true;
    }
}
