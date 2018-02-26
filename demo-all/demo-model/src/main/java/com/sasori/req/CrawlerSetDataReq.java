package com.sasori.req;

import java.io.Serializable;
import java.util.List;

import com.sasori.model.CrawlerData;
import com.sasori.model.Zhihu;

public class CrawlerSetDataReq implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7449089125905390898L;
	
	private String code;
	private List<Zhihu> zhList;
	private List<CrawlerData> list;
	public List<Zhihu> getZhList() {
		return zhList;
	}

	public void setZhList(List<Zhihu> zhList) {
		this.zhList = zhList;
	}

	public List<CrawlerData> getList() {
		return list;
	}

	public void setList(List<CrawlerData> list) {
		this.list = list;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
}
