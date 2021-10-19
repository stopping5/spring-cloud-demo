package com.stopping.cloud.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @Description UsernameGatewayFliter
 * @Author stopping
 * @date: 2021/4/19 11:58
 */
@Component
@Slf4j
public class UsernameGatewayFilter implements GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        MultiValueMap<String, String> parMaps = exchange.getRequest().getQueryParams();
        if (parMaps.get("username") == null){
            exchange.getResponse().setStatusCode(HttpStatus.NOT_FOUND);
            return exchange.getResponse().setComplete();
        }
        String username = parMaps.get("username").get(0);
        log.info("username:{}",username);
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
