package com.example.taskTwoThree.entity;

public class ResponseMessage {

	private String content;
	private String status;

	public ResponseMessage(String content, String status) {
		super();
		this.content = content;
		this.status = status;
	}

	public String getMessage() {
		return content;
	}

	public void setMessage(String message) {
		this.content = message;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
