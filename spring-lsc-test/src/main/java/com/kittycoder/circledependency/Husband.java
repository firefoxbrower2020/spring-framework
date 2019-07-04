package com.kittycoder.circledependency;

/**
 * Created by shucheng on 2019-7-4 下午 22:27
 */
public class Husband {

	private String name;
	private Wife wife;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Wife getWife() {
		return wife;
	}

	public void setWife(Wife wife) {
		this.wife = wife;
	}

	@Override
	public String toString() {
		return "Husband{" +
				"name='" + name + '\'' +
				", wife=" + wife.getName() +
				'}';
	}
}
