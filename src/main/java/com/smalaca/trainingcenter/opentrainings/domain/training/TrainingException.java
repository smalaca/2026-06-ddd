package com.smalaca.trainingcenter.opentrainings.domain.training;

class TrainingException extends RuntimeException {
    private TrainingException(String message) {
        super(message);
    }

    static TrainingException invalidPrice(Price given, Price defaultPrice) {
        return new TrainingException("Invalid price. Given " + given + ", default " + defaultPrice);
    }

    static TrainingException outOfRange(Period period, int duration) {
        return new TrainingException("Out of range. Given " + period + ", duration " + duration);
    }

    static TrainingException notAvailable(TrainerId trainerId, Period period) {
        return new TrainingException("Not available. Trainer " + trainerId + ", period " + period);
    }

    static TrainingException attendeeNotRegistered(AttendeeId attendeeId) {
        return new TrainingException("Attendee not registered. Attendee " + attendeeId);
    }

    static TrainingException attendeeAlreadyRegistered(AttendeeId attendeeId) {
        return new TrainingException("Attendee already registered. Attendee " + attendeeId);
    }
}
