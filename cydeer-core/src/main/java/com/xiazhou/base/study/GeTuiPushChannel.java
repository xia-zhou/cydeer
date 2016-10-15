package com.xiazhou.base.study;

/**
 * Created by zhangsong on 16/6/18.
 */
public class GeTuiPushChannel extends AbstractChannel {

	public GeTuiPushChannel(MessageService messageService) {
		super();
		messageService.doRegister(this);
	}

	@Override protected void doSend(Message message) {
		System.out.println("geTuiDoSend()");
	}
}
