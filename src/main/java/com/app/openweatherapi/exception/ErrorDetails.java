package com.app.openweatherapi.exception;

import java.util.Date;

public class ErrorDetails {

    private String message;
    private String errorCode;
    private Date timeStamp;
    private String details;
    public ErrorDetails(String message, String errorCode, Date timeStamp, String details) {
        this.message = message;
        this.errorCode = errorCode;
        this.timeStamp = timeStamp;
        this.details = details;
    }

    public String getMessage() {
        return message;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public String getDetails() {
        return details;
    }
}
