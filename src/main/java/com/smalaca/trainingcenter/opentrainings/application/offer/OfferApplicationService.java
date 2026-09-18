package com.smalaca.trainingcenter.opentrainings.application.offer;

import com.smalaca.trainingcenter.opentrainings.domain.offer.Offer;
import com.smalaca.trainingcenter.opentrainings.domain.offer.OfferRepository;
import com.smalaca.trainingcenter.opentrainings.domain.training.TrainingId;

import java.util.UUID;

public class OfferApplicationService {
    private final OfferRepository offerRepository;

    public OfferApplicationService(OfferRepository offerRepository) {
        this.offerRepository = offerRepository;
    }

    public UUID registerAttendance(UUID trainingId) {
        TrainingId trainingIdVO = new TrainingId(trainingId);

        Offer offer = Offer.create(trainingIdVO);

        return offerRepository.save(offer);
    }
}
