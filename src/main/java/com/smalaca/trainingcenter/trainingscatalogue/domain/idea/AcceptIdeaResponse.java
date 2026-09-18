package com.smalaca.trainingcenter.trainingscatalogue.domain.idea;

import com.smalaca.trainingcenter.trainingscatalogue.domain.draft.Draft;
import com.smalaca.trainingcenter.trainingscatalogue.domain.idea.events.IdeaAcceptedEvent;

public record AcceptIdeaResponse(Idea idea, Draft draft, IdeaAcceptedEvent event) {
}
