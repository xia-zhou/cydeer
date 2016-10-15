package com.xiazhou.base.study;

/**
 * Created by zhangsong on 16/6/18.
 */
public class SmsChannel extends AbstractChannel {
	public SmsChannel(MessageService messageService) {
		messageService.doRegister(this);
	}

	@Override protected void doSend(Message message) {
		System.out.println("smsDoSend()");
	}
}
