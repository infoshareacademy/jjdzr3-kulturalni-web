package com.infoshareacademy.kulturalniweb.configurer;

import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;

public interface WebMvcConfigurer {

    public void addInterceptors(InterceptorRegistry registry);
}
