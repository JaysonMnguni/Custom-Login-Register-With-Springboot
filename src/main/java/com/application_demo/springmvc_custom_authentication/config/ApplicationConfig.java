package com.application_demo.springmvc_custom_authentication.config;

import com.application_demo.springmvc_custom_authentication.interceptors.AdminAccessInterceptor;
import com.application_demo.springmvc_custom_authentication.interceptors.AuthorizationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@ComponentScan(basePackages = {"com.application_demo.springmvc_custom_authentication"})
public class ApplicationConfig extends WebMvcConfigurationSupport {

    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("css/**", "images/**", "js/**")
                .addResourceLocations("classpath:/static/css/","classpath:/static/images/", "classpath:/static/js/");
    }
    // End Of Resource Handler.

    @Bean
    public InternalResourceViewResolver viewResolver(){
        // Init View Resolver:
        InternalResourceViewResolver jspViewResolver = new InternalResourceViewResolver();
        jspViewResolver.setPrefix("/WEB-INF/jsp/");
        jspViewResolver.setSuffix(".jsp");
        jspViewResolver.setViewClass(JstlView.class);

        return jspViewResolver;
    }
    // End Of View Resolver Method.


    // Interceptor Registry:
    @Override
    protected void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(new AuthorizationInterceptor()).addPathPatterns("/admin/*", "/user/*");
        registry.addInterceptor(new AdminAccessInterceptor()).addPathPatterns("/admin/*");
    }
    // End Of Interceptor Registry.
}
