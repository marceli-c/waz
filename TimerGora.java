package snake;

import java.util.TimerTask;

public class TimerGora extends TimerTask{

	@Override
	public void run() {
		
		myPanel.predkoscy++;
		//System.out.println("predkosc gora y "+myPanel.predkoscy);
		myPanel.setigreki(false);
		oknoGlowne.panel.repaint();
		myPanel.sprawdzajKolizjeGora();
		myPanel.sprawdzajKolizjeCialo();
		
	}

}
