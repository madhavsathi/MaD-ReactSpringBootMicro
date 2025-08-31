package com.example.gatewayservice;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration public class GatewayConfig {
  @Bean public RouteLocator routes(RouteLocatorBuilder b){
    return b.routes()
      .route(r -> r.path("/auth/**").uri("http://auth-service:8081"))
      .route(r -> r.path("/social/**").uri("http://social-service:8082"))
      .route(r -> r.path("/email/**").uri("http://email-service:8083"))
      .route(r -> r.path("/crm/**").uri("http://crm-service:8084"))
      .build();
  }
}
