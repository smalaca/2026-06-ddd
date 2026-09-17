package com.smalaca.trainingcenter.trainingscatalogue.domain.draft;

import com.smalaca.trainingcenter.trainingscatalogue.domain.idea.AuthorId;

import java.util.UUID;

// Value Object
class DraftNumber {
    private final String value;

    private DraftNumber(String value) {
        this.value = value;
    }

    // Factory
    public static DraftNumber create(AuthorId authorId) {
        return new DraftNumber("Idea/" + authorId.getValue() + "/" + UUID.randomUUID());
    }
}
