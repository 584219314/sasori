package com.sasori.factory.abstractimpl;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.Connection.Method;
import org.jsoup.Connection.Response;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;

import com.sasori.factory.CrawlerFactory;
import com.sasori.factory.service.CrawlerService;
import com.sasori.req.LoginReq;
import com.sasori.res.LoginRes;

public abstract class AbstractCrawlerImpl implements CrawlerService,InitializingBean{
	protected abstract String getCode();
	@Autowired
	private CrawlerFactory crawlerFactory;
	@Override
	public void afterPropertiesSet() throws Exception {
		crawlerFactory.setServiceImpl(getCode(), this);		
	}
	
	//登陆应对验证码登陆
	public LoginRes login(LoginReq req) {
		LoginRes res = new LoginRes();
		// map装载表单数据
		Map<String, String> map = new HashMap<String, String>();
		map.put(req.getLoginNameHtml(), req.getLoginName());
		map.put(req.getPasswordHtml(), req.getPassword());
		map.put(req.getVerificationCodeHtml(), req.getVerificationCode());
		// 模拟浏览器创建连接，发起请求
		Connection conn = Jsoup.connect(req.getUrl());
		conn.header("User-Agent",
				"Mozilla/5.0 (compatible; MSIE 9.0; Windows NT 6.1; Trident/5.0; MALC)");
		try {
			Response response = conn
					.ignoreContentType(true)
					.method(Method.POST)
					.data(map).execute();
			if (response.statusCode() == 200) {
				// 获取cookies
				Map<String, String> cookies = response.cookies();
				res.setCookies(cookies);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} 
		return res;
	}

}
