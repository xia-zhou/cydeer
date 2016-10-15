package com.xiazhou.base.pattern.state;

import java.util.Random;

/**
 * Created by zhangsong on 16/6/10.
 */
public class HasMoneyState implements State {
	private CandyMachine candyMachine;

	private Random random = new Random();

	public HasMoneyState(CandyMachine candyMachine) {
		this.candyMachine = candyMachine;
	}

	@Override public void backMoney() {
		System.out.println("退换你投入的硬币");
		candyMachine.setState(candyMachine.getNoMoneyState());
	}

	@Override public boolean confirmCandy() {
		int temp = random.nextInt(3);
		System.out.println("请等待,正在为你准备糖果:" + temp);

		if (temp == 1) {
			candyMachine.setState(candyMachine.getWinnerState());
		} else {
			candyMachine.setState(candyMachine.getSoldState());
		}
		return true;
	}
}
