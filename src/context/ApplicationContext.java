package context;

import annotations.*;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class ApplicationContext {
    public static final Map<String, Object> beans = new HashMap<>();                 // tạo 1 kho chứa các beans

    public void Reflection(Class<?> clazz) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

        if (!clazz.isAnnotationPresent(Component.class)) {
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
            System.out.println(nameBean);
            // =================================== Đến đây thì đúng rồi

            // ===================================
            for (Field field : clazz.getDeclaredFields()) {
                if (field.isAnnotationPresent(Autowired.class)) {
                    Qualifier qualifier = field.getAnnotation(Qualifier.class);
                    String nameDependency = field.getType().getSimpleName();
                    if (field.isAnnotationPresent(Qualifier.class)) {
                        nameDependency = qualifier.value();
                    }
                    Object dependency = beans.get(nameDependency);
                    field.setAccessible(true);
                    field.set(instance, dependency);
                }
            }
            // ===================================
            System.out.println(instance);
        } catch (InstantiationException | IllegalAccessException e) {
            System.err.println("Conmeno, lailoiroi, timlaithoi");
        }
    }

    public Object getBean(String contr) {
        return beans.get(contr);
    }
}