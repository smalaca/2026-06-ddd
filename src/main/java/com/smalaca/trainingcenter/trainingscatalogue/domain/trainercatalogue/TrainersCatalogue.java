package com.smalaca.trainingcenter.trainingscatalogue.domain.trainercatalogue;

import com.smalaca.trainingcenter.trainingscatalogue.domain.reviewerid.ReviewerId;

public interface TrainersCatalogue {
    boolean isNonCompetent(ReviewerId reviewerId);
}
