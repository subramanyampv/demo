package com.demo.main;

import static io.restassured.RestAssured.given;

import java.net.URI;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.demo.util.Utils;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AccreditationRouterTest {
	@LocalServerPort
	private Integer port;

	@Test
	public void testSuccess() {
		final String requestJson = "{\"user_id\": \"abcd\",\"payload\": {\"accreditation_type\": \"BY_INCOME\",\"documents\": [{\"name\": \"2018.pdf\",\"mime_type\": \"application/pdf\",\"content\": \"ICAiQC8qIjogWyJzcmMvKiJdCiAgICB9CiAgfQp9Cg==\"},{\"name\": \"2019.jpg\",\"mime_type\": \"image/jpeg\",\"content\": \"91cy1wcm9taXNlICJeMi4wLjUiCiAgICB0b3Bvc29ydCAiXjIuMC4yIgo=\"}]}}";

		given().contentType("application/json").accept("application/json").body(requestJson).post(URI.create("http://localhost:" + port + Utils.REQUEST_URL)).then()
				.statusCode(200);
	}
	
	@Test
	public void testBadRequest() {
		final String requestJson = "{\"user_id\": \" \",\"payload\": {\"accreditation_type\": \"BY_INCOME\",\"documents\": [{\"name\": \"2018.pdf\",\"mime_type\": \"application/pdf\",\"content\": \"ICAiQC8qIjogWyJzcmMvKiJdCiAgICB9CiAgfQp9Cg==\"},{\"name\": \"2019.jpg\",\"mime_type\": \"image/jpeg\",\"content\": \"91cy1wcm9taXNlICJeMi4wLjUiCiAgICB0b3Bvc29ydCAiXjIuMC4yIgo=\"}]}}";

		given().contentType("application/json").accept("application/json").body(requestJson).post(URI.create("http://localhost:" + port + Utils.REQUEST_URL)).then()
				.statusCode(400);
	}

}
