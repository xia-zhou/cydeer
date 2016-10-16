package com.cydeer.core.pattern.state;

/**
 * @author Cydeer on 16/6/10.
 */
public class SoldState implements State {
	private CandyMachine candyMachine;

	public SoldState(CandyMachine candyMachine) {
		this.candyMachine = candyMachine;
	}

	@Override public void checkInventory() {
		System.out.println("卖出了一个糖果");
		candyMachine.setState(candyMachine.getNoMoneyState());
		candyMachine.minCandy();
		if (candyMachine.getCount() <= 0) {
			candyMachine.setState(candyMachine.getSoldOutState());
		}
	}
}
