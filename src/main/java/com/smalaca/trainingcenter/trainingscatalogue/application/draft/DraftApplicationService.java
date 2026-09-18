package com.smalaca.trainingcenter.trainingscatalogue.application.draft;

import com.smalaca.trainingcenter.trainingscatalogue.domain.draft.*;
import com.smalaca.trainingcenter.trainingscatalogue.domain.duration.Duration;

public class DraftApplicationService {
    private final DraftRepository draftRepository;

    public DraftApplicationService(DraftRepository draftRepository) {
        this.draftRepository = draftRepository;
    }

    public void prepare(PrepareTrainingCommand command) {
        DraftId draftId = new DraftId(command.draftId());
        Draft draft = draftRepository.findById(draftId);
        Price price = Price.from(command.price());
        Duration duration = Duration.from(command.duration());

        draft.prepare(price, duration);

        draftRepository.save(draft);
    }
}
