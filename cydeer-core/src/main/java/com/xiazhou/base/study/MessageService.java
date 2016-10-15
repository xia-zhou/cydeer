package com.xiazhou.base.study;

import java.util.Map;

/**
 * Created by zhangsong on 16/6/18.
 */
public interface MessageService {
	void doRegister(Channel channel);

	void sendMessage(Integer messageId, Map<String, Object> param);
}
