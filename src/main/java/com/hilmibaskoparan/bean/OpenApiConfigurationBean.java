package com.hilmibaskoparan.bean;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@EnableSwagger2
@Configuration
public class OpenApiConfigurationBean {

    @Bean
    public OpenAPI openAPIMethod() {
        return new OpenAPI().info(new Info()
                .title("Title information")
                .description("Description information")
                .version("V1.0")
                .contact(new Contact()
                        .name("Hilmi")
                        .url("www.hilmibaskoparan.com.tr")
                        .email("h.baskoparan@gmail.com"))
                .termsOfService(" Software INC.")
                .license(new License()
                        .name("Licence ")
                        .url("www."))
        );
    }
}

//localhost:4040/swagger-ui.html
//swagger: API Document
