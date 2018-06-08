package com.fundoonotes.searchService.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicate;
import static springfox.documentation.builders.PathSelectors.regex;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import static com.google.common.base.Predicates.or;

@Configuration

/*
 * @EnableSwagger2 :- Indicates that Swagger support should be enabled. This
 * should be applied to a Spring java config and should have an accompanying
 * '@Configuration' annotation.
 */
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	/*
	 * Docket :- A builder which is intended to be the primary interface into the
	 * swagger-springmvc framework. Provides sensible defaults and convenience
	 * methods for configuration.
	 */
	public Docket postsApi() {

		/*
		 * groupName("public-api") :- If more than one instance of Docket exists, each
		 * one must have a unique groupName as supplied by this method. Defaults to
		 * "default".
		 */
		return new Docket(DocumentationType.SWAGGER_2).groupName("public-api").apiInfo(apiInfo()).select()
				.paths(postPaths()).build();
	}

	/*
	 * Predicate :- The Predicates class provides common predicates and related
	 * utilities.
	 */
	private Predicate<String> postPaths() {
		return (regex("/.*"));
	}

	/*
	 * ApiInfoBuilder() :- Builds the api information. 
	 * title :- Updates the api.
	 * title description :- Updates the api description. 
	 * termsOfServiceUrl :- Updates the terms of service url. 
	 * licenseUrl :- Updates the license Url for this API.
	 */
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Swagger API")
				.description("Swagger API reference for developers to build documentation of rest API")
				.termsOfServiceUrl("http://javawithanil.com").contact("vikas gaikwad").license("Sawgger License")
				.licenseUrl("vikas343430@gmail.com").version("1.0").build();
	}
}
