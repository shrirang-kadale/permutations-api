package com.vgroup.permutations.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author skadale
 *
 */
@Configuration
@EnableWebSecurity
public class BasicConfiguration extends WebSecurityConfigurerAdapter {

    /**
     * It is for role based authentication
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    	PasswordEncoder encoder = 
          PasswordEncoderFactories.createDelegatingPasswordEncoder();
    	auth
          .inMemoryAuthentication()
          .withUser("Shrirang")
          .password(encoder.encode("Kadale"))
          .roles("ADMIN")
          .and()
          .withUser("Kailash")
          .password(encoder.encode("Thale"))
          .roles("USER");
    }


    /**
     * Enabled cors and given permission to access specific URL's using roles
     */
    @Override
    public void configure(HttpSecurity http) throws Exception {
    	http.cors()
    	.and()
    	.httpBasic().and().authorizeRequests()
        .antMatchers("/permutations/1.0/savePermutations").hasRole("USER")
        .antMatchers("/permutations/1.0/getPermutations").hasRole("ADMIN")
        .anyRequest().authenticated()
        .and()
        .csrf().disable().headers().frameOptions().disable();
    	
    }
}