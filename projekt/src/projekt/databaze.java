package projekt;

import java.util.Scanner;

public class databaze {
	
	private Scanner sc;
	private knihy [] kniha;
	private int pos=0;
	
	public databaze()
	{
		kniha = new knihy[1000];
		sc=new Scanner(System.in);
	}
	
	
	public void setKnihy()
	{
		System.out.println("Zadejte nazev knihy");
		String nazev=sc.next();
		System.out.println("Zadejte autora knihy");
		String autor=sc.next();
		System.out.println("Zadejte rok vydani knihy");
		int rok= test.pouzeCelaCisla(sc);
		System.out.println("Zadejte dostupnost knihy(true/false)");
		boolean dost=test.pouzeBoolean(sc);
		
		
		System.out.println("Zadejte druh knihy(1 - roman, 2 - ucebnice)");
		int pom= test.pouzeCelaCisla(sc);
		
		while(pom!=1 && pom!=2)
		{
		System.out.println("Zadejte druh knihy(1 - roman, 2 - ucebnice)");
		pom= test.pouzeCelaCisla(sc);
		}
		if(pom==2)
		{
		System.out.println("Zadejte rocnik knihy (1/2/3/4/5)");
		int rocnik=test.pouzeCelaCisla(sc);
		while(rocnik != 1 && rocnik != 2 && rocnik != 3 && rocnik != 4 && rocnik != 5 )
		{
		System.out.println("Zadejte rocnik knihy (1/2/3/4/5)");
		rocnik=test.pouzeCelaCisla(sc);
		}
		
		kniha[pos]=new ucebnice(nazev,autor,rok,dost,rocnik);
		pos++;
		}
		else
		{
		System.out.println("Zadejte zanr knihy (action/fantasy/sci-fi/romance/drama)");
		String zanr=sc.next();
		pom=0;
		if(zanr.equals("action"))
			pom=1;
		if(zanr.equals("fantasy"))
			pom=1;
		if(zanr.equals("sci-fi"))
			pom=1;
		if(zanr.equals("romance"))
			pom=1;
		if(zanr.equals("drama"))
			pom=1;
		while(pom==0)
		{
			System.out.println("Zadejte zanr knihy (action/fantasy/sci-fi/romance/drama)");
			zanr=sc.next();
			
			if(zanr.equals("action"))
				pom=1;
			if(zanr.equals("fantasy"))
				pom=1;
			if(zanr.equals("sci-fi"))
				pom=1;
			if(zanr.equals("romance"))
				pom=1;
			if(zanr.equals("drama"))
				pom=1;
		}
					
		kniha[pos]=new romany(nazev,autor,rok,dost,zanr);
		pos++;
		}
		
		
	}
	
	public void uprava(String nazev) {
		for(int i=0;i<pos;i++)
		{
			if(kniha[i].getNazev().equals(nazev))
			{
				System.out.println("Nazev: " + kniha[i].getNazev() + "\nautor: " + kniha[i].getAutor() + "\nrok vydani: " + kniha[i].getRok()+"\ndostupnost: " + kniha[i].getDost());
				System.out.println("Zadejte noveho autora knihy");
				kniha[i].setAutor(sc.next());
				System.out.println("Zadejte novy rok vydani knihy");
				kniha[i].setRok(test.pouzeCelaCisla(sc));
				System.out.println("Zadejte novou dostupnost knihy");
				kniha[i].setDost(sc.nextBoolean());
			}
		}
		
		
	}
	
	public void smazani(String nazev) {
		int pom=0;
		for(int i=0;i<pos;i++)
		{
			if(pom==1)
				kniha[i-1]=kniha[i];
			
			if(pom==0)
				if(kniha[i].getNazev().equals(nazev))
				{
					kniha[i]=null;
					System.out.println("Kniha byla uspesne smazana");
					pom=1;
				}

		}
		pos--;
	
	}
	
	public void vypujceni(String nazev) {
		for(int i=0;i<pos;i++)
		{
			if(kniha[i].getNazev().equals(nazev))
			{
				int pom=0;
				while(pom!=1 && pom!=2)
				{
					System.out.println("Zadejte vypujceni(1)/vraceni(2) knihy");
					pom=test.pouzeCelaCisla(sc);
				}
				if(pom==1)
					kniha[i].setDost(false);
				else
					kniha[i].setDost(true);
			}
		}
	
	
	}
	
	public void vypis()
	{
		for (int i=0;i<pos;i++){
			if (kniha[i]!=null)
			{
				System.out.println("Nazev: " + kniha[i].getNazev() + "\nautor: " + kniha[i].getAutor() + "\nrok vydani: " + kniha[i].getRok()+"\ndostupnost: " + kniha[i].getDost());
			//	if(kniha[i]==romany)
			}
			else
				System.out.println(i+". "+"null");
		}
	}
	
	public void vyhledani(String nazev) {
		for(int i=0;i<pos;i++)
		{
			if(kniha[i].getNazev().equals(nazev))
			{
				System.out.println("Nazev: " + kniha[i].getNazev() + "\nautor: " + kniha[i].getAutor() + "\nrok vydani: " + kniha[i].getRok()+"\ndostupnost: " + kniha[i].getDost());
				
			}
		}
		
		
	}

}
