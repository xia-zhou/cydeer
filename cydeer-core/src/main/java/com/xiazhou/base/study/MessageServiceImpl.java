package com.xiazhou.base.study;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by zhangsong on 16/6/18.
 */
public class MessageServiceImpl implements MessageService {
	private List<Channel> channels;

	private BlockingQueue<MessageRaw> messageList;

	public MessageServiceImpl() {
		channels = new ArrayList<>();
		messageList = new LinkedBlockingQueue<>();
		Thread thread = new Thread(new Runnable() {
			@Override public void run() {
				callSend();
			}
		});
		thread.start();
	}

	private void callSend() {
		while (true) {
			try {
				MessageRaw messageRaw = messageList.take();
				System.out.println("getMessageRaw()");
				if (messageRaw != null) {
					doSend(messageRaw);
				}
			} catch (InterruptedException e) {
			}

		}
	}

	@Override public void doRegister(Channel channel) {
		channels.add(channel);
	}

	void doSend(MessageRaw messageRaw) {
		for (Channel channel : channels) {
			channel.sendMessage(messageRaw.getId(), messageRaw.getParam());
		}
	}

	@Override public void sendMessage(Integer messageId, Map<String, Object> param) {
		messageList.offer(new MessageRaw(messageId, param));
	}

	class MessageRaw {
		Integer id;
		Map<String, Object> param;

		public MessageRaw(Integer id, Map<String, Object> param) {
			this.id = id;
			this.param = param;
		}

		public Integer getId() {
			return id;
		}

		public Map<String, Object> getParam() {
			return param;
		}
	}
}
