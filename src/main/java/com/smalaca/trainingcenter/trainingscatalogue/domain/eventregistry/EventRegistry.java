package com.smalaca.trainingcenter.trainingscatalogue.domain.eventregistry;

import com.smalaca.trainingcenter.trainingscatalogue.domain.idea.events.IdeaAcceptedEvent;

public interface EventRegistry {
    void register(IdeaAcceptedEvent event);
}
