package com.smalaca.trainingcenter.opentrainings.domain.offer;

import java.util.UUID;

// Repository
public interface OfferRepository {
    UUID save(Offer offer);
}
