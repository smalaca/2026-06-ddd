package com.smalaca.trainingcenter.trainingscatalogue.domain.idea;

import com.smalaca.trainingcenter.trainingscatalogue.domain.draft.Draft;
import com.smalaca.trainingcenter.trainingscatalogue.domain.idea.events.IdeaAcceptedEvent;
import com.smalaca.trainingcenter.trainingscatalogue.domain.reviewerid.ReviewerId;
import com.smalaca.trainingcenter.trainingscatalogue.domain.trainercatalogue.TrainersCatalogue;

public class IdeaDomainService {
    private final TrainersCatalogue trainersCatalogue;

    public IdeaDomainService(TrainersCatalogue trainersCatalogue) {
        this.trainersCatalogue = trainersCatalogue;
    }

    public AcceptIdeaResponse acceptIdea(Idea idea, IdeaId ideaId, ReviewerId reviewerId) {
        Draft draft = idea.accept(reviewerId, trainersCatalogue);
        IdeaAcceptedEvent event = IdeaAcceptedEvent.create(ideaId, reviewerId);

        return new AcceptIdeaResponse(idea, draft, event);
    }
}
