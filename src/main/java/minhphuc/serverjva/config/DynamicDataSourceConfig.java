package minhphuc.serverjva.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.google.common.collect.Maps;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.util.Map;

@Configuration
public class DynamicDataSourceConfig {

    @Bean(name = "erpDataSource")
    @ConfigurationProperties("spring.datasource.erp")
    public DataSource erpsDataSource() {
        return new DruidDataSource();
    }

    @Bean(name = "jlkDataSource")
    @ConfigurationProperties("spring.datasource.jlk")
    public DataSource jlksDataSource() {
        return new DruidDataSource();
    }

    @Bean
    @Primary
    public DynamicRoutingDataSource dataSource(DataSource erpDataSource,DataSource jlkDataSource) {
        Map<Object, Object> targetDataSources = Maps.newHashMapWithExpectedSize(3);
        targetDataSources.put(DataSourceType.ERP, erpDataSource);
        targetDataSources.put(DataSourceType.JLK, jlkDataSource);
        return new DynamicRoutingDataSource(erpDataSource,targetDataSources);
    }
}
