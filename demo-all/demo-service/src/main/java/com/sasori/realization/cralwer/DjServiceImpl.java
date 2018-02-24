package com.sasori.realization.cralwer;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sasori.enums.CrawlerEnum;
import com.sasori.factory.abstractimpl.AbstractCrawlerImpl;
import com.sasori.factory.service.CrawlerService;
import com.sasori.model.CrawlerData;
import com.sasori.model.JdModel;
import com.sasori.req.CrawlerDocToDataReq;
import com.sasori.req.CrawlerSetDataReq;
import com.sasori.req.FlipReq;
import com.sasori.req.LoginReq;
import com.sasori.res.CrawlerDocToDataRes;
import com.sasori.res.CrawlerSetDataRes;
import com.sasori.res.FlipRes;
import com.sasori.res.LoginRes;
import com.sasori.service.CrawlerDataService;

@Service("djService")
public class DjServiceImpl extends AbstractCrawlerImpl{

	@Autowired
	private CrawlerDataService crawlerDataService;
	@Override
	protected String getCode() {
		return CrawlerEnum.DJ.getCode();
	}

	@Override
	public CrawlerSetDataRes setData(CrawlerSetDataReq req) {
		List<CrawlerData> list = req.getList();
		crawlerDataService.addList(list);
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
        Elements elements=doc.select("ul[class=gl-warp clearfix]").select("li[class=gl-item]");
        for (Element ele:elements) {
            String bookID=ele.attr("data-sku");
            String bookPrice=ele.select("div[class=p-price]").select("strong").select("i").text();
            String bookName=ele.select("div[class=p-name]").select("em").text();
            String url=ele.select("div[class=p-name]").select("a").attr("href");
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
        //返回数据
        res.setData(data);
		return res;
	}

	@Override
	public FlipRes flip(FlipReq req) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LoginRes login(LoginReq req) {
		// TODO Auto-generated method stub
		return null;
	}

}
