package com.galibox.defaulterApp.shared;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@EqualsAndHashCode
public final class Amount {

    private final BigDecimal value;
    
    private Amount (BigDecimal value) {
       
        this.value = value;
    }

    public static Amount of(BigDecimal value) {

        if (value == null) {
            throw new IllegalArgumentException("Amount value cannot be null");
        }

        if (value.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Amount value cannot be negative or zero");
        }
        
        return new Amount(value);
    }

    public Amount add(Amount toAdd) {

        if (toAdd == null) {
            throw new IllegalArgumentException("toAdd value cannot be null");
        }

        return new Amount(value.add(toAdd.getValue()));
    }
    

    
}
