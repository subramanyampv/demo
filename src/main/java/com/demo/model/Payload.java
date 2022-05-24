package com.demo.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Payload {

	private final String accreditationType;
	private final List<Document> documents;

	@JsonCreator
	public Payload(@JsonProperty("accreditation_type") final String accreditationType, @JsonProperty("documents") final List<Document> documents) {
		this.accreditationType = accreditationType;
		this.documents = documents;
	}

	public String getAccreditationType() {
		return accreditationType;
	}

	public List<Document> getDocuments() {
		return documents;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Payload [accreditationType=");
		builder.append(accreditationType);
		builder.append(", documents=");
		builder.append(documents);
		builder.append("]");
		return builder.toString();
	}
}