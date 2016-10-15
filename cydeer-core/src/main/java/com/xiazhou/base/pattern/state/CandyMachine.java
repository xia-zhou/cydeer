package com.xiazhou.base.pattern.state;

/**
 * Created by zhangsong on 16/6/10.
 */
public class CandyMachine {

	private State state;

	private State noMoneyState;

	private State hasMoneyState;

	private State soldOutState;

	private State soldState;

	private State winnerState;

	public CandyMachine(int count) {
		noMoneyState = new NoMoneyState(this);
		hasMoneyState = new HasMoneyState(this);
		soldOutState = new SoldOutState(this);
		soldState = new SoldState(this);
		winnerState = new WinnerState(this);
		this.count = count;
		state = noMoneyState;
	}

	public State getWinnerState() {
		return winnerState;
	}

	public State getNoMoneyState() {
		return noMoneyState;
	}

	public State getHasMoneyState() {
		return hasMoneyState;
	}

	public State getSoldOutState() {
		return soldOutState;
	}

	public State getSoldState() {
		return soldState;
	}

	private int count;

	public void minCandy() {
		count--;
	}

	public int getCount() {
		return count;
	}

	public void setState(State state) {
		this.state = state;
	}

	public void insertMoney() {
		state.insertMoney();
	}

	public void backMoney() {
		state.backMoney();
	}

	public void confirmCandy() {
		if (state.confirmCandy()) {
			state.checkInventory();
		}
	}
}
