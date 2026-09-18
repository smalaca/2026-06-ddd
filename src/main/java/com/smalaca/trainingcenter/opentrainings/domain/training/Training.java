package com.smalaca.trainingcenter.opentrainings.domain.training;

import com.smalaca.trainingcenter.opentrainings.domain.clock.Clock;
import com.smalaca.trainingcenter.opentrainings.domain.offer.Offer;
import com.smalaca.trainingcenter.opentrainings.domain.training.commands.AddTrainingDomainCommand;
import com.smalaca.trainingcenter.opentrainings.domain.trainingscatalogue.TrainingDefinitionResponse;
import com.smalaca.trainingcenter.opentrainings.domain.trainingscatalogue.TrainingsCatalogue;

import java.math.BigDecimal;

// Aggregate Root
// Entity
public class Training {
    private TrainingId trainingId;
    private final TrainingNumber trainingNumber;
    private final TrainingDefinitionId trainingDefinitionId;
    private final TrainerId trainerId;
    private final Period period;
    private final Price price;

    private Training(
            TrainingNumber trainingNumber, TrainingDefinitionId trainingDefinitionId,
            TrainerId trainerId, Period period, Price price) {
        this.trainingNumber = trainingNumber;
        this.trainingDefinitionId = trainingDefinitionId;
        this.trainerId = trainerId;
        this.period = period;
        this.price = price;
    }

    // Factory
    public static Training create(AddTrainingDomainCommand command, TrainingsCatalogue trainingsCatalogue) {
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

    // factory
    public Offer registerAttendance(Clock clock) {
        return Offer.create(trainingId, price, clock);
    }
}
