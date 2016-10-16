package com.cydeer.core.pattern.state;

/**
 * @author Cydeer on 16/6/10.
 */
public class WinnerState implements State {

	private CandyMachine candyMachine;

	public WinnerState(CandyMachine candyMachine) {
		this.candyMachine = candyMachine;
	}

	@Override public void checkInventory() {
		if (candyMachine.getCount() < 2) {
			System.out.println("卖出了一个糖果");
			candyMachine.minCandy();
		} else {
			System.out.println("卖出两个糖果");
			candyMachine.minCandy();
		}
		candyMachine.minCandy();
		candyMachine.setState(candyMachine.getNoMoneyState());
		if (candyMachine.getCount() <= 0) {
			candyMachine.setState(candyMachine.getSoldOutState());
		}
	}
}
