package main.java.spring.hikari.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "GameConsole")
public class GameConsole {

	@Id
	private int id;
	private String name;
	private int year;
	private String detail;

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

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public GameConsole() {
		super();
	}

	@Override
	public String toString() {
		return "GameConsole [id=" + id + ", name=" + name + ", year=" + year + ", detail=" + detail + "]";
	}

	public GameConsole(int id, String name, int year, String detail) {
		super();
		this.id = id;
		this.name = name;
		this.year = year;
		this.detail = detail;
	}

}
