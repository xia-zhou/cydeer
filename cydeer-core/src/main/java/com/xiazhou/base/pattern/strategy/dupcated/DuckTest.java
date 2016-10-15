package com.xiazhou.base.pattern.strategy.dupcated;

import com.xiazhou.base.pattern.strategy.SkingFly;

/**
 * Created by zhangsong on 16/5/22.
 */
public class DuckTest {

	public static void main(String[] args) {
		Duck duck = new BlueDuck();
		Duck duck1 = new RedDuck();
		Duck duck2 = new RubberDuck();
		duck.disPlay();
		duck.flyPerform();
		duck.quackPerform();
		duck1.disPlay();
		duck1.flyPerform();
		duck1.quackPerform();
		duck2.disPlay();
		duck2.flyPerform();
		duck2.quackPerform();
		duck2.setFlyBehavior(new SkingFly());
		duck2.flyPerform();
	}
}
