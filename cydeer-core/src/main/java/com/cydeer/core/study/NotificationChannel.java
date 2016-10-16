package com.cydeer.core.study;

/**
 * @author Cydeer on 16/6/18.
 */
public class NotificationChannel extends AbstractChannel {
	public NotificationChannel(MessageService messageService) {
		messageService.doRegister(this);
	}

	@Override protected void doSend(Message message) {
		System.out.println("notificationChannelDoSend()");
	}
}
