package za.co.java.engineer.raymond.shape.api.config;

import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    public Docket shapeApi() {
		return new Docket(DocumentationType.SWAGGER_2)
                .select().apis(RequestHandlerSelectors.basePackage("za.co.java.engineer.raymond.shape.api.rest"))
                .paths(PathSelectors.regex("/api.*"))
                .build().apiInfo(shapeApiInfo());
	}
	
	 private ApiInfo shapeApiInfo() {
	        return new ApiInfoBuilder().title("Spring Boot REST API for Shape")
	            .description("Shape REST API")
	            .contact(new Contact("Raymond Mashigo", "http://raymondmashigo.co.za", "thlogi712@gmail.com"))
	            .license("MIT")
	            .licenseUrl("https://opensource.org/licenses/MIT")
	            .version("0.0.1")
	            .build();
	    }
}
