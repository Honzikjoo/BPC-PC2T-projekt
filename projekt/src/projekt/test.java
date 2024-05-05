package projekt;
import java.util.Scanner;


public class test {
	
	public static int pouzeCelaCisla(Scanner sc) 
	{
		int cislo = 0;
		try
		{
			cislo = sc.nextInt();
		}
		catch(Exception e)
		{
			System.out.println("Nastala vyjimka typu "+e.toString());
			System.out.println("zadejte prosim cele cislo ");
			sc.nextLine();
			cislo = pouzeCelaCisla(sc);
		}
		return cislo;
	}
	
	public static float pouzeCisla(Scanner sc) 
	{
		float cislo = 0;
		try
		{
			cislo = sc.nextFloat();
		}
		catch(Exception e)
		{
			System.out.println("Nastala vyjimka typu "+e.toString());
			System.out.println("zadejte prosim cislo ");
			sc.nextLine();
			cislo = pouzeCisla(sc);
		}
		return cislo;
	}
	
	public static boolean pouzeBoolean(Scanner sc) 
	{
		boolean cislo;
		try
		{
			cislo = sc.nextBoolean();
		}
		catch(Exception e)
		{
			System.out.println("Nastala vyjimka typu "+e.toString());
			System.out.println("zadejte prosim Boolean ");
			sc.nextLine();
			cislo = pouzeBoolean(sc);
		}
		return cislo;
	}
	
	
	
	

	public static void main(String[] args){	
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int volba;
		boolean run=true;
		
		databaze knihovna=new databaze();

		while(run)
		{
			System.out.println("Vyberte z moznosti:");
			System.out.println("1 -- vytvoreni nove knihy");
			System.out.println("2 -- upraveni knihy");
			System.out.println("3 -- smazání knihy");
			System.out.println("4 -- nastavení dostupnosti knihy");
			System.out.println("5 -- výpis knih");
			System.out.println("6 -- vyhledání knih podle názvu");
			System.out.println("7 -- výpis knih podle autora");
			System.out.println("8 -- vypis podle zanru");
			System.out.println("9 -- vypis vypujcenych knih");
			System.out.println("10 -- ulozeni do souboru");
			System.out.println("11 -- nacteni ze souboru");
			System.out.println("12 -- ukonceni programu");
			
			volba=pouzeCelaCisla(sc);
			switch(volba)
			{
				case 1:
					knihovna.setKnihy();
					break;
				case 2:
						System.out.println("Zadejte nazev knihy");
						knihovna.uprava(sc.next());

					break;
				case 3:
					System.out.println("Zadejte nazev knihy");
					knihovna.smazani(sc.next());
					break;
				case 4:
					System.out.println("Zadejte nazev knihy");
					knihovna.vypujceni(sc.next());
					break;
				case 5:
					knihovna.vypis();
					break;
				case 6:
					System.out.println("Zadejte nazev knihy");
					knihovna.vyhledani(sc.next());
					break;
				case 7:
					System.out.println("Zadejte jmeno autora");
					knihovna.vyhledaniautora(sc.next());
					break;
				case 8:
					System.out.println("Zadejte zanr knihy (action/fantasy/sci-fi/romance/drama)");
					String zanr=sc.next();
					int pom=0;
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
					knihovna.vyhledanizanru(zanr);
					break;
				case 9:
					knihovna.vypisucrom();
					break;
				case 10:
					System.out.println("Zadejte jmeno souboru(knihy)");
					if (knihovna.ulozdatabazi(sc.next()))
						System.out.println("Kniha ulozena do souboru");
					else
						System.out.println("Knihu nebylo mozno ulozit do souboru");
					break;
				case 11:
					System.out.println("Zadejte jmeno souboru(knihy)");
					if (knihovna.nactidatabazi(sc.next()))
						System.out.println("Kniha nactena ze souboru");
					else
						System.out.println("Knihu nebylo mozno nacist ze souboru");
					break;
				case 12:
				//	knihovna.sqldelete();
				//	knihovna.sqlinsert();
					run=false;
					break;
			}
			
		}
	}

}

