package com.smalaca.trainingcenter.trainingscatalogue.domain.idea;

import com.smalaca.trainingcenter.trainingscatalogue.domain.reviewerid.ReviewerId;

class DraftException extends RuntimeException {
    private DraftException(String message) {
        super(message);
    }

    static DraftException nonCompetentReviewer(ReviewerId reviewerId) {
        return new DraftException("Non competent reviewer: " + reviewerId);
    }
}
