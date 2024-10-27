package com.galibox.defaulterApp.shared;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@EqualsAndHashCode(callSuper = false)
public record Amount(BigDecimal value) {

    public Amount {

        if (value == null) {
            throw new IllegalArgumentException("Amount value cannot be null");
        }

        if (value.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Amount value cannot be negative or zero");
        }

    }

    public Amount add(Amount amount) {
        
        return new Amount(this.value.add(amount.value()));
    }
}
