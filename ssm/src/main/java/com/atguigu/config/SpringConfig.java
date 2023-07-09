package com.atguigu.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.github.pagehelper.PageInterceptor;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import java.io.IOException;
import java.util.*;

import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.yaml.snakeyaml.Yaml;

/**
 * @Author: cml
 * @Description: Spring的配置类
 * @Date: 2023/7/8 14:54
 * @Version 1.0
 */
@Configuration
// 注解扫描，排除对@Controller注解标识的类
@ComponentScan(basePackages = {"com.atguigu.service"})
// 开启事务的注解驱动，将使用@Transactional标识的方法或类中的所有方法进行事务管理
@EnableTransactionManagement
// 配置mapper接口的扫描，可以将指定包下所有的mapper节课，通过SqlSession创建代理实现类对象，并将这些对象交给IOC容器管理
@MapperScan(value = "com.atguigu.mapper", annotationClass = Mapper.class)
public class SpringConfig {

    @Bean
    // 获取数据源
    public DruidDataSource getDataSource() throws IOException {
        // 获取jdbc.yaml文件内容
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        Resource resource = resolver.getResource("classpath:jdbc.yaml");
        Yaml yaml = new Yaml();
        Map<String, Map<String, String>> map = yaml.load(resource.getInputStream());

        // 设置数据源
        Map<String, String> jdbc = map.get("jdbc");
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setDriverClassName(jdbc.get("driver"));
        druidDataSource.setUrl(jdbc.get("url"));
        druidDataSource.setUsername(jdbc.get("username"));
        druidDataSource.setPassword(jdbc.get("password"));

        return druidDataSource;
    }

    @Bean
    // Spring整合Mybatis的配置
    public SqlSessionFactory getSessionFactory(DruidDataSource druidDataSource) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();

        // 设置mybatis分页
        PageInterceptor pageInterceptor = new PageInterceptor();
        sqlSessionFactoryBean.setPlugins(pageInterceptor);

        // 设置数据源
        sqlSessionFactoryBean.setDataSource(druidDataSource);
        // 设置下划线到驼峰的映射
        sqlSessionFactoryBean.getObject().getConfiguration().setMapUnderscoreToCamelCase(true);
        // 设置类型别名所对应的包
        sqlSessionFactoryBean.setTypeAliasesPackage("com.atguigu.pojo");


        return sqlSessionFactoryBean.getObject();
    }


    @Bean
    // 配置事务管理器
    public DataSourceTransactionManager getDataSourceTransactionManager(DruidDataSource druidDataSource){
        DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
        transactionManager.setDataSource(druidDataSource);
        return transactionManager;
    }

}
