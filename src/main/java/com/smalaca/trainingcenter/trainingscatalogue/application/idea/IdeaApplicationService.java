package com.smalaca.trainingcenter.trainingscatalogue.application.idea;

import com.smalaca.trainingcenter.trainingscatalogue.domain.idea.Idea;
import com.smalaca.trainingcenter.trainingscatalogue.domain.idea.IdeaRepository;

import java.util.UUID;

public class IdeaApplicationService {
    private final IdeaRepository ideaRepository;

    public IdeaApplicationService(IdeaRepository ideaRepository) {
        this.ideaRepository = ideaRepository;
    }

    public UUID registerIdea() {
        // 1. tłumaczenie z typów języka progamowania na język domeny [0...*]

        // 2. wywołanie domeny: 1
        // źle
//        IdeaNumber ideaNumber = new IdeaNumber();
//        Idea idea = new Idea(ideaNumber);
        // opcja 1
//        Idea idea = new IdeaFactory().create();
        // opcja 1
        Idea idea = Idea.create();

        // 3. zapis [1...*]
        return ideaRepository.save(idea);
    }
}
