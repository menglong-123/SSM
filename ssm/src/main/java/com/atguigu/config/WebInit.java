package com.atguigu.config;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

/**
 * @Author: cml
 * @Description: 用来替代web.xml
 * @Date: 2023/7/8 14:54
 * @Version 1.0
 */
public class WebInit extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    // 设置Spring的配置文件
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{SpringConfig.class};
    }

    @Override
    // 设置SpringMVC的配置文件
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{SpringMVCConfig.class};
    }

    @Override
    // 设置SpringMVC的前端控制器
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    @Override
    protected Filter[] getServletFilters() {
        // 创建编码的过滤器
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setEncoding("UTF-8");
        characterEncodingFilter.setForceEncoding(true);
        // 创建默认的Servlet的过滤器
        HiddenHttpMethodFilter hiddenHttpMethodFilter = new HiddenHttpMethodFilter();

        return new Filter[]{characterEncodingFilter, hiddenHttpMethodFilter};
    }


    @Override
    // 设置监听器
    protected void registerContextLoaderListener(ServletContext servletContext) {
        // 创建 rootApplicationContext
        AnnotationConfigWebApplicationContext webApplicationContext = new AnnotationConfigWebApplicationContext();
        webApplicationContext.register(SpringConfig.class);
        //将rootApplicationContext和ServletContext相关联
        ContextLoaderListener listener = new ContextLoaderListener(webApplicationContext);
        servletContext.addListener(listener);
    }
}
