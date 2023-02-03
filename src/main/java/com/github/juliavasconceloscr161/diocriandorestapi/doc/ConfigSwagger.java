package com.github.juliavasconceloscr161.diocriandorestapi.doc;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;
import java.util.HashSet;

@Configuration
@EnableSwagger2
public class ConfigSwagger {
    private Contact contact(){
        return new Contact(
                "Júlia",
                "http://julia.com/",
                "eu@site.com");
    }

    private ApiInfoBuilder apiInformation(){

        ApiInfoBuilder apiInfoBuilder = new ApiInfoBuilder();
        apiInfoBuilder.title("Title - Rest API");
        apiInfoBuilder.description("API exemplo");
        apiInfoBuilder.version("1.0");
        apiInfoBuilder.termsOfServiceUrl("Termo de uso: Open Source");
        apiInfoBuilder.license("Licença - Sua empresa");
        apiInfoBuilder.licenseUrl("http://julia.com/%22");
                apiInfoBuilder.contact(this.contact());
        return apiInfoBuilder;
    }




    @Bean
    public Docket apiDetail(){
        Docket docket = new Docket(DocumentationType.SWAGGER_2);

        docket
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.github.juliavasconceloscr161.diocriandorestapi.controller"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(this.apiInformation().build())
                .consumes(new HashSet<String>(Arrays.asList("application/json")))
                .produces(new HashSet<String>(Arrays.asList("application/json")));

        return docket;
    }
}