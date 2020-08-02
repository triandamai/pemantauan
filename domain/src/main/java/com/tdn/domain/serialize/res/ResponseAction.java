package com.tdn.domain.serialize.res;

import com.google.gson.annotations.SerializedName;

public class ResponseAction{

	@SerializedName("response_code")
	private int responseCode;

	@SerializedName("response_message")
	private String responseMessage;

	@SerializedName("data")
	private Object data;

	@SerializedName("status")
	private boolean status;

	public int getResponseCode(){
		return responseCode;
	}

	public String getResponseMessage(){
		return responseMessage;
	}

	public Object getData(){
		return data;
	}

	public boolean isStatus(){
		return status;
	}

	@Override
	public String toString() {
		return "ResponseAction{" +
				"responseCode=" + responseCode +
				", responseMessage='" + responseMessage + '\'' +
				", data=" + data +
				", status=" + status +
				'}';
	}
}