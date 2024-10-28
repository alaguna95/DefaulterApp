package com.galibox.defaulterApp.expense.domain;

import com.galibox.defaulterApp.group.domain.Group;
import com.galibox.defaulterApp.shared.Amount;
import com.galibox.defaulterApp.shared.Id;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public final class Expense {
    
    private final Id id;
    
    private final Id groupId;
    
    private final Name name;
    
    private final Amount totalAmount;
    
    private final List<UserExpense> userExpenses;
    
    public static Expense create(
            Id id, 
            Group group, 
            Name name, 
            Amount totalAmount, 
            List<UserExpense> userExpenses) {

        if(id == null){
            throw new IllegalArgumentException("The id is null");
        }

        if(group == null) {
            throw new IllegalArgumentException("The group is null");
        }
        
        if(name == null) {
            throw new IllegalArgumentException("The name is null");
        }
        
        checkUserExpenses(group, totalAmount, userExpenses);
        
        return new Expense(id, group.getId(), name, totalAmount, userExpenses);
    }

    public Expense update(
            Group group,
            Amount totalAmount,
            List<UserExpense> userExpenses) {

        if(group == null) {
            throw new IllegalArgumentException("The group is null");
        }        
        
        if(!group.getId().equals(groupId)) {
            throw new IllegalArgumentException("The group id is different from the current one");
        }
        
        checkUserExpenses(group, totalAmount, userExpenses);
        
        return new Expense(id, groupId, name, totalAmount, userExpenses);
    }
    
    private static void checkUserExpenses(
            Group group,
            Amount totalAmount,
            List<UserExpense> userExpenses){
        
        if(userExpenses == null){
            throw new IllegalArgumentException("The list of user expenses is null");
        }

        if(totalAmount == null){
            throw new IllegalArgumentException("The total amount is null");
        }

        if(userExpenses.isEmpty()){
            throw new IllegalArgumentException("The list of user expenses is empty");
        }

        if(userExpenses.stream().map(UserExpense::getUserId).collect(Collectors.toSet()).size() != userExpenses.size()) {
            throw new IllegalArgumentException("The list of user expenses contains duplicates");
        }

        if(!userExpenses.stream().map(UserExpense::getAmount).reduce(Amount::add).get().equals(totalAmount)) {
            throw new IllegalArgumentException("The sum of the user expenses is not equal to the total amount");
        }

        for(UserExpense userExpense : userExpenses) {
            if(group.getParticipants().stream().noneMatch(participant -> participant.getUserId().equals(userExpense.getUserId()))) {
                throw new IllegalArgumentException("User " + userExpense.getUserId() + " is not a participant of the group");
            }
        }
    }
    
}
