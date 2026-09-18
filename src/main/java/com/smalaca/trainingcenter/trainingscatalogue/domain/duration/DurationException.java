package com.smalaca.trainingcenter.trainingscatalogue.domain.duration;

class DurationException extends RuntimeException {
    DurationException(int duration) {
        super("Duration " + duration + " is not valid");
    }
}
