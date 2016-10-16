package com.cydeer.core.pattern.strategy.dupcated;

import com.cydeer.core.pattern.strategy.GuaGuaQuack;
import com.cydeer.core.pattern.strategy.SkingFly;

/**
 * @author Cydeer on 16/5/22.
 */
public class BlueDuck extends Duck {

	public BlueDuck() {
		super(new SkingFly(), new GuaGuaQuack());
	}

	@Override
	public void disPlay() {
		System.out.println("I am a Blue Duck!");
	}

	public void quack() {
		System.out.println("I can 丫丫叫!");
	}
}
