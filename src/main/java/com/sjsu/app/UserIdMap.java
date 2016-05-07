package com.sjsu.app;

import java.util.HashMap;
import java.util.Map;

public class UserIdMap {
	private Map<String, String> theMap;
	private static UserIdMap userIdMap;

	private UserIdMap() {
		// TODO Auto-generated constructor stub
		theMap = new HashMap<String, String>();
	}

	public static UserIdMap getInstance() {
		if (userIdMap == null) {
			userIdMap = new UserIdMap();
		}
		return userIdMap;
	}

	public void addUserMapping(String anonymousId, String realId) {
		theMap.put(anonymousId, realId);
	}

	public String getUserMapping(String anonymousId) {
		return theMap.get(anonymousId);
	}
}
