package com.cydeer.core.pattern.decorate;

/**
 * @author Cydeer on 16/5/31.
 */
public class CurryWei extends BaseWei {
	public CurryWei(BaseFood baseFood) {
		super(baseFood);
		setDescription(baseFood.getDescription() + ",咖喱味");
	}

	@Override public double cost() {
		return 0.39 + super.cost();
	}
}
