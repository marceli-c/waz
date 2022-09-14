package snake;

import java.util.TimerTask;

public class Timer1 extends TimerTask{

	@Override
	public void run() {
		
		myPanel.predkoscx++;
		//System.out.println("predkosc prawo x "+myPanel.predkoscx);
		myPanel.setiksy(true);
		oknoGlowne.panel.repaint();
		myPanel.sprawdzajKolizjePrawo();
		myPanel.sprawdzajKolizjeCialo();
	}

}
