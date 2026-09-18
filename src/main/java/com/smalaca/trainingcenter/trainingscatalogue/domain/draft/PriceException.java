package com.smalaca.trainingcenter.trainingscatalogue.domain.draft;

import java.math.BigDecimal;

public class PriceException extends RuntimeException {
    PriceException(BigDecimal price) {
        super("Price " + price + " is not valid");
    }
}
