package com.bueno.component.json.result;

public class ResultMessage {
	
	private final String level;
	private final String message;

	public ResultMessage(String level, String message) {
		super();
		this.level = level;
		this.message = message;
	}
	public String getLevel() {
		return level;
	}
	public String getMessage() {
		return message;
	}
}
