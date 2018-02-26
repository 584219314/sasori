package com.sasori.service;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.Connection.Method;
import org.jsoup.Connection.Response;
import org.jsoup.nodes.Document;

import com.sasori.req.LoginReq;
import com.sasori.res.LoginRes;

public class apptets {
	public static LoginRes login(LoginReq req) throws Exception {
		LoginRes res = new LoginRes();
		// map装载表单数据
		Map<String, String> map = new HashMap<String, String>();
		map.put("UserName", req.getLoginName());
		map.put("Password", req.getPassword());
		map.put("VerificationCode", req.getVerificationCode());

		// 模拟浏览器创建连接，发起请求
		Connection conn = Jsoup.connect(req.getUrl());
		conn.header("User-Agent",
				"Mozilla/5.0 (compatible; MSIE 9.0; Windows NT 6.1; Trident/5.0; MALC)");
		Response response = conn
				.ignoreContentType(true)
				.method(Method.POST)
				.data(map).execute();
		if (response.statusCode() == 200) {
			// 获取cookies
			Map<String, String> cookies = response.cookies();
			res.setCookies(cookies);
		} else {
			throw new Exception("请求错误");
		}
		return res;
	}

	public static void main(String[] args) throws Exception {
		LoginReq req = new LoginReq();
		req.setLoginName("admin@zheyi");
		req.setPassword("123456");
		req.setVerificationCode("1111");
		req.setUrl("http://ylxz.zwjk.com/Home/Login");
		LoginRes res = login(req);
		// 利用cookies保存的登录信息进行登录
		Document document = Jsoup
				.connect(
						"http://ylxz.zwjk.com/Home/Login")
				.cookies(res.getCookies()).get();
		document.charset(Charset.forName("UTF-8"));
		System.out.println(document.html());
	}
}
