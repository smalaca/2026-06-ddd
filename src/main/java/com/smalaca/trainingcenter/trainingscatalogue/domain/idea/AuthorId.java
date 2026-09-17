package com.smalaca.trainingcenter.trainingscatalogue.domain.idea;

import java.util.UUID;

// Value Object
public class AuthorId {
    private final UUID value;

    private AuthorId(UUID value) {
        this.value = value;
    }

    // Factory
    public static AuthorId from(UUID value) {
        return new AuthorId(value);
    }

    public UUID getValue() {
        return value;
    }
}
