package com.javastart;

import java.lang.reflect.*;
import java.lang.annotation.Annotation;
import com.javastart.controller.*;

public class ReflectionDemo {
    public static void main(String[] args) throws Exception {
        // 1. Class: 所有反射的入口
        Class<?> clazz = String.class;  // 拿到 String 的 Class 对象
        System.out.println("=== Class ===");
        System.out.println("类名:       " + clazz.getName());
        System.out.println("简单类名:   " + clazz.getSimpleName());
        System.out.println("包名:       " + clazz.getPackageName());
        System.out.println("父类:       " + clazz.getSuperclass().getName());
        System.out.println("是不是接口: " + clazz.isInterface());
        System.out.println();

        // 2. Constructor: 获取构造方法
        System.out.println("=== Constructor ===");
        Constructor<?>[] constructors = clazz.getConstructors();
        for (Constructor<?> c : constructors) {
            System.out.println("构造方法: " + c);
        }
        // 用指定参数类型获取构造方法并创建实例
        Constructor<?> con = clazz.getConstructor(String.class);
        String str = (String) con.newInstance("Hello");
        System.out.println("通过反射创建: " + str);
        System.out.println();

        // 3. Method: 获取方法
        System.out.println("=== Method ===");
        Method[] methods = clazz.getMethods();
        for (Method m : methods) {
            if (m.getName().startsWith("length") ||
                m.getName().startsWith("charAt")) {
                System.out.println("方法名: " + m.getName() +
                    ", 参数类型: " + java.util.Arrays.toString(m.getParameterTypes()) +
                    ", 返回类型: " + m.getReturnType().getSimpleName());
            }
        }
        // 调用方法
        Method lengthMethod = clazz.getMethod("length");
        int len = (int) lengthMethod.invoke(str);
        System.out.println("str.length() = " + len);

        Method charAtMethod = clazz.getMethod("charAt", int.class);
        char ch = (char) charAtMethod.invoke(str, 1);
        System.out.println("str.charAt(1) = " + ch);
        System.out.println();

        // 4. Field: 获取字段
        System.out.println("=== Field ===");
        Class<?> systemClass = System.class;
        Field[] fields = systemClass.getDeclaredFields();
        for (Field f : fields) {
            if (f.getName().contains("out") || f.getName().contains("err")) {
                System.out.println("字段名: " + f.getName() +
                    ", 类型: " + f.getType().getSimpleName());
            }
        }
        System.out.println();

        // 5. Annotation: 获取注解
        System.out.println("=== Annotation ===");
        Class<?> helloClass = HelloController.class;
        Annotation[] anns = helloClass.getAnnotations();
        for (Annotation a : anns) {
            System.out.println("注解: " + a.annotationType().getName());
        }
        // 直接问有没有某个特定注解
        boolean hasRestController = helloClass.isAnnotationPresent(
            org.springframework.web.bind.annotation.RestController.class);
        System.out.println("有 @RestController? " + hasRestController);
        System.out.println();

        // 6. Modifier: 检查修饰符
        System.out.println("=== Modifier ===");
        int mod = String.class.getModifiers();
        System.out.println("String 类: " +
            "public=" + Modifier.isPublic(mod) +
            ", final=" + Modifier.isFinal(mod) +
            ", abstract=" + Modifier.isAbstract(mod));
    }
}
