package com.sasori.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("webso")
public class WebSocketController {
	private Logger log = LoggerFactory.getLogger(WebSocketController.class);
	
	@RequestMapping("/demo")
	public String test(){
		return "index";
	}
}
