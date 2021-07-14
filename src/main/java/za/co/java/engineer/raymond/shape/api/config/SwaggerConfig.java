package za.co.java.engineer.raymond.shape.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import springfox.documentation.builders.ApiInfoBuilder;
import static springfox.documentation.builders.PathSelectors.regex;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig extends WebMvcConfigurationSupport{
	@Bean
    public Docket shapeApi() {
		return new Docket(DocumentationType.SWAGGER_2)
                .select()
				.apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any())
                .build();
	}
	
	 private ApiInfo metaData() {
	        return new ApiInfoBuilder()
					.title("Spring Boot REST API for Shapes")
	            .description("\"Spring Boot REST API for Storing Shapes\"")
					.version("1.0.0")
	            .license("MIT")
	            .licenseUrl("https://opensource.org/licenses/MIT")
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
