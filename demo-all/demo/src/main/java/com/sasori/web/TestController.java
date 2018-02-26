package com.sasori.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sasori.factory.service.CrawlerService;
import com.sasori.model.CrawlerData;
import com.sasori.service.CrawlerDataService;

@Controller
@RequestMapping("test")
public class TestController {
	@Autowired
	private CrawlerDataService crawlerDataService;
	@RequestMapping("/demo")
	public String test(){
		CrawlerData model = new CrawlerData();
		model.setId(1111111);
		crawlerDataService.add(model);
		return "test";
	}
}
