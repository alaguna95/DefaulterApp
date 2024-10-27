package com.galibox.defaulterApp.group.domain;

import java.math.BigDecimal;
import java.util.UUID;

final class Defaulter {
    
    private final UUID defaulterUserId;
    
    private final UUID sillyUserId;
    
    private final BigDecimal amount;

    Defaulter(UUID defaulterUserId, UUID sillyUserId, BigDecimal amount) {
        this.defaulterUserId = defaulterUserId;
        this.sillyUserId = sillyUserId;
        this.amount = amount;
    }
}
