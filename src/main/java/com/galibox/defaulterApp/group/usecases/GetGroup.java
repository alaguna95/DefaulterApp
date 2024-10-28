package com.galibox.defaulterApp.group.usecases;

import com.galibox.defaulterApp.expense.domain.Name;
import com.galibox.defaulterApp.group.domain.Group;
import com.galibox.defaulterApp.group.domain.Participant;
import com.galibox.defaulterApp.shared.Id;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Service
public class GetGroup {
    
    public Group getGroup(final Id groupId) {
    
        return new Group(
                Id.of(new UUID(0,0)), 
                "TEST", 
                List.of(
                        new Participant(Id.of(new UUID(0,0)), BigDecimal.ZERO, BigDecimal.ZERO),
                        new Participant(Id.of(new UUID(1,1)), BigDecimal.ZERO, BigDecimal.ZERO)),
                List.of());
    }
}
