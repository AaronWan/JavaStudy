package com.study.context;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class SpringServicesContextUtil  implements ApplicationContextAware {
    
    private static ApplicationContext context;//声明一个静态变量保存

    public void setApplicationContext(ApplicationContext context) throws BeansException {
        SpringServicesContextUtil.context = context;
    }
    public static ApplicationContext getContext() {
        return context;
    }
    
    /**
     * 获取Bean
     * @param beanName  
     * @param beanClazz
     * @return
     * @throws BeansException
     */
    public static <T> T getBean(String beanName,Class<T> beanClazz) throws BeansException{
        return context.getBean(beanName, beanClazz);
    }
    
    /**
     * 获取Bean
     * @param beanName  
     * @return
     * @throws BeansException
     */
    @SuppressWarnings("unchecked")
    public static <T> T getBean(String beanName) throws BeansException{
        Object bean = context.getBean(beanName);
        return (T)bean;
    }
    
}
