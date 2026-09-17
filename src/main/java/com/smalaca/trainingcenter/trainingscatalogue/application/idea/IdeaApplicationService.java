package com.smalaca.trainingcenter.trainingscatalogue.application.idea;

import com.smalaca.trainingcenter.trainingscatalogue.domain.reviewerid.ReviewerId;
import com.smalaca.trainingcenter.trainingscatalogue.domain.draft.Draft;
import com.smalaca.trainingcenter.trainingscatalogue.domain.draft.DraftRepository;
import com.smalaca.trainingcenter.trainingscatalogue.domain.idea.*;

import java.util.UUID;

public class IdeaApplicationService {
    private final IdeaRepository ideaRepository;
    private final DraftRepository draftRepository;

    public IdeaApplicationService(IdeaRepository ideaRepository, DraftRepository draftRepository) {
        this.ideaRepository = ideaRepository;
        this.draftRepository = draftRepository;
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
        Draft draft = idea.accept(reviewerIdVO);

        // zapis
        ideaRepository.save(idea);
        return draftRepository.save(draft);
    }
}
