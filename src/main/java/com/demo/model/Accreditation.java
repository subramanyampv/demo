package com.demo.model;

import java.util.Objects;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Accreditation {

	@Override
	public int hashCode() {
		return Objects.hash(payload, userId);
	}

	private final String userId;
	private final Payload payload;

	@JsonCreator
	public Accreditation(@JsonProperty("user_id") final String userId, @JsonProperty("payload") final Payload payload) {
		this.userId = userId;
		this.payload = payload;
		//validate();
	}

	public String getUserId() {
		return userId;
	}

	public Payload getPayload() {
		return payload;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Accreditation [userId=");
		builder.append(userId);
		builder.append(", payload=");
		builder.append(payload);
		builder.append("]");
		return builder.toString();
	}

	private void validate() {
		if (StringUtils.isBlank(userId)) {
			throw new IllegalArgumentException("user_id cannot be null/blank");
		}

		if (Objects.isNull(payload)) {
			throw new IllegalArgumentException("payload cannot be null");
		}
	}

}
