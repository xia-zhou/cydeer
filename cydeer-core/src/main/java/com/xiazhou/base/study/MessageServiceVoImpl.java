package com.xiazhou.base.study;

import java.util.Map;

/**
 * Created by zhangsong on 16/6/18.
 */
public class MessageServiceVoImpl implements MessageServiceVo {

	@Override public void sendMessage(Integer messasgeId, Map<String, Object> param) {
		new MessageServiceImpl().sendMessage(messasgeId, param);
	}
}
