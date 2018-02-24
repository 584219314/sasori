package com.sasori.factory.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.sasori.factory.CrawlerFactory;
import com.sasori.factory.service.CrawlerService;

@Service("crawlerFactory")
public class CrawlerFactoryImpl implements CrawlerFactory{
	private Map<String, CrawlerService> map = new HashMap<String, CrawlerService>();
	@Override
	public CrawlerService getServiceImpl(String code) {
		return map.get(code);
	}

	@Override
	public void setServiceImpl(String code,CrawlerService service) {
		map.put(code, service);		
	}
}
