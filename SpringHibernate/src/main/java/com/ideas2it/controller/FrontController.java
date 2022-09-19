package com.ideas2it.controller;

import com.ideas2it.config.WebMvcConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class FrontController extends AbstractAnnotationConfigDispatcherServletInitializer {
    protected Class<?>[] getRootConfigClasses() {
            return new Class[]{WebMvcConfig.class} ;
    }

    protected Class<?>[] getServletConfigClasses() {
            return new Class[0];
    }

    protected String[] getServletMappings() {
            return new String[] {"/"};
    }
}
