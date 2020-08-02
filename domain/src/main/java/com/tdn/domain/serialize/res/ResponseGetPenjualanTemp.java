package com.tdn.domain.serialize.res;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.SerializedName;
import com.tdn.domain.model.PenjualanTempModel;

public class ResponseGetPenjualanTemp{

	@SerializedName("response_code")
	private int responseCode;

	@SerializedName("response_message")
	private String responseMessage;

	@SerializedName("data")
	private List<PenjualanTempModel> data;

	@SerializedName("status")
	private boolean status;

	public void setResponseCode(int responseCode){
		this.responseCode = responseCode;
	}

	public int getResponseCode(){
		return responseCode;
	}

	public void setResponseMessage(String responseMessage){
		this.responseMessage = responseMessage;
	}

	public String getResponseMessage(){
		return responseMessage;
	}

	public void setData(List<PenjualanTempModel> data){
		this.data = data;
	}

	public List<PenjualanTempModel> getData(){
		if(data == null){
			data = new ArrayList<>();
		}
		return data;
	}

	public void setStatus(boolean status){
		this.status = status;
	}

	public boolean isStatus(){
		return status;
	}

	@Override
 	public String toString(){
		return 
			"ResponseGetPenjualanTemp{" + 
			"response_code = '" + responseCode + '\'' + 
			",response_message = '" + responseMessage + '\'' + 
			",data = '" + data + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}