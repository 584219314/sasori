package com.sasori.service;

import java.util.List;

import com.sasori.model.Zhihu;

public interface ZhihuService {
	void addList(List<Zhihu> req);
	
	void zhihuGroup(String code);
}
