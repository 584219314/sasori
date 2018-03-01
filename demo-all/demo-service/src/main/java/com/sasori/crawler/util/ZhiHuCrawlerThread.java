package com.sasori.crawler.util;

import com.sasori.service.TestService;
import com.sasori.util.ServiceFactory;

public class ZhiHuCrawlerThread implements Runnable{

	@Override
	public void run() {
		TestService testService = (TestService) ServiceFactory.getBean("testService");
		testService.log();
	}

}
