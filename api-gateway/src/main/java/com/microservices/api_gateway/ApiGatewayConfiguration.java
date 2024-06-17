package com.microservices.api_gateway;

import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.Buildable;
import org.springframework.cloud.gateway.route.builder.PredicateSpec;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Function;

@Configuration
public class ApiGatewayConfiguration {

    @Bean
    public RouteLocator gatewayRouter(RouteLocatorBuilder builder) {
        Function<PredicateSpec, Buildable<Route>> routeFunction = p -> p.path("/get")
                .filters(f -> f.addRequestHeader("sanajitjana", "https://sanajitjana.github.io")
                        .addRequestParameter("Param", "MyValue")
                )
                .uri("http://httpbin.org:80");
        return builder.routes()
                .route(routeFunction)
                .route(p->p.path("/service1/**").uri("lb://CURRENCY-EXCHANGE"))
                .route(p->p.path("/service2/**").uri("lb://CURRENCY-CONVERSION"))
                .build();
    }

}
