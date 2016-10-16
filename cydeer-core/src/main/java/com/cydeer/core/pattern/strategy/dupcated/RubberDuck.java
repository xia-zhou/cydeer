package com.cydeer.core.pattern.strategy.dupcated;

import com.cydeer.core.pattern.strategy.NoWayFly;
import com.cydeer.core.pattern.strategy.YaYaQuack;

/**
 * @author Cydeer on 16/5/22.
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
