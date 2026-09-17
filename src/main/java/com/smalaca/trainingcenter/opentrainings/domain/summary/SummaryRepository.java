package com.smalaca.trainingcenter.opentrainings.domain.summary;

import java.util.UUID;

// Repository
public interface SummaryRepository {
    UUID save(Summary summary);
}
