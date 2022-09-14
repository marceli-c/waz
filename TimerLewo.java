package snake;

import java.util.TimerTask;

public class TimerLewo extends TimerTask{

	@Override
	public void run() {
		
		myPanel.predkoscx++;
		//System.out.println("predkosc lewo x "+myPanel.predkoscx);
		myPanel.setiksy(false);
		oknoGlowne.panel.repaint();
		myPanel.sprawdzajKolizjeLewo();
		myPanel.sprawdzajKolizjeCialo();
	}

}
