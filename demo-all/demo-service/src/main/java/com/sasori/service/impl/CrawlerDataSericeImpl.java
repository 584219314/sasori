package com.sasori.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sasori.dao.CrawlerDataMapper;
import com.sasori.model.CrawlerData;
import com.sasori.service.CrawlerDataService;

@Service("crawlerDataService")
public class CrawlerDataSericeImpl implements CrawlerDataService {
	
	@Autowired
	private CrawlerDataMapper crawlerDataMapper;
	@Override
	public void add(CrawlerData model) {
		crawlerDataMapper.insertSelective(model);
	}
	@Override
	public void addList(List<CrawlerData> list) {
		crawlerDataMapper.insertList(list);
	}

}
