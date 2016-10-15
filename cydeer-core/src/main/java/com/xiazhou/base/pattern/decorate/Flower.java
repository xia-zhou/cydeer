package com.xiazhou.base.pattern.decorate;

/**
 * Created by zhangsong on 16/5/31.
 */
public class Flower extends BaseFood {
	public Flower() {
		setDescription("送你大红花");
	}

	@Override public double cost() {
		return 199.99;
	}
}
