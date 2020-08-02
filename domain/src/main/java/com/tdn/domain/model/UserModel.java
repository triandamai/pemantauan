package com.tdn.domain.model;

import com.google.gson.annotations.SerializedName;

public class UserModel {

	@SerializedName("user_nama")
	private String userNama;

	@SerializedName("user_password")
	private String userPassword;

	@SerializedName("user_id")
	private String userId;

	@SerializedName("user_name")
	private String userName;

	@SerializedName("user_foto")
	private String userFoto;

	public void setUserNama(String userNama){
		this.userNama = userNama;
	}

	public String getUserNama(){
		return userNama;
	}

	public void setUserPassword(String userPassword){
		this.userPassword = userPassword;
	}

	public String getUserPassword(){
		return userPassword;
	}

	public void setUserId(String userId){
		this.userId = userId;
	}

	public String getUserId(){
		return userId;
	}

	public void setUserName(String userName){
		this.userName = userName;
	}

	public String getUserName(){
		return userName;
	}

	public void setUserFoto(String userFoto){
		this.userFoto = userFoto;
	}

	public String getUserFoto(){
		return userFoto;
	}

	@Override
 	public String toString(){
		return 
			"UserModel{" +
			"user_nama = '" + userNama + '\'' + 
			",user_password = '" + userPassword + '\'' + 
			",user_id = '" + userId + '\'' + 
			",user_name = '" + userName + '\'' + 
			",user_foto = '" + userFoto + '\'' + 
			"}";
		}
}