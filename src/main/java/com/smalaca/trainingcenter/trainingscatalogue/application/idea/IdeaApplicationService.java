package com.smalaca.trainingcenter.trainingscatalogue.application.idea;

import java.util.UUID;

public class IdeaApplicationService {
    public UUID registerIdea() {
        // 1. tłumaczenie z typów języka progamowania na język domeny [0...*]

        // 2. wywołanie domeny: 1
        // opcja 1
        Idea idea = new IdeaFactory().create();

        // opcja 1
        Idea idea = Idea.create();

        // źle
        IdeaNumber ideaNumber = new IdeaNumber();
        Idea idea = new Idea(ideaNumber);

        // 3. zapis [1...*]
        return ideaRespository.save(idea);
    }
}
