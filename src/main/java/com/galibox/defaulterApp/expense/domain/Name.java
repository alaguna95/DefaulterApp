package com.galibox.defaulterApp.expense.domain;

import lombok.Getter;

@Getter
public final class Name {
    
      private final String value;
    
      private Name(final String value) {
          
          this.value = value;
      }

    public static Name of(final String value) {
          
        if(value == null) {
            throw new IllegalArgumentException("Name cannot be null");
        }
        return new Name(value);
    }
}
