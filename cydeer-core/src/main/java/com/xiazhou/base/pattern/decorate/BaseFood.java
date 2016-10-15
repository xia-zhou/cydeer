package com.xiazhou.base.pattern.decorate;

/**
 * Created by zhangsong on 16/5/31.
 */
public abstract class BaseFood {

	private String description;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double cost() {
		return 0;
	}
}
