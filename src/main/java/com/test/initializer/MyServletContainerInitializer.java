package com.test.initializer;

import javax.servlet.*;
import javax.servlet.annotation.HandlesTypes;
import java.lang.reflect.Modifier;
import java.util.EnumSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * 容器启动的时候，会扫描META-INF/services/javax.servlet.ServletContainerInitializer文件，文件里面有本地的路径指向
 * 注意是classes目录下面的META-INF/services，而不是和WEB-INF并列的那个
 * 自动调用startup方法
 * 容器启动的时候会将@HandlesTypes指定的这个类型的子类和实现传入，不包括本身
 */
@HandlesTypes(value={App.class, Test1.class, Test2.class})
public class MyServletContainerInitializer implements ServletContainerInitializer {

    /**
     * 应用启动的时候，会运行onStartup方法；
     */
    @Override
    public void onStartup(Set<Class<?>> webAppInitializerClasses, ServletContext servletContext) throws ServletException {
        List<App> initializers = new LinkedList<App>();

        if (webAppInitializerClasses != null) {
            for (Class<?> waiClass : webAppInitializerClasses) {
                if (!waiClass.isInterface() && !Modifier.isAbstract(waiClass.getModifiers()) &&
                        App.class.isAssignableFrom(waiClass)) {
                    try {
                        initializers.add((App)waiClass.newInstance());
                    } catch (Throwable ex) {
                        throw new ServletException("Failed to instantiate WebApplicationInitializer class", ex);
                    }
                }
            }
        }
        for (App initializer : initializers) {
            initializer.onStartup(servletContext);
        }
    }
}