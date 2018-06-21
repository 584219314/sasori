package com.sasori.util;

import java.util.Map;

public class SystemConstants {
	public static final  Map<String, String> config = ResourceUtil.getResource("config").getMap();
	public static final String file_path = config.get("filePath");
}
