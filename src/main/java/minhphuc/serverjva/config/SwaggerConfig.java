package minhphuc.serverjva.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    public Docket api(String groupName,String basePackage) {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName(groupName)
                .select()
                .apis(RequestHandlerSelectors.basePackage(basePackage))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());

    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("PMP API")
                .description("API phụ vụ cho PDA và hệ thống chấm công")
                .version("1.0.0")
                .build();
    }

//    @Bean
//    public Docket createSystemApi() {
//        return api("Nhóm dữ liệu hệ thống", "minhphuc.serverjva.controller.system");
//    }
//
//    @Bean
//    public Docket createHrApi() {
//        return api("Nhóm dữ liệu nhân sự", "minhphuc.serverjva.controller.hr");
//    }

}
