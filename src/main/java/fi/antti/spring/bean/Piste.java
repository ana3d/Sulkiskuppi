package fi.antti.spring.bean;

public class Piste {

	private String name;
	private int pisteet;

	public Piste() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Piste(String name, int pisteet) {
		super();
		this.name = name;
		this.pisteet = pisteet;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPisteet() {
		return pisteet;
	}

	public void setPisteet(int pisteet) {
		this.pisteet = pisteet;
	}

	@Override
	public String toString() {
		return "Piste [name=" + name + ", pisteet=" + pisteet + "]";
	}

}
