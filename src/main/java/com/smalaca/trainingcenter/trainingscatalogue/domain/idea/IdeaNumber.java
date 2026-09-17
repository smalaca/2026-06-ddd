package com.smalaca.trainingcenter.trainingscatalogue.domain.idea;

import java.util.UUID;

// Value Object
class IdeaNumber {
    private final String value;

    private IdeaNumber(String value) {
        this.value = value;
    }

    // Factory
    public static IdeaNumber create() {
        return new IdeaNumber("IDEA/" + UUID.randomUUID());
    }
}
