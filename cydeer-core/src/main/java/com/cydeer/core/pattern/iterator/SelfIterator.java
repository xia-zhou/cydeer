package com.cydeer.core.pattern.iterator;

import java.util.Iterator;

/**
 * @author Cydeer on 16/6/8.
 */
public class SelfIterator implements Iterator {

	private MenuItem[] menuItems;

	private int pos;

	public SelfIterator(MenuItem[] menuItems) {
		this.menuItems = menuItems;
		pos = 0;
	}

	@Override public boolean hasNext() {
		return menuItems.length > pos;
	}

	@Override public Object next() {
		MenuItem menuItem = menuItems[pos];
		pos++;
		return menuItem;
	}
}
