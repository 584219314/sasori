package com.sasori.factory.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sasori.factory.CrawlerFactory;
import com.sasori.factory.service.CrawlerService;
import com.sasori.req.CrawlerDocToDataReq;
import com.sasori.req.CrawlerSetDataReq;
import com.sasori.req.FlipReq;
import com.sasori.req.LoginReq;
import com.sasori.res.CrawlerDocToDataRes;
import com.sasori.res.CrawlerSetDataRes;
import com.sasori.res.FlipRes;
import com.sasori.res.LoginRes;
@Service("crawlerService")
public class CrawlerServiceImpl implements CrawlerService{
	@Autowired
	private CrawlerFactory crawlerFactory;
	@Override
	public CrawlerSetDataRes setData(CrawlerSetDataReq req) {
		return crawlerFactory.getServiceImpl(req.getCode()).setData(req);
	}
	@Override
	public CrawlerDocToDataRes docToData(CrawlerDocToDataReq req) {
		return crawlerFactory.getServiceImpl(req.getCode()).docToData(req);
	}
	@Override
	public FlipRes flip(FlipReq req) {
		return crawlerFactory.getServiceImpl(req.getCode()).flip(req);
	}
}
