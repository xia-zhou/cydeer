package com.xiazhou.base.pattern.state;

/**
 * Created by zhangsong on 16/6/10.
 */
public class SoldOutState implements State {
	private CandyMachine candyMachine;

	public SoldOutState(CandyMachine candyMachine) {
		this.candyMachine = candyMachine;
	}
}
