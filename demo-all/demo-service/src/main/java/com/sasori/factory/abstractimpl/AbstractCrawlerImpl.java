package com.sasori.factory.abstractimpl;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;

import com.sasori.factory.CrawlerFactory;
import com.sasori.factory.service.CrawlerService;

public abstract class AbstractCrawlerImpl implements CrawlerService,InitializingBean{
	protected abstract String getCode();
	@Autowired
	private CrawlerFactory crawlerFactory;
	@Override
	public void afterPropertiesSet() throws Exception {
		crawlerFactory.setServiceImpl(getCode(), this);		
	}

}
