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
	@Autowired
	private CrawlerService crawlerService;

	@Test
	public void test() throws Exception {
		String code = CrawlerEnum.DJ.getCode();
		// 初始化一个httpclient
		HttpClient client = new DefaultHttpClient();
		// 我们要爬取的一个地址，这里可以从数据库中抽取数据，然后利用循环，可以爬取一个URL队列
		String url = "http://search.jd.com/Search?keyword=Python&enc=utf-8&book=y&wq=Python&pvid=33xo9lni.p4a1qb";
		// 抓取的数据
		String html = URLFecter.URLParser(client, url);
		CrawlerDocToDataReq reqHtml = new CrawlerDocToDataReq();
		//页面数据处理
		reqHtml.setHtml(html);
		reqHtml.setCode(code);
		CrawlerDocToDataRes resHtml = crawlerService.docToData(reqHtml);
		CrawlerSetDataReq req = new CrawlerSetDataReq();
		// 将抓取的数据插入数据库
		req.setCode(code);
		req.setList(resHtml.getData());
		crawlerService.setData(req);
	}
	public static void main(String[] args) throws Exception {
		 Connection conn = Jsoup.connect("https://www.zhihu.com");     
		 conn.method(Method.GET);     
		 conn.followRedirects(false);     
		 Response response = conn.execute();     
		 System.out.println(response.cookies());    
	}
}
