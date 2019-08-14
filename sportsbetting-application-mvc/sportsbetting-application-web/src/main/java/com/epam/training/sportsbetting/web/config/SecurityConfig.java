package com.epam.training.sportsbetting.web.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.epam.training.sportsbetting.web.service.AuthenticationService;

@Configuration
@EnableWebSecurity
@ComponentScan(basePackages = "com.epam.training.sportsbetting.web")
public class SecurityConfig extends WebSecurityConfigurerAdapter {
 
	@Bean
	public UserDetailsService userDetailsService() {
		return new AuthenticationService();
	};
	
	@Autowired
    PasswordEncoder passwordEncoder;
 
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    	auth.userDetailsService(userDetailsService()).passwordEncoder(passwordEncoder);
    }
 
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
 
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        
    	http.csrf().disable();
    	
    	http
          .authorizeRequests()
        	.antMatchers("/login").permitAll()
        	.antMatchers("/register").permitAll()
        	.antMatchers("/home").hasRole("USER")
        	.antMatchers("/**").hasAnyRole("USER")
          .and().formLogin()
          	.loginPage("/login")
          	.defaultSuccessUrl("/home")
          	.permitAll()
          .and().logout()
          	.logoutSuccessUrl("/login").permitAll();
          	
    }
}