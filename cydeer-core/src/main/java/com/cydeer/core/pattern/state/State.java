package com.cydeer.core.pattern.state;

/**
 * @author Cydeer on 16/6/10.
 */
public interface State {

	default void insertMoney() {
		System.out.println("So Many Corn ,But No Inventory");
	}

	default void backMoney() {
		System.out.println("No way to back Money");
	}

	default boolean confirmCandy() {
		System.out.println("No corn, No candy;No inventory No candy");
		return false;
	}

	default void checkInventory() {
		System.out.println("No Inventory");
	}

}
