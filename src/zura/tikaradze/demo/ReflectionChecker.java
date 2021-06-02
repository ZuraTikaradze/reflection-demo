package zura.tikaradze.demo;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionChecker {
    public void showClassName(Object obj) {
        Class clazz = obj.getClass();
        System.out.println(clazz.getName());
    }

    public void showClassFields(Object obj) {
        Class clazz = obj.getClass();
        //clazz.getFields() // მარტო ხილვადი ფილდები მოაქვს
        Field[] fields = clazz.getDeclaredFields();  // პრივატული ფილდებიც რო წამოიღოს // getFil
        for (Field field : fields) {
            System.out.println(field.getName());
        }
    }

    public void showClassMethods(Object obj) {
        Class clazz = obj.getClass();
        // Method[] methods = clazz.getMethods(); // ამ შემთხვევაში Object კლასისგანმემკვიდრეობით მიღებული მეთოდებსაც ვხედავ
        Method[] methods = clazz.getDeclaredMethods(); // ამ შემთხვევაში მარტო თავის მეთოდებს
        for (Method method : methods) {
            System.out.println(method.getName());
        }
    }

    public void showClassFieldAnnotations(Object obj) {
        Class clazz = obj.getClass();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            Annotation[] annotations = field.getAnnotations();
            for (Annotation annotation : annotations) {
                System.out.println(field.getName() + " - " + annotation.toString());
            }
        }
    }

    public void fillPrivateFields(Object obj) throws IllegalAccessException {
        Class clazz = obj.getClass();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            Annotation annotation = field.getAnnotation(StudentNameAnnotation.class);
            if (annotation == null) {
                continue;
            }
            field.setAccessible(true);
            field.set(obj, "Zura Tikaradze");
            field.setAccessible(false);
        }
    }

    public Object createNewObject(Object obj) throws IllegalAccessException, InstantiationException {
        Class clazz = obj.getClass();
        return clazz.newInstance();
    }
}
