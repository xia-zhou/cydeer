package com.cydeer.core.pattern.decorate;

/**
 * @author Cydeer on 16/5/31.
 */
public class Rise extends BaseFood {

	public Rise() {
		setDescription("好吃的大米");
	}

	@Override public double cost() {
		return 12.99;
	}
}

