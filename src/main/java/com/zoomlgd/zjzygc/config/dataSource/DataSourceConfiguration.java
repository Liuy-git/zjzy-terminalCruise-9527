package com.zoomlgd.zjzygc.config.dataSource;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import com.baomidou.mybatisplus.core.MybatisConfiguration;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PerformanceInterceptor;
import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.type.JdbcType;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ldw
 */
@Configuration
public class DataSourceConfiguration {


    //ZJZYWX
    @Bean(name = "zjzywx")
    @ConfigurationProperties(prefix = "spring.datasource.zjzywx")//与配置文件中的层次结构相同
    public DataSource zjzywxDataSource() {
        return DruidDataSourceBuilder.create().build();
    }

    //MYSQL
    @Bean(name = "mysql")
    @ConfigurationProperties(prefix = "spring.datasource.mysql")//与配置文件中的层次结构相同
    public DataSource mysqlDataSource() {
        return DruidDataSourceBuilder.create().build();
    }


    /**
     * 动态数据源配置
     *
     * @return
     */
    @Bean
    @Primary
    public DataSource multipleDataSource(@Qualifier("zjzywx") DataSource zjzywxDataSource,
                                         @Qualifier("mysql") DataSource mysqlDataSource

    ) {
        MultipleDataSource multipleDataSource = new MultipleDataSource();
        Map<Object, Object> targetDataSources = new HashMap<>(16);
        targetDataSources.put(DataSourceEnum.ZJZYWX.getValue(), zjzywxDataSource);
        targetDataSources.put(DataSourceEnum.MYSQL.getValue(), mysqlDataSource);
        //添加数据源
        multipleDataSource.setTargetDataSources(targetDataSources);
        //设置默认数据源
        multipleDataSource.setDefaultTargetDataSource(zjzywxDataSource);
        return multipleDataSource;
    }

    @Bean("sqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        MybatisSqlSessionFactoryBean sqlSessionFactory = new MybatisSqlSessionFactoryBean();
        sqlSessionFactory.setDataSource(multipleDataSource(zjzywxDataSource(),mysqlDataSource()));
        sqlSessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:/mapper/*.xml"));

        MybatisConfiguration configuration = new MybatisConfiguration();
        //configuration.setDefaultScriptingLanguage(MybatisXMLLanguageDriver.class);
        configuration.setJdbcTypeForNull(JdbcType.NULL);
        configuration.setMapUnderscoreToCamelCase(true);
        configuration.setCacheEnabled(false);
        sqlSessionFactory.setConfiguration(configuration);
        sqlSessionFactory.setPlugins(new Interceptor[]{ //PerformanceInterceptor(),OptimisticLockerInterceptor()
                paginationInterceptor() //添加分页功能
        });
        return sqlSessionFactory.getObject();
    }

    /*
     * 分页插件，自动识别数据库类型
     * 多租户，请参考官网【插件扩展】
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }

    /**
     * SQL执行效率插件
     */
    @Bean
    public PerformanceInterceptor performanceInterceptor() {
        PerformanceInterceptor performanceInterceptor = new PerformanceInterceptor();
        return performanceInterceptor;
    }
}
