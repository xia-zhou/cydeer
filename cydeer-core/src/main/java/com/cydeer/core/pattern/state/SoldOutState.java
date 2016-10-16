package com.cydeer.core.pattern.state;

/**
 * @author Cydeer on 16/6/10.
 */
public class SoldOutState implements State {
	private CandyMachine candyMachine;

	public SoldOutState(CandyMachine candyMachine) {
		this.candyMachine = candyMachine;
	}
}
