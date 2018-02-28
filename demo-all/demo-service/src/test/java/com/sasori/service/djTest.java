package com.sasori.service;

import java.io.IOException;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.jsoup.Connection;
import org.jsoup.Connection.Method;
import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.sasori.crawler.util.CrawlerThread;
import com.sasori.crawler.util.JdongMain;
import com.sasori.crawler.util.URLFecter;
import com.sasori.enums.CrawlerEnum;
import com.sasori.factory.service.CrawlerService;
import com.sasori.model.CrawlerData;
import com.sasori.model.JdModel;
import com.sasori.req.CrawlerDocToDataReq;
import com.sasori.req.CrawlerSetDataReq;
import com.sasori.res.CrawlerDocToDataRes;

/**
 * Unit test for simple App.
 */
public class djTest extends BaseJunit4Test {

	@Test
	public void test() throws Exception {
		CrawlerThread thread = new CrawlerThread("241241");
		new Thread(thread).start();
		new Thread(thread).start();
		new Thread(thread).start();
		new Thread(thread).start();
		new Thread(thread).start();
	}
}
