package com.xiazhou.base.pattern.iterator;

import java.util.Iterator;
import java.util.List;

/**
 * Created by zhangsong on 16/6/8.
 */
public class Witer {
	private List<Menu> menus;

	public Witer(List<Menu> menus) {
		this.menus = menus;
	}

	public void printMenu() {
		Iterator<Menu> iterator = menus.iterator();
		while (iterator.hasNext()) {
			Menu menu = iterator.next();
			Iterator<MenuItem> menuItems = menu.createIterator();
			while (menuItems.hasNext()) {
				MenuItem menuItem = menuItems.next();
				printMenuItem(menuItem);
			}
		}
	}

	private void printMenuItem(MenuItem menuItem) {
		if (menuItem == null) {
			System.out.println("哎呀,菜单为null了");
			return;
		}
		System.out.println(
				"菜单名字:" + menuItem.getName() + ";菜单描述:" + menuItem.getDesc() + ";价格:" + menuItem.getPrice() + "元");

	}
}
