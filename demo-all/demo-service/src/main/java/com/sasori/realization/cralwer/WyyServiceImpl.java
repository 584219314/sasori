package com.sasori.realization.cralwer;

import org.springframework.stereotype.Service;

import com.sasori.factory.abstractimpl.AbstractCrawlerImpl;
import com.sasori.req.CrawlerDocToDataReq;
import com.sasori.req.CrawlerSetDataReq;
import com.sasori.req.FlipReq;
import com.sasori.res.CrawlerDocToDataRes;
import com.sasori.res.CrawlerSetDataRes;
import com.sasori.res.FlipRes;
@Service("wyyService")
public class WyyServiceImpl extends AbstractCrawlerImpl {

	@Override
	public CrawlerSetDataRes setData(CrawlerSetDataReq req) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CrawlerDocToDataRes docToData(CrawlerDocToDataReq req) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FlipRes flip(FlipReq req) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void clearData(String code) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected String getCode() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String getUrl() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setDataList(CrawlerDocToDataRes resHtml, CrawlerSetDataReq req) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean stop(String html) {
		// TODO Auto-generated method stub
		return false;
	}

}
