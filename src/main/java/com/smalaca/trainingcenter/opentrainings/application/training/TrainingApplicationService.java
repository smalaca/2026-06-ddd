package com.smalaca.trainingcenter.opentrainings.application.training;

import com.smalaca.trainingcenter.opentrainings.domain.offer.Offer;
import com.smalaca.trainingcenter.opentrainings.domain.offer.OfferRepository;
import com.smalaca.trainingcenter.opentrainings.domain.training.*;
import com.smalaca.trainingcenter.opentrainings.domain.training.commands.AddTrainingDomainCommand;

import java.util.UUID;

public class TrainingApplicationService {
    private final TrainingRepository trainingRepository;
    private final OfferRepository offerRepository;

    public TrainingApplicationService(TrainingRepository trainingRepository, OfferRepository offerRepository) {
        this.trainingRepository = trainingRepository;
        this.offerRepository = offerRepository;
    }

    public UUID addTraining(AddTrainingCommand command) {
        TrainingDefinitionId trainingDefinitionId = new TrainingDefinitionId(command.trainingDefinitionId());
        TrainerId trainerId = new TrainerId(command.trainerId());
        Period period = Period.from(command.startDate(), command.endDate());
        Price price = Price.from(command.price());
        AddTrainingDomainCommand domainCommand = new AddTrainingDomainCommand(
                trainingDefinitionId, trainerId, period);

        Training training = Training.create(domainCommand);

        return trainingRepository.save(training);
    }

    public UUID registerAttendance(UUID trainingId) {
        TrainingId trainingIdVO = new TrainingId(trainingId);

        Offer offer = Offer.create(trainingIdVO);

        return offerRepository.save(offer);
    }
}
