package com.smalaca.trainingcenter.opentrainings.application.training;

import com.smalaca.trainingcenter.opentrainings.domain.clock.Clock;
import com.smalaca.trainingcenter.opentrainings.domain.offer.Offer;
import com.smalaca.trainingcenter.opentrainings.domain.offer.OfferRepository;
import com.smalaca.trainingcenter.opentrainings.domain.training.*;
import com.smalaca.trainingcenter.opentrainings.domain.training.commands.AddTrainingDomainCommand;

import java.util.UUID;

public class TrainingApplicationService {
    private final TrainingRepository trainingRepository;
    private final OfferRepository offerRepository;
    private final Clock clock;

    public TrainingApplicationService(TrainingRepository trainingRepository, OfferRepository offerRepository, Clock clock) {
        this.trainingRepository = trainingRepository;
        this.offerRepository = offerRepository;
        this.clock = clock;
    }

    public UUID addTraining(AddTrainingCommand command) {
        TrainingDefinitionId trainingDefinitionId = new TrainingDefinitionId(command.trainingDefinitionId());
        TrainerId trainerId = new TrainerId(command.trainerId());
        Period period = Period.from(clock, command.startDate(), command.endDate());
        Price price = Price.from(command.price());
        AddTrainingDomainCommand domainCommand = new AddTrainingDomainCommand(
                trainingDefinitionId, trainerId, period, price);

        Training training = Training.create(domainCommand);

        return trainingRepository.save(training);
    }

    public UUID registerAttendance(UUID trainingId) {
        TrainingId trainingIdVO = new TrainingId(trainingId);
        Training training = trainingRepository.findById(trainingIdVO);

        Offer offer = training.registerAttendance(clock);

        return offerRepository.save(offer);
    }
}
