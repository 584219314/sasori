package com.sasori.res;

import java.io.Serializable;
import java.util.List;

import com.sasori.model.CrawlerData;
import com.sasori.model.JdModel;
import com.sasori.model.Zhihu;

public class CrawlerDocToDataRes implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7676494839678728574L;
	
	private List<Zhihu> zhList;
	private List<CrawlerData> data;

	public List<Zhihu> getZhList() {
		return zhList;
	}

	public void setZhList(List<Zhihu> zhList) {
		this.zhList = zhList;
	}

	public List<CrawlerData> getData() {
		return data;
	}

	public void setData(List<CrawlerData> data) {
		this.data = data;
	}
}
