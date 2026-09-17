package com.smalaca.trainingcenter.trainingscatalogue.domain.idea;

import com.smalaca.trainingcenter.trainingscatalogue.domain.draft.Draft;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

// Aggregate Root
// Entity
public class Idea {
    @Id
    @GeneratedValue
    private IdeaId ideaId;
    private final IdeaNumber ideaNumber;
    private final AuthorId authorId;
    private final String title;
    private final String description;

    private Idea(IdeaNumber ideaNumber, AuthorId authorId, String title, String description) {
        this.ideaNumber = ideaNumber;
        this.authorId = authorId;
        this.title = title;
        this.description = description;
    }

    // Factory
    public static Idea create(AuthorId authorId, String title, String description) {
        IdeaNumber ideaNumber = IdeaNumber.create(authorId);
        return new Idea(ideaNumber, authorId, title, description);
    }

    public Draft accept(ReviewerId reviewerIdVO) {
        return null;
    }
}
