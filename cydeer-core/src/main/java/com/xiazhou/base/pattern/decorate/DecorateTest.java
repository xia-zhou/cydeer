package com.xiazhou.base.pattern.decorate;

/**
 * Created by zhangsong on 16/5/31.
 */
public class DecorateTest {
	public static void main(String[] args) {
		BaseFood baseFood = new Noodle();
		System.out.println(baseFood.getDescription() + ";" + baseFood.cost());
		System.out.println(baseFood.getDescription() + ";" + baseFood.cost());
		baseFood = new HotWei(baseFood);
		System.out.println(baseFood.getDescription() + ";" + baseFood.cost());
		baseFood = new CuminWei(baseFood);
		System.out.println(baseFood.getDescription() + ";" + baseFood.cost());
		baseFood = new CuminWei(baseFood);
		System.out.println(baseFood.getDescription() + ";" + baseFood.cost());
	}
}
