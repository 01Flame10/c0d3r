package com.coder.main.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/img/**")
//                .addResourceLocations("file://" + uploadPath + "/");
//        registry.addResourceHandler("/files-to-run/**")
//                .addResourceLocations("classpath:/files-to-run/");
        registry.addResourceHandler("/files-to-run/**")
                .addResourceLocations("file:///home/flame/Downloads/Coder/src/main/resources/static/files-to-run/");
    }
}