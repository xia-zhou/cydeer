package com.cydeer.core.study;

import java.util.HashMap;

/**
 * @author Cydeer on 16/6/18.
 */
public class MainTest {
	public static void main(String[] args) {
		MessageService messageService = new MessageServiceImpl();
		new SmsChannel(messageService);
		new NotificationChannel(messageService);
		new GeTuiPushChannel(messageService);
		messageService.sendMessage(123, new HashMap<>());
		messageService.sendMessage(123, new HashMap<>());

	}
}
