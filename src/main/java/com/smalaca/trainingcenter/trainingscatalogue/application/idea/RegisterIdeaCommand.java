package com.smalaca.trainingcenter.trainingscatalogue.application.idea;

import java.util.UUID;

public record RegisterIdeaCommand(UUID authorId, String title, String description) {
}
