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
            System.out.println(nameBean);
            // =================================== Đến đây thì đúng rồi
            // =================================== Vòng lặp đang lỗi
            for (Field field : clazz.getDeclaredFields()) {
                System.err.println("dependency");
                if (field.isAnnotationPresent(Autowired.class)) {
                    String nameDependency = field.getType().getSimpleName();
                    if (field.isAnnotationPresent(Qualifier.class)) {
                        Qualifier qualifier = field.getAnnotation(Qualifier.class);
                        nameDependency = qualifier.value();
                    }
                    Object dependency = beans.get(nameDependency);

                    if (dependency == null) { throw new RuntimeException("Missing dependency for: " + nameDependency); }
                    field.setAccessible(true);
                    field.set(instance, dependency);
                }
            }
        } catch (InstantiationException | IllegalAccessException e) {
            System.err.println("Conmeno, lailoiroi, timlaithoi");
        }
    }

    public Object getBean(String contr) {
        return beans.get(contr);
    }
}
