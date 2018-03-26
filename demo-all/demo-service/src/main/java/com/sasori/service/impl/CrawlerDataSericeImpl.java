package com.sasori.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionTemplate;

import com.sasori.dao.CrawlerDataMapper;
import com.sasori.model.CrawlerData;
import com.sasori.service.CrawlerDataService;

@Service("crawlerDataService")
public class CrawlerDataSericeImpl implements CrawlerDataService {
	@Autowired
	private CrawlerDataMapper crawlerDataMapper;
	@Override
	@Transactional(rollbackFor=Exception.class,isolation=Isolation.REPEATABLE_READ,timeout=30000)
	public synchronized void add(CrawlerData model) {
		int count = crawlerDataMapper.selectCount(model.getName());
		model.setPice(new BigDecimal(count));
		System.out.println("-------------------------------------");
		crawlerDataMapper.insertSelective(model);
	}
	@Override
	public void addList(List<CrawlerData> list) {
		if(list.size()>0){
			crawlerDataMapper.insertList(list);
		}
	}
	@Override
	public void crawlerGroup(String code) {
		 crawlerDataMapper.crawlerGroup(code);
	}
	@Override
	@Transactional(rollbackFor=Exception.class,isolation=Isolation.REPEATABLE_READ,timeout=30000)
	public synchronized void update() {
		CrawlerData res = crawlerDataMapper.selectByPrimaryKey(100814);
		res.setPice(res.getPice().add(new BigDecimal(1)));
		System.out.println("-------------------------------------");
		crawlerDataMapper.updateByPrimaryKeySelective(res);
	}
}
