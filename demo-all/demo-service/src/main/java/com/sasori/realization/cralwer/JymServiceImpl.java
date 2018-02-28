package com.sasori.realization.cralwer;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.druid.util.StringUtils;
import com.sasori.dao.CrawlerDataMapper;
import com.sasori.enums.CrawlerEnum;
import com.sasori.factory.abstractimpl.AbstractCrawlerImpl;
import com.sasori.model.CrawlerData;
import com.sasori.req.CrawlerDocToDataReq;
import com.sasori.req.CrawlerSetDataReq;
import com.sasori.req.FlipReq;
import com.sasori.req.LoginReq;
import com.sasori.res.CrawlerDocToDataRes;
import com.sasori.res.CrawlerSetDataRes;
import com.sasori.res.FlipRes;
import com.sasori.res.LoginRes;
import com.sasori.service.CrawlerDataService;

@Service("jymService")
public class JymServiceImpl extends AbstractCrawlerImpl{

	@Autowired
	private CrawlerDataService crawlerDataService;
	@Override
	public CrawlerSetDataRes setData(CrawlerSetDataReq req) {
		crawlerDataService.addList(req.getList());
		clearData(getCode());
		return new CrawlerSetDataRes();
	}

	@Override
	public CrawlerDocToDataRes docToData(CrawlerDocToDataReq req) {
		CrawlerDocToDataRes res = new CrawlerDocToDataRes();
        //获取的数据，存放在集合中
        List<CrawlerData> data = new ArrayList<CrawlerData>();
        //采用Jsoup解析
        Document doc = Jsoup.parse(req.getHtml());
        //获取html标签中的内容
        Elements elements=doc.select("ul[class=list-con specialList]").select("li[name=goodsItem]");
        for (Element ele:elements) {
            String bookID=ele.select("span[class=name]").select("span[class=is-account]").attr("data-id");
            if(StringUtils.isEmpty(bookID)){
            	continue;
            }
            String bookPrice=ele.select("span[class=price]").text();
            String url=ele.select("span[class=name]").select("span[class=is-account]").select("a").attr("href");
            String bookName=ele.select("span[class=name]").select("span[class=is-account]").select("a").text();
            //创建一个对象，这里可以看出，使用Model的优势，直接进行封装
            CrawlerData jdModel=new CrawlerData();
            //对象的值
            jdModel.setCode(req.getCode());
            jdModel.setCodeId(bookID);
            jdModel.setName(bookName);
            jdModel.setPice(new BigDecimal(bookPrice));
            jdModel.setUrl(url);
            //将每一个对象的值，保存到List集合中
            data.add(jdModel);
        }
        res.setData(data);
		return res;
	}

	@Override
	public FlipRes flip(FlipReq req) {
        //采用Jsoup解析
		int page = req.getPage()+1;
        String url = "https://www.jiaoyimao.com/g4500/n"+page+".html";
		FlipRes res = new FlipRes();
		res.setUrl(url);
		res.setPage(page);
		return res ;
	}

	@Override
	protected String getCode() {
		return CrawlerEnum.JYM.getCode();
	}

	@Override
	protected String getUrl() {
		// TODO Auto-generated method stub
		return "https://www.jiaoyimao.com/g4500/";
	}

	@Override
	public void setDataList(CrawlerDocToDataRes resHtml, CrawlerSetDataReq req) {
		req.setCode(getCode());
		req.setList(resHtml.getData());		
	}

	@Override
	public void clearData(String code) {
		crawlerDataService.crawlerGroup(code);
	}

	@Override
	public boolean stop(String html) {
		if(StringUtils.isEmpty(html)||html.indexOf("page-btn")<0){
			return true;
		}
		return false;
	}

}
