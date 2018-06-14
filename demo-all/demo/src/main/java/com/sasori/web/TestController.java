package com.sasori.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sasori.model.CrawlerData;
import com.sasori.service.CrawlerDataService;


@Controller
@RequestMapping("test")
public class TestController {
	private Logger log = LoggerFactory.getLogger(TestController.class);
	@Autowired
	private CrawlerDataService crawlerDataService;
	@RequestMapping("/demo")
	@Transactional(rollbackFor=Exception.class)
	public String test(){
		CrawlerData model = new CrawlerData();
		model.setName("lsz");
		crawlerDataService.add(model);
		return "test";
	}
}
