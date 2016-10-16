package com.cydeer.core.pattern.iterator;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Cydeer on 16/6/8.
 */
public class MainTest {
	public static void main(String[] args) {
		FirstMenu firstMenu = new FirstMenu();
		firstMenu.addMenuItem(new MenuItem("1:轻卡", "贵", 180));
		firstMenu.addMenuItem(new MenuItem("2:轻卡2", "贵", 190));
		firstMenu.addMenuItem(new MenuItem("3:轻卡3", "贵", 110));
		firstMenu.addMenuItem(new MenuItem("4:轻卡4", "贵", 181));
		firstMenu.addMenuItem(new MenuItem("5:轻卡5", "贵", 182));
		firstMenu.addMenuItem(new MenuItem("6:轻卡6", "贵", 183));
		firstMenu.addMenuItem(new MenuItem("7:轻卡7", "贵", 1804));
		firstMenu.addMenuItem(new MenuItem("8:轻卡8", "贵", 1805));
		SecondMenu secondMenu = new SecondMenu();
		secondMenu.addMenuItem(new MenuItem("A:咖啡", "好喝A", 30));
		secondMenu.addMenuItem(new MenuItem("B:咖啡", "好喝B", 31));
		secondMenu.addMenuItem(new MenuItem("C:咖啡", "好喝c", 32));
		secondMenu.addMenuItem(new MenuItem("D:咖啡", "好喝d", 33));
		secondMenu.addMenuItem(new MenuItem("E:咖啡", "好喝e", 34));
		secondMenu.addMenuItem(new MenuItem("F:咖啡", "好喝f", 35));
		secondMenu.addMenuItem(new MenuItem("G:咖啡", "好喝g", 35));
		secondMenu.addMenuItem(new MenuItem("H:咖啡", "好喝h", 36));
		secondMenu.addMenuItem(new MenuItem("K:咖啡", "好喝k", 37));

		ThirdMenum thirdMenum = new ThirdMenum();
		thirdMenum.addMenuItem("1", new MenuItem("HH;肉丝", "好吃", 40));
		thirdMenum.addMenuItem("2", new MenuItem("HH;肉丝1", "好吃", 41));
		thirdMenum.addMenuItem("3", new MenuItem("HH;肉丝2", "好吃", 42));
		thirdMenum.addMenuItem("4", new MenuItem("HH;肉丝3", "好吃", 44));
		thirdMenum.addMenuItem("5", new MenuItem("HH;肉丝4", "好吃", 45));
		thirdMenum.addMenuItem("6", new MenuItem("HH;肉丝5", "好吃", 46));
		thirdMenum.addMenuItem("7", new MenuItem("HH;肉丝6", "好吃", 407));
		thirdMenum.addMenuItem("8", new MenuItem("HH;肉丝7", "好吃", 407));

		List<Menu> menus = new ArrayList<>();
		menus.add(firstMenu);
		menus.add(secondMenu);
		menus.add(thirdMenum);
		Witer witer = new Witer(menus);
		witer.printMenu();
	}
}
