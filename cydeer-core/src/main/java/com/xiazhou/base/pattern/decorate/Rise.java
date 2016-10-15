package com.xiazhou.base.pattern.decorate;

/**
 * Created by zhangsong on 16/5/31.
 */
public class Rise extends BaseFood {

	public Rise() {
		setDescription("好吃的大米");
	}

	@Override public double cost() {
		return 12.99;
	}
}

