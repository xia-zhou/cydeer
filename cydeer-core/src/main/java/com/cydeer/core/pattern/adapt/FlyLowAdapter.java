package com.cydeer.core.pattern.adapt;

/**
 * @author Cydeer on 16/6/8.
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
