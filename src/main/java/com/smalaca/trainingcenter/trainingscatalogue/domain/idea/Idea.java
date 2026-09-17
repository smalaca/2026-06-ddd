package com.smalaca.trainingcenter.trainingscatalogue.domain.idea;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

// Aggregate Root
// Entity
public class Idea {
    @Id
    @GeneratedValue
    private IdeaId ideaId;
    private final IdeaNumber ideaNumber;

    private Idea(IdeaNumber ideaNumber) {
        this.ideaNumber = ideaNumber;
    }

    // Factory
    public static Idea create() {
        IdeaNumber ideaNumber = IdeaNumber.create();
        return new Idea(ideaNumber);
    }
}
