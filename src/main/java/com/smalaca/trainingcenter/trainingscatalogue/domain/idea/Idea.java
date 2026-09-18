package com.smalaca.trainingcenter.trainingscatalogue.domain.idea;

import com.smalaca.trainingcenter.trainingscatalogue.domain.reviewerid.ReviewerId;
import com.smalaca.trainingcenter.trainingscatalogue.domain.draft.Draft;
import com.smalaca.trainingcenter.trainingscatalogue.domain.trainercatalogue.TrainersCatalogue;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

// Aggregate Root
// Entity
public class Idea {
    @Id
    @GeneratedValue
    private IdeaId ideaId;
    private final IdeaNumber ideaNumber;
    private final AuthorId authorId;
    private final String title;
    private final String description;
    private ReviewerId reviewerId;
    private IdeaStatus status;
    // opcja 1 - external service
//    private TrainerCatalogue trainerCatalogue;

    private Idea(IdeaNumber ideaNumber, AuthorId authorId, String title, String description) {
        this.ideaNumber = ideaNumber;
        this.authorId = authorId;
        this.title = title;
        this.description = description;
    }

    // Factory
    public static Idea create(AuthorId authorId, String title, String description) {
        IdeaNumber ideaNumber = IdeaNumber.create(authorId);
        return new Idea(ideaNumber, authorId, title, description);
    }

    // Factory
    // opcja 2 - external service
    public Draft accept(ReviewerId reviewerId, TrainersCatalogue trainersCatalogue) {
//        TrainerCompetencyRequest request = new TrainerCompetencyRequest(title, reviewerId);

        if (trainersCatalogue.isNonCompetent(reviewerId)) {
            throw DraftException.nonCompetentReviewer(reviewerId);
        }

        this.reviewerId = reviewerId;
        this.status = IdeaStatus.ACCEPTED;

        return Draft.create(title, description, authorId, ideaId, reviewerId);
    }

}
