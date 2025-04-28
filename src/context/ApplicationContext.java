package context;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class ApplicationContext {
    private Map<String, Object> beans = new HashMap<>();
    public static void scanPackage(String packageName) {
        //
    }
    public <T> T getBean(Class<T> type) {
        //
    }
    public <T> T getBean(String name, Class<T> type) {
        //
    }
    private static void registerBean(Class clazz) {
        //
    }
    private static void injectDependencies(Object bean) {
        //
    }
    private <T> T resolveBean(Field field) {
        //
    }
}
