package com.clyao.securityjwt.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket docket(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.clyao.securityjwt.controller"))
                .paths(PathSelectors.any())
                .build()
                .securityContexts(securityContexts())
                .securitySchemes(securitySchemes());
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("king文档")
                .description("我的文档")
                .contact(new Contact("king", "http://www.clyao.com", "837904664@qq.com"))
                .version("1.0")
                .build();
    }

    private List<SecurityScheme> securitySchemes(){
        //设置请求头
        List<SecurityScheme> apiKeyList = new ArrayList<>();
        ApiKey apiKey = new ApiKey("Authorization", "Authorization", "Header");
        apiKeyList.add(apiKey);
        return apiKeyList;
    }

    private List<SecurityContext> securityContexts(){
        //设置需要登录认证路径

        List<SecurityReference> securityReferenceList = new ArrayList<>();
        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        securityReferenceList.add(new SecurityReference("Authorization", authorizationScopes));

        SecurityContext securityContext = SecurityContext.builder()
                .securityReferences(securityReferenceList)
                .operationSelector(o -> o.requestMappingPattern().matches("/.*"))
                .build();

        List<SecurityContext> securityContextList = new ArrayList<>();
        securityContextList.add(securityContext);
        return securityContextList;
    }


}
