package com.pyj.listener;


import com.mysql.cj.jdbc.AbandonedConnectionCleanupThread;
import com.pyj.utils.WebApplicationContextUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 此类的作用本来用于监听servlet创建时自动生成spring对象，创建spring容器，后来被spring所取代
 * 现在的此类的作用是在servlet关闭时自动对数据源datasource数据源做出处理，防止内存泄漏
 */
public class MyContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {

//        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
//        //将spring的应用上下文对象存储到ServletContext域中
//        ServletContext servletContext = sce.getServletContext();
//        servletContext.setAttribute("app",app);
//        System.out.println("初始化成功");

        //参数化，在web.xml中配置参数，用servletContext调用
//        ServletContext servletContext = sce.getServletContext();
//        String contextConfigLocation = servletContext.getInitParameter("contextConfigLocation");
//        ApplicationContext app = new ClassPathXmlApplicationContext(contextConfigLocation);
//        //将spring的应用上下文对象存储到ServletContext域中
//        servletContext.setAttribute("app",app);
//        System.out.println("初始化成功");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        try {
            while(DriverManager.getDrivers().hasMoreElements()) {
                DriverManager.deregisterDriver(DriverManager.getDrivers().nextElement());
            }
            AbandonedConnectionCleanupThread.checkedShutdown();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
