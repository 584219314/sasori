package com.sasori.factory.service;

import com.sasori.req.CrawlerDocToDataReq;
import com.sasori.req.CrawlerSetDataReq;
import com.sasori.req.FlipReq;
import com.sasori.req.LoginReq;
import com.sasori.req.MainReq;
import com.sasori.res.CrawlerDocToDataRes;
import com.sasori.res.CrawlerSetDataRes;
import com.sasori.res.FlipRes;
import com.sasori.res.LoginRes;

public interface CrawlerService {
	/**
	 * 数据入库
	 */
	CrawlerSetDataRes setData(CrawlerSetDataReq req);
	
	/**
	 * 页面数据处理
	 * @param req
	 * @return
	 */
	CrawlerDocToDataRes docToData(CrawlerDocToDataReq req);
	
	/**
	 * 获取翻页链接
	 */
	FlipRes flip(FlipReq req);
	
	/**
	 * 整体流程
	 * @throws Exception 
	 */
	void main(MainReq req) throws Exception;
	
}
