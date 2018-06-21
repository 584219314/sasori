package com.sasori.web.websocket;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import com.sasori.util.log.LogView;

public class MyWebSocketHandler implements WebSocketHandler {

	private static final Logger log = Logger
			.getLogger(MyWebSocketHandler.class);
	Map<String, Long> mapLineSize = new HashMap<String, Long>();

	// 保存所有的用户session
	private static final ArrayList<WebSocketSession> users = new ArrayList<WebSocketSession>();

	// 连接 就绪时
	@Override
	public void afterConnectionEstablished(WebSocketSession session)
			throws Exception {
		log.info("connect websocket success.......");
		mapLineSize.put(session.getId(), 0L);
		users.add(session);

	}

	// 处理信息
	@Override
	public void handleMessage(final WebSocketSession session,
			WebSocketMessage<?> message) throws Exception {

		/*
		 * Gson gson = new Gson();
		 * 
		 * // 将消息JSON格式通过Gson转换成Map // message.getPayload().toString() 获取消息具体内容
		 * JSONObject msg = JSON.parseObject(message.getPayload().toString());
		 * 
		 * log.info("handleMessage......."+message.getPayload()+"..........."+msg
		 * );
		 * 
		 * // session.sendMessage(message);
		 * 
		 * // 处理消息 msgContent消息内容 TextMessage textMessage = new
		 * TextMessage(msg.get("msgContent").toString(), true); //
		 * 调用方法（发送消息给所有人） 
		 * sendMsgToAllUsers(textMessage);
		 */
		JSONObject msg = JSON.parseObject(message.getPayload().toString());
		final RandomAccessFile randomFile = new RandomAccessFile(new File(msg.get("msgContent").toString()), "rw");
		// 启动一个线程每10秒钟读取新增的日志信息
		ScheduledExecutorService exec = Executors.newScheduledThreadPool(1);
		exec.scheduleWithFixedDelay(new Runnable() {
			public void run() {
				try {
					// 获得变化部分的
					randomFile.seek(mapLineSize.get(session.getId()));
					String tmp = "";
					while ((tmp = randomFile.readLine()) != null) {
						String text = new String(tmp.getBytes("ISO8859-1"),"UTF-8");
						TextMessage textMessage = new TextMessage(text, true); 
						try {
							sendMsgSelfUsers(textMessage, session);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					mapLineSize.put(session.getId(),randomFile.length());
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
		}, 0, 1, TimeUnit.SECONDS);
	}

	// 处理传输时异常
	@Override
	public void handleTransportError(WebSocketSession session,
			Throwable exception) throws Exception {
		// TODO Auto-generated method stub

	}

	// 关闭 连接时
	@Override
	public void afterConnectionClosed(WebSocketSession session,
			CloseStatus closeStatus) throws Exception {

		log.info("connect websocket closed.......");
		mapLineSize.remove(session.getId());
		users.remove(session);

	}

	@Override
	public boolean supportsPartialMessages() {
		// TODO Auto-generated method stub
		return false;
	}

	// 给所有用户发送 信息
	public void sendMsgToAllUsers(WebSocketMessage<?> message) throws Exception {

		for (WebSocketSession user : users) {
			user.sendMessage(message);
		}

	}
	
	
	// 给自己发送 信息
	public void sendMsgSelfUsers(WebSocketMessage<?> message,WebSocketSession session) throws Exception {
			session.sendMessage(message);
	}

}