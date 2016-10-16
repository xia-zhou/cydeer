package com.cydeer.core.pattern.strategy;

/**
 * @author Cydeer on 16/5/22.
 */
public class SkingFly implements FlyBehavior {
	@Override public void fly() {
		System.out.println("I can fly with sking!");
	}
}
