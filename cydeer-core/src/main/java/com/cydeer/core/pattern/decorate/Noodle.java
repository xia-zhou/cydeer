package com.cydeer.core.pattern.decorate;

/**
 * @author Cydeer on 16/5/31.
 */
public class Noodle extends BaseFood {

	public Noodle() {
		setDescription("河南烩面");
	}

	@Override
	public double cost() {
		return 7.99;
	}

}
