package projekt;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;




public class databaze {
	
	private Scanner sc;
	private knihy [] kniha;
	private int pos=0;
	private knihy [] odpad;
	private int poc=0;
	
	public databaze()
	{
		kniha = new knihy[1000];
		odpad = new knihy[1000];
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
					odpad[poc]=kniha[i];
					poc++;
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
		
		
		for (int a = 0; a < pos; a++) {
	        for (int b = 1; b < pos; b++) {
	            if (((kniha[b].getNazev()).compareTo((kniha[b - 1].getNazev()))) < 0) {
	                knihy temp = kniha[b-1];
	                kniha[b-1] = kniha[b];
	                kniha[b] = temp;
	            }
	        }
	    }
		
		for (int i=0;i<pos;i++){
			if (kniha[i]!=null)
			{
				System.out.println("Nazev: " + kniha[i].getNazev() + "\nautor: " + kniha[i].getAutor() + "\nrok vydani: " + kniha[i].getRok()+"\ndostupnost: " + kniha[i].getDost2());
				if(kniha[i] instanceof romany)
				{
					System.out.println("Zanr: " + ((romany)kniha[i]).getZanr()+"\n");
				}
				else
				{
					System.out.println("Rocnik: " + ((ucebnice)kniha[i]).getRocnik()+"\n");
				}
			}
			else
				System.out.println(i+"Kniha neexistuje");
		}
		
		
	}
	
	public void vyhledani(String nazev) {
		for(int i=0;i<pos;i++)
		{
			if(kniha[i].getNazev().equals(nazev))
			{
				System.out.println("Nazev: " + kniha[i].getNazev() + "\nautor: " + kniha[i].getAutor() + "\nrok vydani: " + kniha[i].getRok()+"\ndostupnost: " + kniha[i].getDost2());
				if(kniha[i] instanceof romany)
				{
					System.out.println("Zanr: " + ((romany)kniha[i]).getZanr()+"\n");
				}
				else
				{
					System.out.println("Rocnik: " + ((ucebnice)kniha[i]).getRocnik()+"\n");
				}
				
			}
		}
		
		
	}
	
	public void vyhledaniautora(String autor) {
		int j=0;
		knihy [] knihaa;
		knihaa = new knihy[pos+1];
		
		for (int a = 0; a < pos; a++) {
	        for (int b = 1; b < pos; b++) {
	            if (kniha[b].getRok()<kniha[b - 1].getRok()) {
	                knihy temp = kniha[b-1];
	                kniha[b-1] = kniha[b];
	                kniha[b] = temp;
	            }
	        }
	    }
		
		for(int i=0;i<pos;i++)
		{
			if(kniha[i].getAutor().equals(autor))
			{
					
				if(kniha[i] instanceof romany)
				{
					knihaa[j]=new romany(kniha[i].getNazev(),autor,kniha[i].getRok(),kniha[i].getDost(),((romany)kniha[i]).getZanr());
					
				}
				else
				{
					knihaa[j]=new ucebnice(kniha[i].getNazev(),autor,kniha[i].getRok(),kniha[i].getDost(),((ucebnice)kniha[i]).getRocnik());
				}
				j++;
			}
		}
		
		for(int i=0;i<j;i++)
		{
			
				System.out.println("Nazev: " + kniha[i].getNazev() + "\nautor: " + kniha[i].getAutor() + "\nrok vydani: " + kniha[i].getRok()+"\ndostupnost: " + kniha[i].getDost2());
				if(kniha[i] instanceof romany)
				{
					System.out.println("Zanr: " + ((romany)kniha[i]).getZanr()+"\n");
				}
				else
				{
					System.out.println("Rocnik: " + ((ucebnice)kniha[i]).getRocnik()+"\n");	
				}
			}
		}
	
	
	public void vyhledanizanru(String zanr) {
		for(int i=0;i<pos;i++)
		{
			if(((romany)kniha[i]).getZanr().equals(zanr))
			{
				System.out.println("Nazev: " + kniha[i].getNazev() + "\nautor: " + kniha[i].getAutor() + "\nrok vydani: " + kniha[i].getRok()+"\ndostupnost: " + kniha[i].getDost2());
					System.out.println("Zanr: " + ((romany)kniha[i]).getZanr()+"\n");
				
			}
		}
		
		
	}
	
	
	public void vypisucrom()
	{
		for (int i=0;i<pos;i++){
			if (kniha[i]!=null && kniha[i].getDost()==false)
			{
				System.out.println("Nazev: " + kniha[i].getNazev());
				if(kniha[i] instanceof romany)
				{
					System.out.println("Zanr: " + ((romany)kniha[i]).getZanr()+"\n");
				}
				else
				{
					System.out.println("Rocnik: " + ((ucebnice)kniha[i]).getRocnik()+"\n");
				}
			}
		}
	}
	
	public boolean ulozdatabazi(String jmenoSouboru)
	{
		try {
			FileWriter fw = new FileWriter(jmenoSouboru);
			BufferedWriter out = new BufferedWriter(fw);
			for (int i=0;i<pos;i++){
				if (kniha[i]!=null && kniha[i].getNazev().equals(jmenoSouboru))
				{
					
					out.write(kniha[i].getNazev() + " " + kniha[i].getAutor() + " " + kniha[i].getRok()+" " + kniha[i].getDost());
					if(kniha[i] instanceof romany)
					{
						out.write(" " + ((romany)kniha[i]).getZanr());
						break;
					}
					else
					{
						out.write(" " + ((ucebnice)kniha[i]).getRocnik());
						break;
					}
				}
			}
			out.close();
			fw.close();
		}
		catch (IOException e) {
			System.out.println("Soubor nelze vytvorit");
			return false;
		}
		return true;
	}
	
	public boolean nactidatabazi(String jmenoSouboru) {
		FileReader fr=null;
		BufferedReader in=null;
		try {
			fr = new FileReader(jmenoSouboru);
			in = new BufferedReader(fr);
			String radek=in.readLine();
			String oddelovac = "[ ]+";
			String[] castiTextu = radek.split(oddelovac);
			String nazev=castiTextu[0];
			String autor=castiTextu[1];
			int rok= Integer.parseInt(castiTextu[2]);
			boolean dost=Boolean.parseBoolean(castiTextu[3]);
			
				if (castiTextu[4].equals("1") || castiTextu[4].equals("2") || castiTextu[4].equals("3") || castiTextu[4].equals("4") || castiTextu[4].equals("5"))
				{
					int rocnik= Integer.parseInt(castiTextu[4]);
					kniha[pos]=new ucebnice(nazev,autor,rok,dost,rocnik);
					pos++;
					
				}
				
				else
				{
					String zanr=castiTextu[4];
					kniha[pos]=new romany(nazev,autor,rok,dost,zanr);
					pos++;
				}
		}
		catch (IOException e) {
			System.out.println("Soubor  nelze otevrit");
			return false;
		} 
		catch (NumberFormatException e) {
			System.out.println("Chyba integrity dat v souboru");
			return false;
		}
		finally
		{
			try
			{	if (in!=null)
				{
					in.close();
					fr.close();
				}
			}
			catch (IOException e) {
				System.out.println("Soubor nelze zavrit");
				return false;
			} 
		}
		
		return true;
	}
	
	
/*	public void sqldelete() {
		
		for(int i=0;i<poc;i++) {
	    Connection conn = sqlconn.getConn();

	    String delete = "DELETE FROM user WHERE user.nazev = ?";

	    try (PreparedStatement prStmt = conn.prepareStatement(delete);) {
	      prStmt.setString(1, odpad[i].getNazev());
	      prStmt.executeUpdate();
	      System.out.println("Vymazano");
	    } catch (SQLException e) {
	      e.printStackTrace();
	    }
		}
	  }
	
	
	 public void sqlinsert() {

		 
		 
		 for(int i=0;i<pos;i++) {
				String nazev=kniha[i].getNazev();
				String autor=kniha[i].getAutor();
				int rok= kniha[i].getRok();
				boolean dost=kniha[i].getDost();
				if(kniha[i] instanceof romany)
				{
					String zanr=((romany)kniha[i]).getZanr();
					  Connection conn = sqlconn.getConn();
					    String insertUser = "INSERT INTO user " + "(nazev,autor,rok,dost,zanr)" + "VALUES(?,?,?,?,?)";
					    
					    try (PreparedStatement prStmt = conn.prepareStatement(insertUser)) {
						      prStmt.setString(1, nazev);
						      prStmt.setString(2, autor);
						      prStmt.setInt(3, rok);
						      prStmt.setBoolean(4, dost);
						      prStmt.setString(5, zanr);

						      prStmt.executeUpdate();

						      System.out.println("Vlozeno!");
						    } catch (SQLException e) {
						      System.out.println("Uz tam je!");
						    }

				}
				else
				{
					int rocnik=((ucebnice)kniha[i]).getRocnik();
					  Connection conn = sqlconn.getConn();
					    String insertUser = "INSERT INTO user " + "(nazev,autor,rok,dost,rocnik)" + "VALUES(?,?,?,?,?)";
					    
					    try (PreparedStatement prStmt = conn.prepareStatement(insertUser)) {
						      prStmt.setString(1, nazev);
						      prStmt.setString(2, autor);
						      prStmt.setInt(3, rok);
						      prStmt.setBoolean(4, dost);
						      prStmt.setInt(5, rocnik);

						      prStmt.executeUpdate();

						      System.out.println("Vlozeno!");
					    } catch (SQLException e) {
					      System.out.println("Uz tam je!");
					    }

				}
			 
			 
		  }
	 }*/
		
	
}

