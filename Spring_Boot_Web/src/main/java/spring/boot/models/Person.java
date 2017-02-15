package main.java.spring.boot.models;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class Person {
	
	public static boolean Male = true;
	public static boolean Female = false;

	@NotNull(message="Person's Id can't be null")
	@Min(1)
	@Max(2)
	private int id;
	private String name;
	private int age;
	private String address;
	private Boolean gender;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Boolean getGender() {
		return gender;
	}

	public void setGender(Boolean gender) {
		this.gender = gender;
	}

	public Person(int id, String name, int age, String address, Boolean gender) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.address = address;
		this.gender = gender;
	}

	public Person() {
		super();
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", age=" + age + ", address=" + address + ", gender=" + gender
				+ "]";
	}

}
