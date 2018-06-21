package com.sasori.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sasori.dao.ZhihuMapper;
import com.sasori.model.Zhihu;
import com.sasori.service.ZhihuService;
@Service("zhihuService")
public class ZhihuServiceImpl implements ZhihuService{
	@Autowired
	private ZhihuMapper zhihuMapper;

	@Override
	public void addList(List<Zhihu> req) {
		if(req.size()>0){
			zhihuMapper.insertList(req);
		}
	}
	@Override
	public void zhihuGroup(String code) {
		zhihuMapper.zhihuGroup(code);		
	}

}
