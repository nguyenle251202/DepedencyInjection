package context;

import annotations.Autowired;
import annotations.Component;
import annotations.Qualifier;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class ApplicationContext {
    public static final Map<String, Object> beans = new HashMap<>();                 // tạo 1 kho chứa các beans

    public void Reflection(Class<?> clazz) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        if (!clazz.isAnnotationPresent(Component.class)) {                  // Lỗi ngay đây. cmn
            System.err.println("dasdjaksjdjkasd");
            return;
        }
        try {
            Object instance = clazz.getDeclaredConstructor().newInstance();
            Component component = clazz.getAnnotation(Component.class);
            String nameBean = component.value();
            if (nameBean.isEmpty()) {
                nameBean = clazz.getSimpleName();
            }
            beans.put(nameBean, instance);
            for (Field field : clazz.getDeclaredFields()) {
                if (field.isAnnotationPresent(Autowired.class)) {
                    String nameDependency = field.getType().getSimpleName();
                    if (field.isAnnotationPresent(Qualifier.class)) {
                        Qualifier qualifier = field.getAnnotation(Qualifier.class);
                        nameDependency = qualifier.value();
                    }
                    Object dependency = beans.get(nameDependency);
                    if (dependency == null) {
                        System.err.print("Dell co Dependency");
                    }
                    field.setAccessible(true);
                    field.set(instance, dependency);
                }
            }
        } catch (InstantiationException | IllegalAccessException e) {
            System.err.println("Conmeno, lailoiroi, timlaithoi");
        }
    }

    public Object getBean(String name) {
        return beans.get(name);
    }
}
