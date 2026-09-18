package com.smalaca.trainingcenter.trainingscatalogue.domain.idea.events;

import com.smalaca.trainingcenter.trainingscatalogue.domain.eventid.EventId;
import com.smalaca.trainingcenter.trainingscatalogue.domain.idea.IdeaId;
import com.smalaca.trainingcenter.trainingscatalogue.domain.reviewerid.ReviewerId;

public class IdeaAcceptedEvent {
    private final EventId eventId;
    private final IdeaId ideaId;
    private final ReviewerId reviewerId;

    private IdeaAcceptedEvent(EventId eventId, IdeaId ideaId, ReviewerId reviewerId) {
        this.eventId = eventId;
        this.ideaId = ideaId;
        this.reviewerId = reviewerId;
    }

    public static IdeaAcceptedEvent create(IdeaId ideaId, ReviewerId reviewerId) {
        return new IdeaAcceptedEvent(EventId.create(), ideaId, reviewerId);
    }
}
