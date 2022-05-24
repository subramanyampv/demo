package com.demo.main;

import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.demo.util.Utils;

@Configuration(proxyBeanMethods = false)
public class AccreditationRouter {

	@Bean
	public RouterFunction<ServerResponse> route(ValidationHandler handler) {
		return RouterFunctions.route(POST(Utils.REQUEST_URL).and(accept(MediaType.APPLICATION_JSON)), handler::handleRequest);
	}

}