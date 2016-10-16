package com.cydeer.core.pattern.decorate;

/**
 * @author Cydeer on 16/5/31.
 */
public class Flower extends BaseFood {
	public Flower() {
		setDescription("送你大红花");
	}

	@Override public double cost() {
		return 199.99;
	}
}
