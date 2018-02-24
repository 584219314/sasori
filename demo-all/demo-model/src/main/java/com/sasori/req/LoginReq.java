package com.sasori.req;

import java.io.Serializable;

public class LoginReq implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1153693289602274080L;
	private String code;
	private String loginName;
	private String password;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
