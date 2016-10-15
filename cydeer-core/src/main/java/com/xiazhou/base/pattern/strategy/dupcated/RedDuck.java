package com.xiazhou.base.pattern.strategy.dupcated;

import com.xiazhou.base.pattern.strategy.SkingFly;
import com.xiazhou.base.pattern.strategy.ZhiZhiQuack;

/**
 * Created by zhangsong on 16/5/22.
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
