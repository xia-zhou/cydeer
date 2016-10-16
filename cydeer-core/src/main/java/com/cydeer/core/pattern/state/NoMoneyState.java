package com.cydeer.core.pattern.state;

/**
 * @author Cydeer on 16/6/10.
 */
public class NoMoneyState implements State {

	private CandyMachine candyMachine;

	public NoMoneyState(CandyMachine candyMachine) {
		this.candyMachine = candyMachine;
	}

	@Override public void insertMoney() {
		System.out.println("你投入了硬币。");
		candyMachine.setState(candyMachine.getHasMoneyState());
	}
}
