package com.xiazhou.base.pattern.decorate;

/**
 * Created by zhangsong on 16/5/31.
 */
public class HotWei extends BaseWei {

	public HotWei(BaseFood baseFood) {
		super(baseFood);
		setDescription(baseFood.getDescription() + ",辣味的");
	}

	@Override public double cost() {
		return 0.99 + super.cost();
	}
}
