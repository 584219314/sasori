package com.sasori.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * Unit test for simple App.
 */
public class AppTest extends BaseJunit4Test{
	@Autowired
	private TestService testService;
	@Test
	public void test(){
		testService.test();
	}
}
