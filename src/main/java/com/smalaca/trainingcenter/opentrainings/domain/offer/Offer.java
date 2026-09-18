package com.smalaca.trainingcenter.opentrainings.domain.offer;

import com.smalaca.trainingcenter.opentrainings.domain.training.TrainingId;

// Aggregate Root
// Entity
public class Offer {
    private OfferId offerId;
    private final OfferNumber offerNumber;
    private final TrainingId trainingId;

    private Offer(OfferNumber offerNumber, TrainingId trainingId) {
        this.offerNumber = offerNumber;
        this.trainingId = trainingId;
    }

    // Factory
    public static Offer create(TrainingId trainingId) {
        return new Offer(OfferNumber.create(), trainingId);
    }
}
