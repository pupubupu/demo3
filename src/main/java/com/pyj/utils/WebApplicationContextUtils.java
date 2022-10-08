package com.pyj.utils;

import org.springframework.context.ApplicationContext;

import javax.servlet.ServletContext;

public class WebApplicationContextUtils {
    public static ApplicationContext getApplicationContext(ServletContext servletContext){
        return (ApplicationContext) servletContext.getAttribute("app");
    }
}
