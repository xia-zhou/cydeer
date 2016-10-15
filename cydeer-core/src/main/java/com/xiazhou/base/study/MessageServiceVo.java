package com.xiazhou.base.study;

import java.util.Map;

/**
 * Created by zhangsong on 16/6/18.
 */
public interface MessageServiceVo {
	void sendMessage(Integer messasgeId, Map<String, Object> param);
}
