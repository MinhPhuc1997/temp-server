package minhphuc.serverjva.config;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import javax.sql.DataSource;
import java.util.Map;

public class DynamicRoutingDataSource extends AbstractRoutingDataSource {
    private static final ThreadLocal<DataSourceType> contextHolder = new ThreadLocal<>();

    public DynamicRoutingDataSource(DataSource defaultTargetDataSource, Map<Object, Object> targetDataSources) {
        super.setDefaultTargetDataSource(defaultTargetDataSource);
        super.setTargetDataSources(targetDataSources);
        super.afterPropertiesSet();
    }

    @Override
    protected Object determineCurrentLookupKey() {
        return getDataSource();
    }

    public static void setDataSource(DataSourceType dataSource) {
        System.out.println("Server đang kết nối đến:"+dataSource);
        contextHolder.set(dataSource);
    }

    public static DataSourceType getDataSource() {
        return contextHolder.get();
    }

    public static void clearDataSource() {

        contextHolder.remove();
    }


}
