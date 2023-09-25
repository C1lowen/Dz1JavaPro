package com.example.test_spring_varied;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.util.ClassUtils;

import java.awt.*;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Context {

    private Map<Class<?>, Object> beans = new HashMap<>();

    public Context(Class<?> configClass) throws Exception {
        scanComponents(configClass);
        autowireBeans();
    }

    public <T> T getBean(Class<T> clazz) {
        return (T) beans.get(clazz);
    }

    private void scanComponents(Class<?> configClass) throws Exception {
        ComponentScan componentScanAnnotation = configClass.getDeclaredAnnotation(ComponentScan.class);
        String[] packagesToScan = componentScanAnnotation.value();
        for (String packageToScan : packagesToScan) {
            for (Class<?> clazz : ClassScanner.findClasses(packageToScan)) {
                if (clazz.isAnnotationPresent(Component.class)) {
                    beans.put(clazz, clazz.getDeclaredConstructor().newInstance());
                }
            }
        }
    }

    private void autowireBeans() throws Exception {
        for (Object bean : beans.values()) {
            for (Field field : bean.getClass().getDeclaredFields()) {
                if (field.isAnnotationPresent(Autowired.class)) {
                    field.setAccessible(true);
                    field.set(bean, beans.get(field.getType()));
                }
            }
        }
    }

    @Override
    public String toString() {
        StringBuffer sb =new StringBuffer();
        for(var bean : beans.keySet()){
            sb.append(bean + " ==> " + beans.get(bean) + System.lineSeparator());
        }
        return sb.toString();
    }
}
