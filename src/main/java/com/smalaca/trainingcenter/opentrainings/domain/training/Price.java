package com.smalaca.trainingcenter.opentrainings.domain.training;

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

    public Price minus(BigDecimal value) {
        return new Price(price.subtract(value));
    }

    public boolean isGreaterThan(Price price) {
        return price.price.compareTo(this.price) < 0;
    }

    public Price times(int times) {
        return new Price(price.multiply(new BigDecimal(times)));
    }

    public boolean isLowerThan(Price price) {
        return price.price.compareTo(this.price) > 0;
    }
}
