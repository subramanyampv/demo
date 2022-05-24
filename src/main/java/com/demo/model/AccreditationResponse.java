package com.demo.model;

public class AccreditationResponse {

	private boolean success;
	private boolean accredited;

	public AccreditationResponse() {
		super();
	}

	public AccreditationResponse(final boolean success, final boolean accredited) {
		super();
		this.success = success;
		this.accredited = accredited;
	}

	public boolean isAccredited() {
		return accredited;
	}

	public void setAccredited(final boolean accredited) {
		this.accredited = accredited;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(final boolean success) {
		this.success = success;
	}

}
