package com.stackroute.gateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {
	
	 @Bean
	    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
	        return builder.routes()
	                .route("flight", r -> r.path("/passenger/**")
	                        .uri("http://localhost:9099"))
	                .route("developer", r -> r.path("/developer/**")
	                        .uri("http://localhost:9095"))
	                .build();
	    }


}
