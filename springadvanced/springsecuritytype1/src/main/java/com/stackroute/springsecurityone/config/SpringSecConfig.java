package com.stackroute.springsecurityone.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SpringSecConfig {
	
	
	@Bean
	public UserDetailsService getuserdetails(PasswordEncoder encoder)
	{
		
		UserDetails user1=User.withUsername("Mary")
							.password(encoder.encode("password"))
							.roles("ADMIN","MANAGER")
							.build();
		
							
		UserDetails user2=User.withUsername("Andrew")
				.password(encoder.encode("pass123"))
				.roles("MANAGER")
				.build();
		
		
		return new InMemoryUserDetailsManager(user1,user2);
		
	}
	
	@Bean
	
	public PasswordEncoder getencoder()
	{
		return new BCryptPasswordEncoder();
	}
	

	
	@Bean
	public SecurityFilterChain getFilter(HttpSecurity httpsecure) throws Exception
	{
		
	return	httpsecure.authorizeHttpRequests()
				.requestMatchers("/sampleweb/about").permitAll()
				.and()
				.authorizeHttpRequests().requestMatchers("/sampleweb/**")
				.authenticated().and().formLogin().and().build();
		
	
	
		
	}
 
	
}
