package projekt;

public class romany extends knihy {
	
	private String nazev;
	private String autor;
	private int rok;
	private boolean dost;
	private String zanr;
	
	public romany(String nazev, String autor, int rok, boolean dost, String zanr) {
		super(nazev, autor, rok, dost);
		this.setZanr(zanr);
				
	}
	

	public String getZanr() {
		return zanr;
	}

	public void setZanr(String zanr) {
		this.zanr = zanr;
	}

}
