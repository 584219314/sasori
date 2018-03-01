package com.sasori.task;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.sasori.crawler.util.CrawlerThread;
import com.sasori.crawler.util.URLFecter;
import com.sasori.enums.CrawlerEnum;
import com.sasori.factory.service.CrawlerService;
import com.sasori.req.CrawlerDocToDataReq;
import com.sasori.req.CrawlerSetDataReq;
import com.sasori.req.FlipReq;
import com.sasori.req.MainReq;
import com.sasori.res.CrawlerDocToDataRes;
import com.sasori.res.FlipRes;

@Component("crawlerTask")
public class CrawlerTask {
	@Autowired
	private CrawlerService crawlerService;

	public void jym() throws Exception {
/*		CrawlerThread thread = new CrawlerThread(CrawlerEnum.JYM.getCode());
		new Thread(thread).start();*/
		CrawlerThread thread1 = new CrawlerThread(CrawlerEnum.ZH.getCode());
		new Thread(thread1).start();
	}
}
