package com.smalaca.trainingcenter.trainingscatalogue.domain.duration;

// value object
public class Duration {
    private final int duration;

    private Duration(int duration) {
        this.duration = duration;
    }

    // factory
    public static Duration from(int duration) {
        if (duration < 1 || duration > 5) {
            throw new DurationException(duration);
        }

        return new Duration(duration);
    }
}
