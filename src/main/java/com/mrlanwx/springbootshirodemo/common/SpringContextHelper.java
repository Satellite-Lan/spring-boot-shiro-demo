package com.mrlanwx.springbootshirodemo.common;



import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
/**
 * @Auther: lanweixing
 * @Date: 2019/10/23 15:01
 * @Description:
 */
public class SpringContextHelper implements ApplicationContextAware {

    private static ApplicationContext context = null;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }

    public static Object getBean(String name) {
        return context.getBean(name);
    }

    public static Object getBean(Class<?> c) {
        return context.getBean(c);
    }
}
