package com.galibox.defaulterApp.shared;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.UUID;

@Getter
@EqualsAndHashCode
public final class Id {
    
    private final UUID id;
    
    public Id(final UUID id) {
        
        if(id == null) {
            throw new IllegalArgumentException("The id cannot be null");
        }
        this.id = id;
    }
}
