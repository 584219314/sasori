package com.sasori.crawler.util;

import com.sasori.model.CrawlerData;
import com.sasori.service.CrawlerDataService;
import com.sasori.service.TestService;
import com.sasori.util.ServiceFactory;

public class ZhiHuCrawlerThread implements Runnable{
	private CrawlerDataService crawlerDataService;
	public ZhiHuCrawlerThread(CrawlerDataService crawlerDataService) {
		this.crawlerDataService = crawlerDataService;
	}

	@Override
	public void run() {
		CrawlerData model = new CrawlerData();
		crawlerDataService.update();
	}

}
