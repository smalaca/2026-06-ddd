package com.smalaca.trainingcenter.opentrainings.domain.training;

import java.math.BigDecimal;

public class PriceException extends RuntimeException {
    PriceException(BigDecimal price) {
        super("Price " + price + " is not valid");
    }
}
