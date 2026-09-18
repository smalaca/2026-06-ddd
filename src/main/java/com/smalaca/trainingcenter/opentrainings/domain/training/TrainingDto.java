package com.smalaca.trainingcenter.opentrainings.domain.training;

// nie powinno zwracać value object tylko ich wartości
public record TrainingDto(
    TrainingId trainingId, TrainingNumber trainingNumber,
    TrainingDefinitionId trainingDefinitionId, TrainerId trainerId, Period period, Price price) {
}
