package com.xiazhou.base.pattern.strategy.dupcated;

import com.xiazhou.base.pattern.strategy.NoWayFly;
import com.xiazhou.base.pattern.strategy.YaYaQuack;

/**
 * Created by zhangsong on 16/5/22.
 */
public class RubberDuck extends Duck {

	public RubberDuck() {
		super(new NoWayFly(), new YaYaQuack());
	}

	@Override
	public void disPlay() {
		System.out.println("I am a Rubber Duck!");
	}

	@Override
	public void fly() {
		System.out.println("I can't fly!");
	}

	public void quack() {
		System.out.println("I can 哈哈笑!");
	}
}
