package com.sasori.crawler.util;

public class DelyThread  implements Runnable{

	@Override
	public void run() {
		try {
			Thread.sleep(100000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
