package za.co.java.engineer.raymond.shape.api.config;

import org.springframework.context.annotation.Configuration;

import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import springfox.documentation.builders.ApiInfoBuilder;
import static springfox.documentation.builders.PathSelectors.regex;
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
                .select()
				.apis(RequestHandlerSelectors.basePackage("za.co.java.engineer.raymond.shape.api.rest"))
                .paths(regex("/shapes.*"))
//                .paths(PathSelectors.regex("/api.*"))
                .build().apiInfo(metaData());
	}
	
	 private ApiInfo metaData() {
	        return new ApiInfoBuilder()
					.title("Spring Boot REST API for Shape")
	            .description("Shape REST API")
	            .contact(new Contact("Raymond Mashigo", "http://raymondmashigo.co.za", "thlogi712@gmail.com"))
	            .license("MIT")
	            .licenseUrl("https://opensource.org/licenses/MIT")
	            .version("0.0.1")
	            .build();
	    }
	@Override
	protected void addResourceHandlers(ResourceHandlerRegistry  registry) {
		registry.addResourceHandler("swagger-ui.html")
				.addResourceLocations("classpath:/META-INF/resources/");
		registry.addResourceHandler("/webjars/**")
				.addResourceLocations("classpath:/META-INF/resources/webjars/");

	}
}
