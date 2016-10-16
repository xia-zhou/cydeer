package com.cydeer.core.pattern.strategy.dupcated;

import com.cydeer.core.pattern.strategy.SkingFly;
import com.cydeer.core.pattern.strategy.ZhiZhiQuack;

/**
 * @author Cydeer on 16/5/22.
 */
public class RedDuck extends Duck {

	public RedDuck() {
		super(new SkingFly(), new ZhiZhiQuack());
	}

	@Override
	public void disPlay() {
		System.out.println("I am a red Duck!");
	}

	public void quack() {
		System.out.println("I can 吱吱叫!");
	}
}
