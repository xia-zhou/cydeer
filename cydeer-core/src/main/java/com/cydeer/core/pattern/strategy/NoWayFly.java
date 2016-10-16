package com.cydeer.core.pattern.strategy;

/**
 * @author Cydeer on 16/5/22.
 */
public class NoWayFly implements FlyBehavior {
	@Override public void fly() {
		System.out.println("I can no way fly!");
	}
}
