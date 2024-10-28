package com.galibox.defaulterApp.expense.repository;

import java.lang.reflect.Field;

final class EntityToDomainMapper {

    static <T, U> U map(T entity, Class<U> domainClass) {
        try {
            U domainObject = domainClass.getDeclaredConstructor().newInstance();
            Field[] entityFields = entity.getClass().getDeclaredFields();
            Field[] domainFields = domainClass.getDeclaredFields();

            for (Field entityField : entityFields) {
                entityField.setAccessible(true);
                for (Field domainField : domainFields) {
                    if (entityField.getName().equals(domainField.getName()) &&
                            entityField.getType().equals(domainField.getType())) {
                        domainField.setAccessible(true);
                        domainField.set(domainObject, entityField.get(entity));
                        domainField.setAccessible(false);
                        break;
                    }
                }
                entityField.setAccessible(false);
            }
            return domainObject;
        } catch (Exception e) {
            throw new RuntimeException("Error mapping entity to domain", e);
        }
    }
}