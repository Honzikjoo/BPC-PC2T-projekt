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
	
	
	
	

	public static void main(String[] args) {	
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
			System.out.println("8 -- vypis vypujcenych knih");
			System.out.println("9 -- ulozeni do souboru");
			System.out.println("10 -- nacteni ze souboru");
			System.out.println("11 -- ukonceni programu");
			
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
					
					break;
				case 8:
					
					break;
				case 9:
	//				System.out.println("Zadejte jmeno souboru");
	//				if (mojeDatabaze.ulozDatabazi(sc.next()))
	//					System.out.println("Databaze ulozena");
	//				else
	//					System.out.println("Databazi nebylo mozno ulozit");
					break;
				case 10:
	//				System.out.println("Zadejte jmeno souboru");
	//				if (mojeDatabaze.nactiDatabazi(sc.next()))
	//					System.out.println("Databaze nactena");
	//				else
	//					System.out.println("Databazi nebylo mozno nacist");
					break;
				case 11:
					run=false;
					break;
			}
			
		}
	}

}

