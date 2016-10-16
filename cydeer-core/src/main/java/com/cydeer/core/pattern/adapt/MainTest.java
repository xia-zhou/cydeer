package com.cydeer.core.pattern.adapt;

/**
 * @author Cydeer on 16/6/8.
 */
public class MainTest {
	public static void main(String[] args) {
		ClientTest clientTest = new ClientTest();
		clientTest.ClientFly(new SecondFlyLowBird());
		FirstFly first = new FirstFlyBird();
		first.fly();
		clientTest.ClientFly(new FlyLowAdapter(first));
	}
}
