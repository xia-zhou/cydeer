package com.cydeer.core.pattern.strategy;

/**
 * @author Cydeer on 16/5/22.
 */
public class ZhiZhiQuack implements QuackBehavior {
	@Override public void quack() {
		System.out.println("吱吱叫");
	}
}
