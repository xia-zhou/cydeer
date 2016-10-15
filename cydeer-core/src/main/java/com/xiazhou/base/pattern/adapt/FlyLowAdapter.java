package com.xiazhou.base.pattern.adapt;

/**
 * Created by zhangsong on 16/6/8.
 */
public class FlyLowAdapter implements SecondFlyLow {

	private FirstFly firstFly;

	public FlyLowAdapter(FirstFly firstFly) {
		this.firstFly = firstFly;
	}

	@Override public void flyLow() {
		firstFly.fly();
	}
}
