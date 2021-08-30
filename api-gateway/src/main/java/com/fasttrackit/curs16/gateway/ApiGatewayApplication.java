package com.fasttrackit.curs16.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class ApiGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiGatewayApplication.class, args);
    }

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()

                .route("products", r -> r.path("/products")
                        .uri("http://localhost:8081/products"))

                .route("authenticate", r -> r.path("/authenticate")
                        .uri("http://localhost:8080/authenticate"))

                .route("registration", r -> r.path("/registration")
                        .uri("http://localhost:8080/api/v1/registration"))

                .route("websocket_http_route", r -> r.path("/websocket/**")
                        .uri("http://localhost:9000"))

                .route("websocket_route", r -> r.path("/websocket")
                        .uri("ws://localhost:9000"))
                .build();
    }

}
