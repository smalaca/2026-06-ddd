package com.smalaca.trainingcenter.opentrainings.domain.offer;

import com.smalaca.trainingcenter.opentrainings.domain.training.Price;
import com.smalaca.trainingcenter.opentrainings.domain.training.TrainingId;

// Aggregate Root
// Entity
public class Offer {
    private OfferId offerId;
    private final OfferNumber offerNumber;
    private final TrainingId trainingId;
    private final Price price;

    private Offer(OfferNumber offerNumber, TrainingId trainingId, Price price) {
        this.offerNumber = offerNumber;
        this.trainingId = trainingId;
        this.price = price;
    }

    // Factory
    public static Offer create(TrainingId trainingId, Price price) {
        return new Offer(OfferNumber.create(), trainingId, price);
    }
}
