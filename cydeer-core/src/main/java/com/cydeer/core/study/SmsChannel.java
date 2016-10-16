package com.cydeer.core.study;

/**
 * @author Cydeer on 16/6/18.
 */
public class SmsChannel extends AbstractChannel {
	public SmsChannel(MessageService messageService) {
		messageService.doRegister(this);
	}

	@Override protected void doSend(Message message) {
		System.out.println("smsDoSend()");
	}
}
