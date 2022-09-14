package snake;

import java.util.TimerTask;

public class TimerDol extends TimerTask{

	@Override
	public void run() {
		
		myPanel.predkoscy++;
		//System.out.println("predkosc dol y "+myPanel.predkoscy);
		myPanel.setigreki(true);
		oknoGlowne.panel.repaint();
		myPanel.sprawdzajKolizjeDol();
		myPanel.sprawdzajKolizjeCialo();
		
	}

}
