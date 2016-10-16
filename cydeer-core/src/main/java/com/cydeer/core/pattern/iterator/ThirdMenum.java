package com.cydeer.core.pattern.iterator;

import java.util.Hashtable;
import java.util.Iterator;

/**
 * @author Cydeer on 16/6/8.
 */
public class ThirdMenum implements Menu {
	private Hashtable<String, MenuItem> menuItems = new Hashtable<>();

	public Hashtable<String, MenuItem> getMenuItems() {
		return menuItems;
	}

	public void setMenuItems(Hashtable<String, MenuItem> menuItems) {
		this.menuItems = menuItems;
	}

	public void addMenuItem(String key, MenuItem menuItem) {
		menuItems.put(key, menuItem);
	}

	@Override public Iterator<MenuItem> createIterator() {
		return menuItems.values().iterator();
	}
}
