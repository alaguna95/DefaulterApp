package com.galibox.defaulterApp.shared;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.UUID;

@Getter
@EqualsAndHashCode
public final class Id {

    private final UUID value;

    private Id(UUID value) {
        this.value = value;
    }

    public static Id create() {
        
        return new Id(UUID.randomUUID());
    }

    public static Id of(UUID value) {
        
        if (value == null) {
            throw new IllegalArgumentException("The id cannot be null");
        }
        return new Id(value);
    }
}
