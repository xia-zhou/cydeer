package com.xiazhou.base.pattern.strategy;

/**
 * Created by zhangsong on 16/5/22.
 */
public class NoWayFly implements FlyBehavior {
	@Override public void fly() {
		System.out.println("I can no way fly!");
	}
}
