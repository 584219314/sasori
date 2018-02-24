package com.sasori.service;

import java.util.List;

import com.sasori.model.CrawlerData;

public interface CrawlerDataService {
	void add(CrawlerData model);
	
	void addList(List<CrawlerData> list);
}
