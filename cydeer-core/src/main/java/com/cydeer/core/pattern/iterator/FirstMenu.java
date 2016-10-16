package com.cydeer.core.pattern.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Cydeer on 16/6/8.
 */
public class FirstMenu implements Menu {
	private List<MenuItem> menuItems = new ArrayList<>();

	public List<MenuItem> getMenuItems() {
		return menuItems;
	}

	public void setMenuItems(List<MenuItem> menuItems) {
		this.menuItems = menuItems;
	}

	public void addMenuItem(MenuItem menuItem) {
		menuItems.add(menuItem);
	}

	@Override public Iterator<MenuItem> createIterator() {
		return menuItems.iterator();
	}
}
