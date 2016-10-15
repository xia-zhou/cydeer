package com.xiazhou.base.study;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhangsong on 16/6/18.
 */
public abstract class AbstractChannel implements Channel {
	private Map<Integer, Adapter> adapterMap;

	public AbstractChannel() {
		adapterMap = new HashMap<>();
	}

	protected abstract void doSend(Message message);

	@Override public void registerAdapter(Integer messageId, Adapter adapter) {
		adapterMap.put(messageId, adapter);
	}

	@Override public void sendMessage(Integer messageId, Map<String, Object> param) {
		Adapter adapter = adapterMap.get(messageId);
		System.out.println("channelDoSend()");
		if (adapter != null) {
			Message message = adapter.build(messageId, param);
			doSend(message);
		}
	}

}
