package com.sasori.crawler.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sasori.factory.service.CrawlerService;
import com.sasori.req.MainReq;
import com.sasori.util.ServiceFactory;

public class CrawlerThread implements Runnable{
	private Logger log = LoggerFactory.getLogger(CrawlerThread.class);
	private String code;
	public CrawlerThread(String code) {
		this.code = code;
	}
	@Override
	public void run() {
		CrawlerService crawlerService = (CrawlerService) ServiceFactory.getBean("crawlerService");
		MainReq req = new MainReq();
		req.setCode(code);
		try {
			crawlerService.main(req);
		} catch (Exception e) {
			log.error(code+"爬虫出错------------------------");
			e.printStackTrace();
		}
	}

}
