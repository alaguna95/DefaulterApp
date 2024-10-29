package com.galibox.defaulterApp.expense.repository;

import com.galibox.defaulterApp.expense.domain.Expense;
import com.galibox.defaulterApp.expense.domain.Name;
import com.galibox.defaulterApp.shared.Amount;
import com.galibox.defaulterApp.shared.Id;

import java.lang.reflect.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;


final class EntityToDomainMapper {

    private static final List<Class<?>> TYPES= List.of(BigDecimal.class, UUID.class, String.class);
    
    static Object map(Object entity, Class<?> domainClass) {
        try {

            Field[] entityFields = entity.getClass().getDeclaredFields();
            Field[] domainFields = domainClass.getDeclaredFields();
            
           List<Object> args = new ArrayList<>();

            for (Field entityField : entityFields) {
                for (Field domainField : domainFields) {
                    if (entityField.getName().equals(domainField.getName())) {
                        entityField.setAccessible(true);
                        if(TYPES.contains(entityField.getType())) {
                            args.add(mapField(entity, entityField, domainField));
                        } else if(List.class.isAssignableFrom(entityField.getType())){
                            Type genericType = ((ParameterizedType) domainField.getGenericType()).getActualTypeArguments()[0];
                            args.add(((List<?>) entityField.get(entity)).stream()
                                    .map(element -> map(element, (Class<?>) genericType))
                                    .toList());
                        } else{
                            args.add(map(entityField.get(entity), entityField.getType()));
                        }
                    }
                }
            }
            var constructor = domainClass.getDeclaredConstructor(Arrays.stream(domainFields)
                    .map(Field::getType).toArray(Class[]::new));
            constructor.setAccessible(true);
            return constructor.newInstance(args.toArray());
            
        } catch (Exception e) {
            throw new RuntimeException("Error mapping ExpenseEntity to Expense", e);
        }
    }
    
    private static Object mapField(
            Object entity,
            Field entityField,
            Field domainField) 
            throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

        Constructor<?> constructor = domainField.getType().getDeclaredConstructor(entityField.getType());
        constructor.setAccessible(true);
        return constructor.newInstance(entityField.get(entity));
    }
}