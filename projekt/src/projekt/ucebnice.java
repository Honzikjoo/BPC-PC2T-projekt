package projekt;

public class ucebnice extends knihy {
	
	private String nazev;
	private String autor;
	private int rok;
	private boolean dost;
	private int rocnik;
	
	public ucebnice(String nazev, String autor, int rok, boolean dost, int rocnik) {
		super(nazev, autor, rok, dost);
		this.setRocnik(rocnik);
		
	}
	

	public int getRocnik() {
		return rocnik;
	}

	public void setRocnik(int rocnik) {
		this.rocnik = rocnik;
	}

}
