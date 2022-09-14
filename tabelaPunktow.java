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
import javax.swing.JScrollPane;

public class tabelaPunktow extends JFrame implements ActionListener{

	JButton sortwyniki=stworzPrzycisk("<html>Sortuj po <br>wyniku</html>",7,380);
	JButton sortdaty=stworzPrzycisk("<html>Sortuj po <br>dacie</html>",107,380);
	JButton restart=stworzPrzycisk("Restart",207,380);
	JLabel label;
	static String tekst;
	tabelaPunktow(){
		this.setTitle("Tabela Punktow");
		tekst=odczytPunktow.getRezultatDatyGodzinyPosortowany();
		this.setLayout(null);
		this.getContentPane().setBackground(Color.black);
		label=stworzLabel(tekst);
		this.add(sortwyniki);
		this.add(sortdaty);
		this.add(restart);
		JScrollPane scroll=stworzScroll(label);
		this.add(scroll);
		Main.zmien(false);
		myPanel.oknkoKoniec.setVisible(false);
		this.setSize(320,470);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(Main.okno);
		this.setBackground(Color.black);
		this.setResizable(false);
		this.setUndecorated(true);
		this.getRootPane().setWindowDecorationStyle(JRootPane.WARNING_DIALOG);
		this.setVisible(true);
		
		
	}
	public JScrollPane stworzScroll(JLabel label) {
		JScrollPane scroll = new JScrollPane(label,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll.setBounds(10,10,285,360);
		
		return scroll;
	}
	public JLabel stworzLabel(String tekst) {
		JLabel label=new JLabel();
		String elo="";		
		elo="<html>"+tekst+"</html>";
		label.setText(elo);
		label.setBackground(Color.black);
		label.setForeground(Color.green);
		label.setBounds(70, 30, 290, 390);
		label.setOpaque(true);
		return label;
	}
	private JButton stworzPrzycisk(String tekst,int x,int y) {
		JButton przycisk=new JButton();
		przycisk.setBounds(x,y,90,30);
		przycisk.addActionListener(this);
		//przycisk.setPreferredSize(new Dimension(80,40));
		przycisk.setBackground(Color.gray);
		przycisk.setForeground(Color.white);
		przycisk.setFocusable(false);
		przycisk.setText(tekst);
		
		return przycisk;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==sortwyniki) {
			this.tekst=Sort(false);
			repaint();
		}
		if(e.getSource()==sortdaty) {
			System.out.println("chuj");
			this.tekst=Sort(true);
			repaint();
		}
		if(e.getSource()==restart) {
			this.dispose();
			Main.okno.dispose();
			
			Main.okno=new oknoGlowne();
			Main.okno.validate();
			Main.okno.setLocationRelativeTo(this);
		}
	}
	public String Sort(boolean czy) {
		String rezultat="";
		if(czy==false) {
			label.setText("<html>"+odczytPunktow.getRezultatDatyGodzinyPosortowany()+"</html>");
			
		}
		if(czy ==true) {
			label.setText("<html>"+odczytPunktow.getRezultatnonSort()+"</html>");
			
		}
		return rezultat;
	}
}
