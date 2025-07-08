package api.gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("user-service", r -> r.path("/users/**").uri("lb://user-service"))
                .route("common-service", r -> r.path("/common/**").uri("lb://common-service"))
                .route("notification-service", r -> r.path("/notifications/**").uri("lb://notification-service"))
                .build();
    }
}

