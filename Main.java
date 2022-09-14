package snake;

public class Main {

	static oknoGlowne okno;
	public static void main(String[] args) {
		 okno=new oknoGlowne();
		//new odczytPunktow();
	}
	public static void zmien(boolean czy) {
		okno.setVisible(czy);
	}
}
