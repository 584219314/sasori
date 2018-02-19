package com.sasori.service.impl;

import org.springframework.stereotype.Service;

import com.sasori.service.TestService;

@Service("testService")
public class TestServiceImpl implements TestService {

	@Override
	public void test() {
			System.out.println("hello xixi");
	}

}
