package com.smalaca.trainingcenter.opentrainings.application.training;

import com.smalaca.trainingcenter.opentrainings.domain.calendar.Calendar;
import com.smalaca.trainingcenter.opentrainings.domain.clock.Clock;
import com.smalaca.trainingcenter.opentrainings.domain.eventregistry.EventRegistry;
import com.smalaca.trainingcenter.opentrainings.domain.offer.Offer;
import com.smalaca.trainingcenter.opentrainings.domain.offer.OfferRepository;
import com.smalaca.trainingcenter.opentrainings.domain.training.*;
import com.smalaca.trainingcenter.opentrainings.domain.training.commands.AddTrainingDomainCommand;
import com.smalaca.trainingcenter.opentrainings.domain.training.events.TrainingAcceptedEvent;
import com.smalaca.trainingcenter.opentrainings.domain.trainingscatalogue.TrainingsCatalogue;

import java.util.List;
import java.util.UUID;

public class TrainingApplicationService {
    private final EventRegistry eventRegistry;
    private final Calendar calendar;
    private final TrainingsCatalogue trainingsCatalogue;
    private final TrainingRepository trainingRepository;
    private final OfferRepository offerRepository;
    private final TrainingFactory factory;
    private final Clock clock;
    private final TrainingDomainService trainingDomainService;

    public TrainingApplicationService(EventRegistry eventRegistry, Calendar calendar, TrainingsCatalogue trainingsCatalogue, TrainingRepository trainingRepository, OfferRepository offerRepository, TrainingFactory factory, Clock clock, TrainingDomainService trainingDomainService) {
        this.eventRegistry = eventRegistry;
        this.calendar = calendar;
        this.trainingsCatalogue = trainingsCatalogue;
        this.trainingRepository = trainingRepository;
        this.offerRepository = offerRepository;
        this.factory = factory;
        this.clock = clock;
        this.trainingDomainService = trainingDomainService;
    }

    public UUID addTraining(AddTrainingCommand command) {
        TrainingDefinitionId trainingDefinitionId = new TrainingDefinitionId(command.trainingDefinitionId());
        TrainerId trainerId = new TrainerId(command.trainerId());
        Period period = Period.from(clock, command.startDate(), command.endDate());
        Price price = Price.from(command.price());
        AddTrainingDomainCommand domainCommand = new AddTrainingDomainCommand(
                trainingDefinitionId, trainerId, period, price);

        AddTrainingResponse response = factory.create(domainCommand);

        eventRegistry.register(response.event());
        return trainingRepository.save(response.training());
    }

    public UUID registerAttendance(UUID trainingId) {
        TrainingId trainingIdVO = new TrainingId(trainingId);
        Training training = trainingRepository.findById(trainingIdVO);

        Offer offer = training.registerAttendance(clock);

        return offerRepository.save(offer);
    }

    public void accept(UUID trainingId) {
        TrainingId trainingIdVO = new TrainingId(trainingId);
        Training training = trainingRepository.findById(trainingIdVO);

        TrainingAcceptedEvent event = training.accept();

        eventRegistry.register(event);
        trainingRepository.save(training);
    }

    public void move(MoveAttendanceCommand command) {
        TrainingId trainingIdFrom = new TrainingId(command.trainingIdFrom());
        Training trainingFrom = trainingRepository.findById(trainingIdFrom);
        TrainingId trainingIdTo = new TrainingId(command.trainingIdTo());
        Training trainingTo = trainingRepository.findById(trainingIdTo);
        AttendeeId attendeeId = new AttendeeId(command.attendeeId());

        List<Training> trainings = trainingDomainService.move(trainingFrom, trainingTo, attendeeId);

        trainings.forEach(trainingRepository::save);
    }
}
