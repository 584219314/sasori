package com.sasori.req;

import java.io.Serializable;

public class FlipReq implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8084924507481027450L;
	private String code;
	private String html;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getHtml() {
		return html;
	}
	public void setHtml(String html) {
		this.html = html;
	}
}
