package snake;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class zapisPunktow {

		
		static String punkty;
		static LocalDateTime czas;
		static int godzina;
		static int minuta;
		static int sekunda;
		static int dzienMiesiaca;
		static int miesiac;
		static int rok;
		
		zapisPunktow(){
			punkty=String.valueOf(myPanel.getPunkty());
			czas=LocalDateTime.now();
			godzina=czas.getHour();
			minuta=czas.getMinute();
			sekunda=czas.getSecond();
			dzienMiesiaca=czas.getDayOfMonth();
			miesiac=czas.getMonthValue();
			rok=czas.getYear();
			zapisz();
		}
		
		public void zapisz() {
			try {
				Files.writeString(Paths.get("points.txt"),punkty+" "
				+rok+" "+miesiac+" "+dzienMiesiaca+" "+godzina+" "
				+minuta+" "+sekunda+"\n",StandardOpenOption.APPEND);
			} catch (NoSuchFileException e) {
				utworzPlik();
				}
			
			catch(IOException e) {
				e.printStackTrace();
			}
			
		}
		public static void utworzPlik() {
			try {
				Files.writeString(Paths.get("points.txt"),punkty+" "
						+rok+" "+miesiac+" "+dzienMiesiaca+" "+godzina+" "
						+minuta+" "+sekunda+"\n");
			} catch (IOException e1) {
				
				e1.printStackTrace();
			}
		}
}
