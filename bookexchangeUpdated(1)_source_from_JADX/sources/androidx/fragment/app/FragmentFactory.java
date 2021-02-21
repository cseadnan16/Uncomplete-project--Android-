package androidx.fragment.app;

import androidx.collection.SimpleArrayMap;
import androidx.fragment.app.C0198Fragment;
import java.lang.reflect.InvocationTargetException;

public class FragmentFactory {
    private static final SimpleArrayMap<String, Class<?>> sClassMap = new SimpleArrayMap<>();

    private static Class<?> loadClass(ClassLoader classLoader, String className) throws ClassNotFoundException {
        Class<?> clazz = sClassMap.get(className);
        if (clazz != null) {
            return clazz;
        }
        Class<?> clazz2 = Class.forName(className, false, classLoader);
        sClassMap.put(className, clazz2);
        return clazz2;
    }

    static boolean isFragmentClass(ClassLoader classLoader, String className) {
        try {
            return C0198Fragment.class.isAssignableFrom(loadClass(classLoader, className));
        } catch (ClassNotFoundException e) {
            return false;
        }
    }

    public static Class<? extends C0198Fragment> loadFragmentClass(ClassLoader classLoader, String className) {
        try {
            return loadClass(classLoader, className);
        } catch (ClassNotFoundException e) {
            throw new C0198Fragment.InstantiationException("Unable to instantiate fragment " + className + ": make sure class name exists", e);
        } catch (ClassCastException e2) {
            throw new C0198Fragment.InstantiationException("Unable to instantiate fragment " + className + ": make sure class is a valid subclass of Fragment", e2);
        }
    }

    public C0198Fragment instantiate(ClassLoader classLoader, String className) {
        try {
            return (C0198Fragment) loadFragmentClass(classLoader, className).getConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (InstantiationException e) {
            throw new C0198Fragment.InstantiationException("Unable to instantiate fragment " + className + ": make sure class name exists, is public, and has an empty constructor that is public", e);
        } catch (IllegalAccessException e2) {
            throw new C0198Fragment.InstantiationException("Unable to instantiate fragment " + className + ": make sure class name exists, is public, and has an empty constructor that is public", e2);
        } catch (NoSuchMethodException e3) {
            throw new C0198Fragment.InstantiationException("Unable to instantiate fragment " + className + ": could not find Fragment constructor", e3);
        } catch (InvocationTargetException e4) {
            throw new C0198Fragment.InstantiationException("Unable to instantiate fragment " + className + ": calling Fragment constructor caused an exception", e4);
        }
    }
}
