/**
 * 
 */
package com.vgroup.permutations.dto;

import java.time.LocalDateTime;
/**
 * @author skadale
 *
 */
import java.util.List;

public class ErrorResponse {

	private LocalDateTime timeStamp;
	private String errorMessage;
	private Integer errorCode;
	private List<String> details;

	public String getMessage() {
		return errorMessage;
	}

	public void setMessage(String message) {
		this.errorMessage = message;
	}

	public List<String> getDetails() {
		return details;
	}

	public void setDetails(List<String> details) {
		this.details = details;
	}

	public LocalDateTime getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(LocalDateTime timeStamp) {
		this.timeStamp = timeStamp;
	}

	public Integer getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(Integer errorCode) {
		this.errorCode = errorCode;
	}

	@Override
	public String toString() {
		return "ErrorResponse [timeStamp=" + timeStamp + ", message=" + errorMessage + ", errorCode=" + errorCode
				+ ", details=" + details + "]";
	}
	

}