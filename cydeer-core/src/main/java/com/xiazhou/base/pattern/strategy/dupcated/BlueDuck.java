package com.xiazhou.base.pattern.strategy.dupcated;

import com.xiazhou.base.pattern.strategy.GuaGuaQuack;
import com.xiazhou.base.pattern.strategy.SkingFly;

/**
 * Created by zhangsong on 16/5/22.
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
