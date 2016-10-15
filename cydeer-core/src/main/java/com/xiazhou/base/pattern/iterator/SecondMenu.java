package com.xiazhou.base.pattern.iterator;

import java.util.Iterator;

/**
 * Created by zhangsong on 16/6/8.
 */
public class SecondMenu implements Menu {
	private MenuItem[] menuItems = new MenuItem[3];

	private int pos = 0;

	public MenuItem[] getMenuItems() {
		return menuItems;
	}

	public void setMenuItems(MenuItem[] menuItems) {
		this.menuItems = menuItems;
	}

	public void addMenuItem(MenuItem menuItem) {
		if (pos >= menuItems.length) {
			MenuItem[] temp = new MenuItem[menuItems.length * 2];
			System.arraycopy(menuItems, 0, temp, 0, menuItems.length);
			menuItems = temp;
		}
		menuItems[pos] = menuItem;
		pos++;
	}

	@Override public Iterator<MenuItem> createIterator() {
		return new SelfIterator(menuItems);
	}
}
