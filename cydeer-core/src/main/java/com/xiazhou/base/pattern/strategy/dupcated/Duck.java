package com.xiazhou.base.pattern.strategy.dupcated;

import com.xiazhou.base.pattern.strategy.FlyBehavior;
import com.xiazhou.base.pattern.strategy.QuackBehavior;

import java.io.Serializable;

/**
 * Created by zhangsong on 16/5/22.
 */
public class Duck implements Serializable {
	private FlyBehavior flyBehavior;
	private QuackBehavior quackBehavior;

	public void setFlyBehavior(FlyBehavior flyBehavior) {
		this.flyBehavior = flyBehavior;
	}

	public void setQuackBehavior(QuackBehavior quackBehavior) {
		this.quackBehavior = quackBehavior;
	}

	public Duck(FlyBehavior flyBehavior, QuackBehavior quackBehavior) {
		this.flyBehavior = flyBehavior;
		this.quackBehavior = quackBehavior;
	}

	public void flyPerform() {
		flyBehavior.fly();
	}

	public void quackPerform() {
		quackBehavior.quack();
	}

	public void fly() {
		System.out.println("I can fly!");
	}

	public void quack() {
		System.out.println("I can quack!");
	}

	public void disPlay() {
		System.out.println("I am a Duck!");
	}

}
