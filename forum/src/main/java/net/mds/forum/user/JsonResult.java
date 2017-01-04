package net.mds.forum.user;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class JsonResult {
	@JsonProperty
	private Boolean success;
	@JsonProperty
	private List<String> errorCodes;
	public Boolean getSuccess() {
		return success;
	}
	public void setSuccess(Boolean success) {
		this.success = success;
	}
	public List<String> getErrorCodes() {
		return errorCodes;
	}
	public void setErrorCodes(List<String> errorCodes) {
		this.errorCodes = errorCodes;
	}
	@Override
	public String toString() {
		return "JsonResult [success=" + success + ", errorCodes=" + errorCodes + "]";
	}
}
