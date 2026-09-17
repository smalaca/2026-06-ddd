package com.smalaca.trainingcenter.trainingscatalogue.domain.draft;

import java.util.UUID;

// Repository
public interface DraftRepository {
    UUID save(Draft draft);
}
