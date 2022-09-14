package snake;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JRootPane;

public class oknoGlowne extends JFrame{

	
	public static myPanel panel;
	
	oknoGlowne(){
		this.setTitle("Wąż");
		this.setUndecorated(true);
		this.getRootPane().setWindowDecorationStyle(JRootPane.WARNING_DIALOG);
		panel=new myPanel();
		this.setLocationRelativeTo(null);
		int wysokosc=myPanel.wysokosc;
		int szerokosc=myPanel.szerokosc;
		this.setSize(szerokosc,wysokosc);
		this.add(panel);
		this.addKeyListener(panel);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		panel.setBackground(Color.black);
		this.setResizable(false);
		this.setVisible(true);
	}
	public void setVisiblee(boolean czy) {
		this.setVisible(czy);
	}
	
	
	
	
}
