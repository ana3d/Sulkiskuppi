package fi.antti.spring.bean;

import javax.validation.constraints.Size;

public class Pelaaja {
	
	private int id;
	
	@Size(min = 1, max = 255)
	private String name;
	public Pelaaja(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public Pelaaja() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
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
	@Override
	public String toString() {
		return "Pelaaja [id=" + id + ", name=" + name + "]";
	}
	
	

}
