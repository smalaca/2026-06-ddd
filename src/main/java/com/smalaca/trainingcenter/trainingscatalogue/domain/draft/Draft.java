package com.smalaca.trainingcenter.trainingscatalogue.domain.draft;

import com.smalaca.trainingcenter.trainingscatalogue.domain.idea.AuthorId;
import com.smalaca.trainingcenter.trainingscatalogue.domain.idea.IdeaId;
import com.smalaca.trainingcenter.trainingscatalogue.domain.reviewerid.ReviewerId;

// Aggregate Root
// Entity
public class Draft {
    private final String title;
    private final String description;
    private final AuthorId authorId;
    private final IdeaId ideaId;
    private final ReviewerId reviewerId;

    private Draft(String title, String description, AuthorId authorId, IdeaId ideaId, ReviewerId reviewerId) {
        this.title = title;
        this.description = description;
        this.authorId = authorId;
        this.ideaId = ideaId;
        this.reviewerId = reviewerId;
    }

    // Factory
    public static Draft create(String title, String description, AuthorId authorId, IdeaId ideaId, ReviewerId reviewerId) {
        DraftNumber draftNumber = DraftNumber.create(authorId);
        return new Draft(title, description, authorId, ideaId, reviewerId);
    }
}
