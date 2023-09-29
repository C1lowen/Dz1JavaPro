package com.example.test_spring_varied;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.util.ClassUtils;

import java.awt.*;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.*;
import java.util.List;

public class Context {

    private Map<Class<?>, Map<String, Object>> beans = new HashMap<>();

    public Context(Class<?> configClass) throws Exception {
        scanComponents(configClass);
        autowireBeans();

    }

    public <T> T getBean(Class<T> clazz) {
        return (T) beans.getOrDefault(clazz, new HashMap<>()).get(clazz.getSimpleName());
    }

    public <T> T getBean(Class<T> clazz, String nameBean) {

        return (T) beans.getOrDefault(clazz, new HashMap<>()).get(nameBean);
    }

    private void scanComponents(Class<?> configClass) throws Exception {
        ComponentScan componentScanAnnotation = configClass.getDeclaredAnnotation(ComponentScan.class);
        String[] packagesToScan = componentScanAnnotation.value();
        for (String packageToScan : packagesToScan) {
            for (Class<?> clazz : ClassScanner.findClasses(packageToScan)) {
                if (clazz.isAnnotationPresent(Component.class) || clazz.isAnnotationPresent(Configuration.class)) {
                    String beanName = "";
                    if (clazz.isAnnotationPresent(Configuration.class)) {
                        Configuration annotation = clazz.getAnnotation(Configuration.class);
                        beanName = annotation.value();
                    }
                    if (clazz.isAnnotationPresent(Component.class)) {
                        Component annotation = clazz.getAnnotation(Component.class);
                        beanName = annotation.value();
                    }
                    if(beanName.equals("")){
                        Character firstChar = clazz.getSimpleName().charAt(0);
                        firstChar = Character.toLowerCase(firstChar);
                        beanName = firstChar + clazz.getSimpleName().substring(1);
                    }

                    Map<String, Object> stringObjectMap = beans.getOrDefault(clazz, new HashMap<>());
                    beans.put(clazz, stringObjectMap);

                    stringObjectMap.put(beanName, clazz.getDeclaredConstructor().newInstance());

                    if(clazz.isAnnotationPresent(Configuration.class)){
                        addBeanWithConfiguration(clazz);
                    }
                }
            }
        }
    }

    private void autowireBeans() throws Exception {
        for (Object bean : beans.values()) {
            for (Field field : bean.getClass().getDeclaredFields()) {
                if (field.isAnnotationPresent(Autowired.class)) {
                    field.setAccessible(true);
                    method3(field, bean);
                }
            }
        }
    }

   private void addBeanWithConfiguration(Class<?> clazz) throws Exception{
       Method[] methods = clazz.getDeclaredMethods();
       for(Method method : methods){
           if(method.isAnnotationPresent(Bean.class)){
               Object objectReturnType = method.invoke(clazz.getDeclaredConstructor().newInstance());
               Map<String, Object> stringObjectMap = beans.getOrDefault(objectReturnType.getClass(), new HashMap<>());
               beans.put(objectReturnType.getClass(), stringObjectMap);
               stringObjectMap.put(method.getName(), clazz.getDeclaredConstructor().newInstance());
           }
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
            field.set(bean, list.get(0));
            return;
        }

        if(countPrimary == 1) {
            field.set(bean, beans.get(result));
            return;
        }

        Object resultTestQualifier = testQualifier(field, bean);
        if(resultTestQualifier != null){
            field.set(bean, resultTestQualifier);
        }

        throw new RuntimeException();
    }

    private Object testQualifier(Field field, Object beanClazz){

        if(field.isAnnotationPresent(Qualifier.class)){
            Qualifier qualifier = field.getDeclaredAnnotation(Qualifier.class);
            String name = qualifier.value();
            for(var nameBean : beans.get(beanClazz).values()) {
               if(name.equals(nameBean)){
                   return beans.get(beanClazz).get(nameBean);
               }
            }
        }

        for(var newNameBean : beans.get(beanClazz).values()){
            if(field.getName().equals(newNameBean)){
                return beans.get(beanClazz).get(newNameBean);
            }
        }

        return null;
    }



}
