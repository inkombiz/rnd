
package com.inkombizz.master;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@EnableJpaAuditing
@SpringBootApplication(exclude = { ErrorMvcAutoConfiguration.class })
public class ApiApplication 
		extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
	}

}
