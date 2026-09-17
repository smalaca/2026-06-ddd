package com.smalaca.trainingcenter.opentrainings.application.summary;

import com.smalaca.trainingcenter.opentrainings.domain.summary.Summary;
import com.smalaca.trainingcenter.opentrainings.domain.summary.SummaryRepository;

import java.util.UUID;

public class SummaryApplicationService {
    private final SummaryRepository summaryRepository;

    public SummaryApplicationService(SummaryRepository summaryRepository) {
        this.summaryRepository = summaryRepository;
    }

    public UUID registerAttendance() {
        Summary summary = Summary.create();

        return summaryRepository.save(summary);
    }
}
