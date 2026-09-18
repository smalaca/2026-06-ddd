package com.smalaca.trainingcenter.trainingscatalogue.application.idea;

import com.smalaca.trainingcenter.trainingscatalogue.domain.draft.DraftRepository;
import com.smalaca.trainingcenter.trainingscatalogue.domain.eventregistry.EventRegistry;
import com.smalaca.trainingcenter.trainingscatalogue.domain.idea.*;
import com.smalaca.trainingcenter.trainingscatalogue.domain.reviewerid.ReviewerId;

import java.util.UUID;

public class IdeaApplicationService {
    private final IdeaRepository ideaRepository;
    private final DraftRepository draftRepository;
    private final EventRegistry eventRegistry;
    private final IdeaDomainService service;

    public IdeaApplicationService(
            IdeaRepository ideaRepository, DraftRepository draftRepository,
            EventRegistry eventRegistry, IdeaDomainService service) {
        this.ideaRepository = ideaRepository;
        this.draftRepository = draftRepository;
        this.eventRegistry = eventRegistry;
        this.service = service;
    }

    public UUID registerIdea(RegisterIdeaCommand command) {
        // 1. tłumaczenie z typów języka progamowania na język domeny [0...*]
        AuthorId authorId = AuthorId.from(command.authorId());

        // 2. wywołanie domeny: 1
        // źle
//        IdeaNumber ideaNumber = new IdeaNumber();
//        Idea idea = new Idea(ideaNumber);
        // opcja 1
//        Idea idea = new IdeaFactory().create();
        // opcja 1
        Idea idea = Idea.create(authorId, command.title(), command.description());

        // 3. zapis [1...*]
        return ideaRepository.save(idea);
    }

    public UUID acceptIdea(UUID ideaId, UUID reviewerId) {
        // tłumaczenie
        ReviewerId reviewerIdVO = new ReviewerId(reviewerId);
        IdeaId ideaIdVO = new IdeaId(ideaId);
        Idea idea = ideaRepository.findById(ideaIdVO);

        // domena
        AcceptIdeaResponse response = service.acceptIdea(idea, ideaIdVO, reviewerIdVO);

        // zapis
        ideaRepository.save(response.idea());
        eventRegistry.register(response.event());
        return draftRepository.save(response.draft());
    }
}
