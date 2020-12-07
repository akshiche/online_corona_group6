package com.cg.onlinecorona;
import static springfox.documentation.builders.PathSelectors.regex;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
/*
 * This Swagger for creating documentation
 * 
 *  @author Akshitha
 *  
 */
@Configuration
@EnableSwagger2
public class Myswaggerconfig {
	/**
	 *
	 *  Desc:Docket is implemented as a bean
	 */
	@Bean
	public Docket postsApi() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(metadata()).select().paths(regex("/api"
				+ ".*")).build();
	}
	
	@SuppressWarnings("deprecation")
	private ApiInfo metadata() {
		return new ApiInfoBuilder().title("RoomModule").description("API reference guide for developers").termsOfServiceUrl("https://www.javacodegeeks.com/").contact("Batra, Yatin").version("1.0").build();	
	}
}