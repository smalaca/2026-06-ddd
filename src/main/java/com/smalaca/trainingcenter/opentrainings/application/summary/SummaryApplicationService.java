package com.smalaca.trainingcenter.opentrainings.application.summary;

import com.smalaca.trainingcenter.opentrainings.domain.summary.Summary;
import com.smalaca.trainingcenter.opentrainings.domain.summary.SummaryRepository;
import com.smalaca.trainingcenter.opentrainings.domain.training.TrainingId;

import java.util.UUID;

public class SummaryApplicationService {
    private final SummaryRepository summaryRepository;

    public SummaryApplicationService(SummaryRepository summaryRepository) {
        this.summaryRepository = summaryRepository;
    }

    public UUID registerAttendance(UUID trainingId) {
        TrainingId trainingIdVO = new TrainingId(trainingId);

        Summary summary = Summary.create(trainingIdVO);

        return summaryRepository.save(summary);
    }
}
