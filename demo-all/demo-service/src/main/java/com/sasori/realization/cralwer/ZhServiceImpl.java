package com.sasori.realization.cralwer;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.druid.util.StringUtils;
import com.sasori.crawler.util.StingUtil;
import com.sasori.enums.CrawlerEnum;
import com.sasori.factory.abstractimpl.AbstractCrawlerImpl;
import com.sasori.model.CrawlerData;
import com.sasori.model.Zhihu;
import com.sasori.req.CrawlerDocToDataReq;
import com.sasori.req.CrawlerSetDataReq;
import com.sasori.req.FlipReq;
import com.sasori.req.MainReq;
import com.sasori.res.CrawlerDocToDataRes;
import com.sasori.res.CrawlerSetDataRes;
import com.sasori.res.FlipRes;
import com.sasori.service.ZhihuService;

@Service("zhService")
public class ZhServiceImpl extends AbstractCrawlerImpl{

	@Autowired
	private ZhihuService zhihuService;
	@Override
	public CrawlerSetDataRes setData(CrawlerSetDataReq req) {
		zhihuService.addList(req.getZhList());
		clearData(getCode());
		return new CrawlerSetDataRes();
	}

	@Override
	public CrawlerDocToDataRes docToData(CrawlerDocToDataReq req) {
		CrawlerDocToDataRes res = new CrawlerDocToDataRes();
        //获取的数据，存放在集合中
        List<Zhihu> data = new ArrayList<Zhihu>();
        //采用Jsoup解析
        Document doc = Jsoup.parse(req.getHtml());
        //获取html标签中的内容
        Elements elements=doc.select("div[class=explore-feed feed-item]");
        for (Element ele:elements) {
        	String url=ele.select("a[class=question_link]").attr("href");
            String bookIDStr[]=url.split("/");
            String bookID = bookIDStr[2];
            if(StringUtils.isEmpty(bookID)){
            	continue;
            }
            String bookName=ele.select("a[class=question_link]").text();
            String goodString = ele.select("a[class=zm-item-vote-count js-expand js-vote-count]").text();
            String talkString = ele.select("a[class=meta-item toggle-comment js-toggleCommentBox]").text();
            int good = StringUtils.isEmpty(goodString)?0:Integer.parseInt(goodString);
            int talk = 0;
            if(!StringUtils.isEmpty(talkString)){
            	String str[] = talkString.split(" ");
            	if(StingUtil.isNumeric(str[0])){
            		talk = Integer.parseInt(str[0]);
            	}
            }
            //创建一个对象，这里可以看出，使用Model的优势，直接进行封装
            Zhihu jdModel=new Zhihu();
            //对象的值
            jdModel.setCode(req.getCode());
            jdModel.setCodeId(bookID);
            jdModel.setName(bookName);
            jdModel.setGood(good);
			jdModel.setTalk(talk);
            jdModel.setUrl(url);
            //将每一个对象的值，保存到List集合中
            data.add(jdModel);
        }
        res.setZhList(data);
		return res;
	}

	@Override
	public FlipRes flip(FlipReq req) {
		int page = req.getPage()+5;
		String url = "https://www.zhihu.com/node/ExploreAnswerListV2?params=%7B%22offset%22%3A"+page+"%2C%22type%22%3A%22day%22%7D";
		FlipRes res = new FlipRes();
		res.setUrl(url);
		res.setPage(page);
		return res;
	}

	@Override
	protected String getCode() {
		return CrawlerEnum.ZH.getCode();
	}

	@Override
	protected String getUrl() {
		return "https://www.zhihu.com/explore";
	}

	@Override
	public void setDataList(CrawlerDocToDataRes resHtml, CrawlerSetDataReq req) {
		req.setCode(getCode());
		req.setZhList(resHtml.getZhList());
	}

	@Override
	public void clearData(String code) {
		zhihuService.zhihuGroup(code);
	}

	@Override
	public boolean stop(String html) {
		return StringUtils.isEmpty(html);
	}
}
