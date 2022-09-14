package snake;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRootPane;

public class oknoKoncowe extends JFrame implements ActionListener{
	
	JButton przycisk=stworzPrzycisk("Wyniki");
	JButton przyciskreset=stworzPrzycisk("Restart");
	static int top=4;
	JLabel label;
	
	oknoKoncowe(){
		this.setTitle("Przegrana");
		new zapisPunktow();
		label=stworzLabel();
		this.setLayout(new FlowLayout());
		int punkty=myPanel.punkty;
		this.getContentPane().setBackground(Color.black);
		JLabel label=new JLabel("<html>Przegrałeś<br> Twój wynik to: "+punkty+" punkty<br></html>");
		this.setUndecorated(true);
		this.getRootPane().setWindowDecorationStyle(JRootPane.WARNING_DIALOG);
		label.setForeground(Color.white);
		this.setResizable(false);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(oknoGlowne.panel);
		this.add(label);
		this.add(this.label);
		this.add(przycisk);
		this.add(przyciskreset);
		
		this.setSize(200,250);
		
		this.setVisible(true);
		
		
		
	}
	
	public JButton stworzPrzycisk(String tekst) {
		JButton przycisk=new JButton(tekst);
		przycisk.setBackground(Color.gray);
		przycisk.setForeground(Color.white);
		przycisk.setPreferredSize(new Dimension(80,20));
		przycisk.addActionListener(this);
		przycisk.setFocusable(false);
		//this.setTitle(tekst);
		return przycisk;
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==przycisk) {
			new tabelaPunktow();
		}
		if(e.getSource()==przyciskreset) {
			this.dispose();
			Main.okno.dispose();
			
			Main.okno=new oknoGlowne();
			Main.okno.validate();
			Main.okno.setLocationRelativeTo(this);
		}
	}
	public JLabel stworzLabel() {
		new odczytPunktow();
		String top5="halo";
		JLabel label =new JLabel();
		
		
			
				top5=setTopString();
				label.setText(top5);
				label.setForeground(Color.white);
				return label;
			
			
		
		
		
	}
	public String setTopString(){
		String top5="<html> <br>TOP 5 WYNIKÓW<br>"+odczytPunktow.wypiszTop(top)+"<br></html>";
		return top5;
	}

}
