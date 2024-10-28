package com.galibox.defaulterApp.group.domain;

import com.galibox.defaulterApp.shared.Id;
import lombok.Getter;

import java.util.List;
import java.util.UUID;

@Getter
public final class Group {
    
    private final Id id;
    
    private final String name;
    
    private final List<Participant> participants;

    private final List<Defaulter> defaulters;

    public Group(Id id, String name, List<Participant> participants, List<Defaulter> defaulters) {
        this.id = id;
        this.name = name;
        this.participants = participants;
        this.defaulters = defaulters;
    }
}
