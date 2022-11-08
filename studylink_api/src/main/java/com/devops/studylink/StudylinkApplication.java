package com.devops.studylink;

import java.io.IOException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/** SWAGGER **
http://localhost:8082/swagger-ui/
**/

@EnableSwagger2
@SpringBootApplication
public class StudylinkApplication {

	public static void main(String[] args) throws IOException {
		/** | Run Spring Boot | **/
		SpringApplication.run(StudylinkApplication.class, args);
	}
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select().apis((RequestHandlerSelectors.any()))
				.paths(PathSelectors.any()).build();
	}

}
