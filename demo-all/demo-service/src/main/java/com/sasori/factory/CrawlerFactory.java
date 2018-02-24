package com.sasori.factory;

import com.sasori.factory.service.CrawlerService;

public interface CrawlerFactory {
	/**
	 * 获取服务
	 * @param code
	 */
	CrawlerService getServiceImpl(String code);
	/**
	 * 注册服务
	 * @param code
	 */
	void setServiceImpl(String code,CrawlerService service);
}
