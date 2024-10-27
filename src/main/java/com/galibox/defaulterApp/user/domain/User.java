package com.galibox.defaulterApp.user.domain;

import java.util.UUID;

final class User {
    
    private final UUID id;
    
    private final String username;
    
    User(UUID id, String username) {
        this.id = id;
        this.username = username;
    }
}
