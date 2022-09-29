package com.ideas2it.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * Spring Web MVC Security Java Config Demo Project
 * Configures Spring MVC stuffs.
 *
 * @author www.codejava.net
 *
 */
@Configuration
@ComponentScan("net.codejava.spring")
public class MvcConfig {

    @Bean(name = "viewResolver")
    public InternalResourceViewResolver getViewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }
}
