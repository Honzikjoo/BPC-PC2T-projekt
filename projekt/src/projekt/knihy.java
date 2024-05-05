package projekt;

public abstract class knihy {
	
private String nazev;
private String autor;
private int rok;
private boolean dost;

	public knihy(String nazev, String autor, int rok, boolean dost)
	{
		this.setNazev(nazev);
		this.setAutor(autor);
		this.setRok(rok);
		this.setDost(dost);
	}

	public String getNazev() {
		return nazev;
	}

	public void setNazev(String nazev) {
		this.nazev = nazev;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public int getRok() {
		return rok;
	}

	public void setRok(int rok) {
		this.rok = rok;
	}
	
	public boolean getDost() {
		return dost;
	}

	public String getDost2() {
		if(dost==true)
		return "dostupna";
		else
		return "nedostupna";
	}

	public void setDost(boolean dost) {
		this.dost = dost;
	}



}
