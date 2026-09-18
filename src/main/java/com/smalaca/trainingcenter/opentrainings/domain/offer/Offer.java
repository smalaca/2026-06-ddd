package com.smalaca.trainingcenter.opentrainings.domain.offer;

import com.smalaca.trainingcenter.opentrainings.domain.clock.Clock;
import com.smalaca.trainingcenter.opentrainings.domain.training.Price;
import com.smalaca.trainingcenter.opentrainings.domain.training.TrainingId;

import java.time.LocalDate;

// Aggregate Root
// Entity
public class Offer {
    private OfferId offerId;
    private final OfferNumber offerNumber;
    private final TrainingId trainingId;
    private final Price price;
    private final LocalDate creationDate;

    private Offer(OfferNumber offerNumber, TrainingId trainingId, Price price, LocalDate creationDate) {
        this.offerNumber = offerNumber;
        this.trainingId = trainingId;
        this.price = price;
        this.creationDate = creationDate;
    }

    // Factory
    public static Offer create(TrainingId trainingId, Price price, Clock clock) {
        return new Offer(OfferNumber.create(), trainingId, price, clock.now());
    }
}
