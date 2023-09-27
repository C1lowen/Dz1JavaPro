package com.example.test_spring_varied;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.util.ClassUtils;

import java.awt.*;
import java.lang.reflect.Field;
import java.util.*;
import java.util.List;

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

//                    method1(field, bean);
//                    method2(field, bean);
                    method3(field, bean);
                }
            }
        }
    }

    private void method1(Field field, Object bean) throws Exception{
        boolean found = false;
        for (var bean2 : beans.keySet()) {
            if (field.getType().isAssignableFrom(bean2)) {
                field.set(bean, beans.get(bean2));
                found = true;
                break;
            }
        }

        if (!found){
            field.set(bean, beans.get(field.getType()));
        }
    }

    private void method2(Field field, Object bean) throws Exception{
        Class<?> clazz = null;
        int count = 0;
        for (var bean2 : beans.keySet()) {
            if (field.getType().isAssignableFrom(bean2)) {
                clazz = bean2;
                count++;

                if(count >= 2) {
                    throw new RuntimeException();
                }
            }
        }

        if(clazz != null) {
            field.set(bean, beans.get(clazz));
        }
    }

    private void method3(Field field, Object bean) throws Exception{
        List<Class<?>> list = new ArrayList<>();

        for (var bean2 : beans.keySet()) {
            if (field.getType().isAssignableFrom(bean2)) {
               list.add(bean2);
            }
        }

        int countPrimary = 0;
        Class<?> result = null;
        for(var clazz : list){
            if(clazz.isAnnotationPresent(Primary.class)){
                countPrimary++;
                result = clazz;
                if(countPrimary >= 2){
                    throw new RuntimeException();
                }
            }
        }

        if(countPrimary == 0 && list.size() == 1){
            field.set(bean, beans.get(list.get(0)));
        }

        throw new RuntimeException();
    }




}
