package com.cydeer.core.pattern.decorate;

/**
 * @author Cydeer on 16/5/31.
 */
public class CuminWei extends BaseWei {

	public CuminWei(BaseFood baseFood) {
		super(baseFood);
		setDescription(baseFood.getDescription() + ",孜然味");
	}

	@Override public double cost() {
		return 1.99 + super.cost();
	}
}
