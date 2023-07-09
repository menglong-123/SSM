package com.atguigu.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.github.pagehelper.PageInterceptor;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.PathResource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Properties;

import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.yaml.snakeyaml.Yaml;

/**
 * @Author: cml
 * @Description:
 * @Date: 2023/7/8 14:54
 * @Version 1.0
 */
@Configuration
// 注解扫描，排除对@Controller注解标识的类
@ComponentScan(basePackages = {"com.atguigu.service"})
// 开启事务的注解驱动，将使用@Transactional标识的方法或类中的所有方法进行事务管理
@EnableTransactionManagement
@MapperScan("com.atguigu.mapper")
public class SpringConfig {

    @Bean
    // 获取数据源
    public DruidDataSource getDataSource() throws FileNotFoundException {
        FileInputStream stream = new FileInputStream("/Users/cuimenglong/Code/Intellij/SSM/ssm/src/main/resources/jdbc.yaml");
        Yaml yaml = new Yaml();
        Map<String, Map<String, String>> map = yaml.load(stream);
        System.out.println(map);
        Map<String, String> jdbc = map.get("jdbc");
        System.out.println(jdbc.get("driver"));
        System.out.println(jdbc.get("url"));
        System.out.println(jdbc.get("username"));
        System.out.println(jdbc.get("password"));
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
    // 配置mapper接口的扫描，可以将指定包下所有的mapper节课，通过SqlSession创建代理实现类对象，并将这些对象交给IOC容器管理
    public MapperScannerConfigurer getMapperScannerConfigurer(){
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setBasePackage("com.atguigu.mapper");
        mapperScannerConfigurer.setAnnotationClass(org.apache.ibatis.annotations.Mapper.class);
        return mapperScannerConfigurer;
    }

    @Bean
    // 配置事务管理器
    public DataSourceTransactionManager getDataSourceTransactionManager(DruidDataSource druidDataSource){
        DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
        transactionManager.setDataSource(druidDataSource);
        return transactionManager;
    }

}
