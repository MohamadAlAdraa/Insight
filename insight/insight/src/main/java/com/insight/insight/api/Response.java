package com.insight.insight.api;

public enum Response {
    OK(200),
    NOT_OK(201),
	EXCEPTION(0);
	
    private final int value;

    Response(final int newValue) {
        value = newValue;
    }
    
    public int getValue() { return value; }
}
