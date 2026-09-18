package com.smalaca.trainingcenter.trainingscatalogue.infrastructure.trainercatalogue;

import com.smalaca.trainingcenter.trainingscatalogue.domain.reviewerid.ReviewerId;
import com.smalaca.trainingcenter.trainingscatalogue.domain.trainercatalogue.TrainersCatalogue;

public class DummyTrainersCatalogue implements TrainersCatalogue {
    private final RestTrainerCatalogClient client;

    public DummyTrainersCatalogue(RestTrainerCatalogClient client) {
        this.client = client;
    }

    @Override
    public boolean isNonCompetent(ReviewerId reviewerId) {
        JsonRequest request = from(reviewerId);
        JsonResponse response = client.send(request);

        return !response.getIsCompetent();
    }

    private JsonRequest from(ReviewerId reviewerId) {
        return null;
    }

    private class RestTrainerCatalogClient {
        public JsonResponse send(JsonRequest request) {
            return null;
        }
    }

    private class JsonRequest {
    }

    private class JsonResponse {
        public boolean getIsCompetent() {
            return false;
        }
    }
}
