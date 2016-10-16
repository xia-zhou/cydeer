package com.cydeer.core.pattern.decorate;

/**
 * @author Cydeer on 16/5/31.
 */
public class BaseWei extends BaseFood {

	private BaseFood baseFood;

	public BaseWei(BaseFood baseFood) {
		this.baseFood = baseFood;
	}

	@Override public double cost() {
		return baseFood.cost();
	}
}
