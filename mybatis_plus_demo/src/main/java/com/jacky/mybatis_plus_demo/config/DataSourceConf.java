package com.jacky.mybatis_plus_demo.config;

import com.baomidou.mybatisplus.spring.MybatisSqlSessionFactoryBean;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

@Configuration
public class DataSourceConf {

    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
        MybatisSqlSessionFactoryBean mybatisSqlSessionFactoryBean = new MybatisSqlSessionFactoryBean();
        mybatisSqlSessionFactoryBean.setDataSource(dataSource);
//        mybatisSqlSessionFactoryBean.setMapperLocations(
//                new PathMatchingResourcePatternResolver().getResources("classpath*:mapper/*Mapper.xml"));
//
//        mybatisSqlSessionFactoryBean.setTypeAliasesPackage("com.jacky.mybatis_plus_demo.entity");

//        factoryBean.setPlugins(new Interceptor[] { paginationInterceptor(), optimisticLockerInterceptor() ,sqlExplainInterceptor(),performanceInterceptor()});
//        mybatisSqlSessionFactoryBean.setGlobalConfig(this.globalConfiguration());
        return mybatisSqlSessionFactoryBean.getObject();
    }

}
