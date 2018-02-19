package com.sasori;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("test")
public class TestController {
	
	@RequestMapping(value="demo")
	public String test(){
		return "/page/test";
	}
}
