package com.sistemas.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
@ComponentScan("com.sistemas")
public class AppMVC implements WebMvcConfigurer{
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
    	//registry.jsp(prefix, suffix)
        registry.jsp("/WEB-INF/vista/", ".jsp");
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        // la siguiente linea mapea una uri directamente a una vista
    	// jsp view sin necesidad de un controlador
        registry.addViewController("/").setViewName("index");
    }
}
