package com.pocassgn.Person;

public class Person {
	private String name;
	private int age;
	private int phone;
	private String location;
	
	public Person()
	{
		
	}
	
	public Person(String name, int age, int phone, String location) {
		super();
		this.name = name;
		this.age = age;
		this.phone = phone;
		this.location = location;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "Person [name" + name + ", age" + age + ", phone" + phone + ", location" + location + "]";
	}
	

}
