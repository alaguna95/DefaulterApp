package com.galibox.defaulterApp.expense.domain;

import lombok.Getter;

@Getter
public final class Name {
    
      private final String value;
    
      public Name(final String value) {
          
          if(value == null) {
              throw new IllegalArgumentException("Name cannot be null");
          }
          this.value = value;
      }
      
}
