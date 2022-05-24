package com.demo.main;

import java.util.Random;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import org.springframework.web.server.ResponseStatusException;

import com.demo.model.Accreditation;
import com.demo.model.AccreditationResponse;
import com.demo.validators.AccreditationValidator;

import reactor.core.publisher.Mono;

@Component
public class ValidationHandler {
	public Mono<ServerResponse> handleRequest(final ServerRequest request) {
		Validator validator = new AccreditationValidator();
		Mono<AccreditationResponse> responseBody = request.bodyToMono(Accreditation.class).map(body -> {
			Errors errors = new BeanPropertyBindingResult(body, Accreditation.class.getName());
			validator.validate(body, errors);

			if (errors == null || errors.getAllErrors().isEmpty()) {
				return new AccreditationResponse(true, new Random().nextInt(10) >= body.getPayload().getDocuments().size());

			} else {
				String errorMessage = errors.getAllErrors().stream().map(e -> e.getDefaultMessage()).collect(Collectors.joining(","));
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST, errorMessage);
			}

		});
		return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(responseBody, AccreditationResponse.class);

	}
}