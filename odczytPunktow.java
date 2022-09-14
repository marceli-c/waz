package snake;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class odczytPunktow {

	List<String> list;
	static List<String> listaReszta;
	static List<Integer> listaPunktyKopia;
	static List<Integer> listaPunkty;
	static List<String> finalna;
	static List<String> punkty;
	static String result;
	static String nazwa="points.txt";
	static String rezultatnonSort;
	static String rezultatDatGodzinySort;
	static List<String> finalnaDatyGodziny;
	
	odczytPunktow(){
	rezultatnonSort="";
	finalnaDatyGodziny=new ArrayList<String>();
	list=new ArrayList<String>();
	listaReszta=new ArrayList<String>();
	listaPunktyKopia=new ArrayList<Integer>();
	listaPunkty=new ArrayList<Integer>();
	finalna=new ArrayList<String>();
	punkty=new ArrayList<String>();
	result="";
	przypiszListe();
	listaPunkty=listaPunktowInt(punkty);
	//Collections.sort(punkty);
	//Collections.reverse(punkty);
	System.out.println(punkty);
	listaPunktowInt(punkty);	
	datyOdczyt(punkty);
	posortujPunkty();
	przypiszPunktyDoDni();
	rezultatDatGodzinySort=wypisz(finalnaDatyGodziny);
	result=wypisz(finalna);
	System.out.println(result);
	
	}
	private  static List<String> listaPunktow(String nazwa){
		List <String> lista=new ArrayList<String>();
		try (Stream<String> linia=Files.lines(Paths.get(nazwa))){
			
			
			lista=linia.collect(Collectors.toList());
			
		}
		catch(IOException e) {
			zapisPunktow.utworzPlik();
			przypiszListe();
			
		}
		return lista;
		
	}
	
	
	private static void przypiszListe() {
		punkty=listaPunktow(nazwa);
	}
	
	
	private String wypisz(List<String> lista) {
		String rezultat="";
		for(String result:lista) {
			rezultat+=result+"<br>";
		}
		return rezultat;
	}
	
	
	public static String wypiszTop(int top){
		String rezultat="";
		int i=0;

		
			while(i<=top) {
				
					try {
						
						rezultat+=finalna.get(i)+"<br>";
						i++;
					}
					catch(IndexOutOfBoundsException e) {
						top--;
						
					
				}
				
				
			}
		
		
		return rezultat;
		
	}
	private List<Integer> listaPunktowInt(List<String> list) {
	    Pattern pattern = Pattern.compile("^\\d+");
	    List<Integer> lista=new ArrayList<>();
	    for (String liniaString : list) {
	        Matcher matcher = pattern.matcher(liniaString);
	        if(matcher.find()) {
	            lista.add(Integer.parseInt(matcher.group()));
	        }
	    }
	    listaPunktyKopia=lista;
	    System.out.println(lista);
	    return lista;
	}
	private void datyOdczyt(List<String> lista){		
		Pattern patternReszta=Pattern.compile("(\\s\\d+){6}");		
	    for (String liniaString : lista) {	        
	        Matcher matcherReszta= patternReszta.matcher(liniaString);
	        if(matcherReszta.find()) {
	        	listaReszta.add(matcherReszta.group().replaceFirst("\\s", "")
	        	.replaceFirst("\\s", "/").replaceFirst("\\s", "/").replaceFirst("\\s", "d")
	        	.replaceFirst("\\s", ":").replaceFirst("\\s", ":").replaceFirst("d"," Godzina:"));
	        }
	        
	    }
	    
	  
	    
	}
	private void posortujPunkty() {
		
		Collections.sort(listaPunkty);
		Collections.reverse(listaPunkty);
		
	}
	private void przypiszPunktyDoDni() {
		int i=0;
		int y=0;
		System.out.println(listaPunkty);
	    System.out.println(listaPunktyKopia);
		for (int punkt:listaPunkty) {
			for(int punktkopia:listaPunktyKopia) {
				
				if(punkt==punktkopia) {
					finalna.add(dopiszDaty(y,i,true));
					finalnaDatyGodziny.add(dopiszDaty(y,i,false));
					break;
				}
				else {
					i++;
					
				}
				
			}
			
			i=0;
			y++;
		}
	}
	public static String dopiszDaty(int x, int y,boolean czyTylkoDaty) {
		String rezultat="";
		if(czyTylkoDaty==false) {
			rezultat=String.valueOf("Punkty: "+listaPunkty.get(x))+" Data:"+listaReszta.get(y);
		}
		if(czyTylkoDaty==true) {
			rezultat=String.valueOf("Punkty: "+listaPunkty.get(x))+" Data:"+
					listaReszta.get(y).replaceAll("Godzina:\\d+:\\d+:\\d+", "");
		}
		
		
		return rezultat;
	}
	
	
	public static String getRezultatPosortowany() {
		return result;
	}
	public static String getRezultatDatyGodzinyPosortowany() {
		return rezultatDatGodzinySort;
	}
	public static String getRezultatnonSort() {
		String rezultat="";
		int i=0;
		Collections.reverse(listaPunktyKopia);
		Collections.reverse(listaReszta);
		for(String linia:listaReszta) {
			rezultat+="Punkty: "+String.valueOf(listaPunktyKopia.get(i))+" Data:"+linia+"<br>";
			i++;
		}
		return rezultat;
	}
}
