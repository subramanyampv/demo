package com.demo.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Document {

	private final String name;
	private final String mimeType;
	private final String content;

	@JsonCreator
	public Document(@JsonProperty("name") final String name, @JsonProperty("mime_type") final String mimeType, @JsonProperty("content") final String content) {
		this.name = name;
		this.mimeType = mimeType;
		this.content = content;
	}

	public String getName() {
		return name;
	}

	public String getMimeType() {
		return mimeType;
	}

	public String getContent() {
		return content;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Document [name=");
		builder.append(name);
		builder.append(", mimeType=");
		builder.append(mimeType);
		builder.append(", content=");
		builder.append(content);
		builder.append("]");
		return builder.toString();
	}

}
