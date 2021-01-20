package com.inkombizz.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.SessionScope;


@Configuration
public class BaseSession extends Session{
	
	@Bean
	@SessionScope
    public Session session() {
        return new Session();
    }
}
