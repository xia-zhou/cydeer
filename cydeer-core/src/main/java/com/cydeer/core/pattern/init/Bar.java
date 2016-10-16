package com.cydeer.core.pattern.init;

/**
 * @author Cydeer on 16/6/12.
 */
public class Bar extends Foot {
	int i = getValue();

	private int getValue() {
		i = 9;
		return 9;
	}

	public static void main(String[] args) {
		Foot foot = new Bar();
		System.out.println(foot.i);
		Bar bar = new Bar();
		System.out.println(bar.i);
	}
}
