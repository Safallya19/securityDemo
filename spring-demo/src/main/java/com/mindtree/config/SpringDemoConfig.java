package com.mindtree.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SpringDemoConfig extends WebSecurityConfigurerAdapter {

	@Override 
	protected void configure(AuthenticationManagerBuilder auth) throws Exception
     {

		auth.inMemoryAuthentication().withUser("safal").password(passwordEncoder().encode("safal123")).roles("USER")
				.and().withUser("admin").password(passwordEncoder().encode("admin123")).roles("ADMIN");

		// http.httpBasic().disable().authorizeRequests().antMatchers("*").hasRole("USER");

	}

	@Override 
	protected void configure(HttpSecurity http) throws Exception { 
		http.authorizeRequests() 
				.antMatchers("/test/fileRead").hasAnyRole("ADMIN", "USER") 
				.antMatchers("/test/fileWrite").hasAnyRole("ADMIN") 
				.and() 
				.httpBasic();

	}

	@Bean 
	PasswordEncoder passwordEncoder() { 
		return new BCryptPasswordEncoder();

	}
}
