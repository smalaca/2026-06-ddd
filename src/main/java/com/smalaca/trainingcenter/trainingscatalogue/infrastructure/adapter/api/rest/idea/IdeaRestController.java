package com.smalaca.trainingcenter.trainingscatalogue.infrastructure.adapter.api.rest.idea;

import com.smalaca.trainingcenter.trainingscatalogue.application.idea.IdeaApplicationService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class IdeaRestController {
    private IdeaApplicationService ideaApplicationService;

    @PostMapping("/ideas")
    public UUID registerIdea() {
        return ideaApplicationService.registerIdea();
    }
}
