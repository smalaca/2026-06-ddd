package com.smalaca.trainingcenter.trainingscatalogue.domain.idea;

import java.util.UUID;

// Repository
public interface IdeaRepository {
    UUID save(Idea idea);
}
