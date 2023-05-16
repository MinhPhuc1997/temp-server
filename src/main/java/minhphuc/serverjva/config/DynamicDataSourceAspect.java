package minhphuc.serverjva.config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Component
@Aspect
@Order(value = 1)
public class DynamicDataSourceAspect {

    @Pointcut("execution(* minhphuc.serverjva.controller..*.*(..)))")
    public void dataSourcePointCut() {
    }


    @Around("dataSourcePointCut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        DynamicRoutingDataSource.setDataSource(DataSourceType.ERP);
        try {
            return point.proceed();
        } finally {
            DynamicRoutingDataSource.clearDataSource();
        }
    }
}
