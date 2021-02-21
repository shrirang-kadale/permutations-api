/**
 * 
 */
package com.vgroup.permutations.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author skadale
 *
 */
@Configuration
public class WebConfiguration implements WebMvcConfigurer {

 

    /**
     * Registered cors mapping and added methods that needs to be allowed
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").allowedMethods("GET", "POST", "PUT", "DELETE").allowedOrigins("*")
        .allowedHeaders("*");
    }
    
}
