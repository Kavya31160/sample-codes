package com.stackroute.flightjpa.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy   //(proxyTargetClass=true)
public class AspectConfig {

	@Bean
	public PassAspect getaspect()
	{
		return new PassAspect();
	}
}
