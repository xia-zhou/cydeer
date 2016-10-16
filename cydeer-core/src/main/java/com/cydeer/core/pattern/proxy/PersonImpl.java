package com.cydeer.core.pattern.proxy;

/**
 * @author Cydeer on 16/6/10.
 */
public class PersonImpl implements Person {
	private Integer slary;

	private String name;

	public PersonImpl(Integer slary, String name) {
		this.slary = slary;
		this.name = name;
	}

	@Override public void setSlary(Integer slary) {
		this.slary = slary;
	}

	@Override public Integer getSlary() {
		return slary;
	}

	@Override public void setName(String name) {
		this.name = name;
	}

	@Override public String getName() {
		return name;
	}

	@Override public String toString() {
		return "PersonImpl{" +
				"salary=" + slary +
				", name='" + name + '\'' +
				'}';
	}
}
