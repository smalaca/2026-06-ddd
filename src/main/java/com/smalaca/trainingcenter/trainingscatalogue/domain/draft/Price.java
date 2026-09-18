package com.smalaca.trainingcenter.trainingscatalogue.domain.draft;

import java.math.BigDecimal;

// value object
public class Price {
    private final BigDecimal price;

    private Price(BigDecimal price) {
        this.price = price;
    }

    // factory
    public static Price from(BigDecimal price) {
        if (new BigDecimal(1000).compareTo(price) > 0 &&
                new BigDecimal(50000).compareTo(price) < 0) {
            throw new PriceException(price);
        }

        return new Price(price);
    }
}
