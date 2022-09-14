package snake;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Random;
import java.util.*;
//import java.util.TimerTask;

//import javax.management.timer.Timer;
import javax.swing.JPanel;
//import javax.swing.Timer;
//import javax.swing.Timer;



public  class myPanel extends JPanel implements KeyListener,ActionListener{
	
	Rectangle punkt;
	
	static boolean czyKoniec=false;
	static oknoKoncowe oknkoKoniec;
	static int elementy;
	Rectangle player;
	static final int maks=10000;
	int xstart=0;
	int ystart=0;
	int xpunkt;
	int ypunkt;
	static int direction;
	
	
	static int punkty;
	static int iksy[]=new int[maks];
	static int igreki[]=new int[maks];
	static int wysokosc=700;
	static int szerokosc=700;
	
	ArrayList <Rectangle> playerdod;
	int pole;
	
	myPanel(){
		punkty=0;
		playerdod=new ArrayList<Rectangle>();
		direction=5;
		pole=3;
		elementy=50;
		losuj();
		this.setSize(szerokosc,wysokosc);
		xstart=this.getWidth()/2;
		ystart=this.getHeight()/2;
		this.setVisible(true);
		this.addKeyListener(this);
		iksy[0]=szerokosc/2;
		igreki[0]=wysokosc/2;
		petlaPoczatkowa();
	}
	
	
	
	
	
	
	public void paint(Graphics g) {
		Graphics2D g2d=(Graphics2D) g;
		super.paint(g2d);
		
		ciauo(iksy[0],igreki[0]);
		rysuj(g2d);
		rysujpunkt(g2d,xpunkt,ypunkt);
		
		sprawdzaj();
		
	}
	
	
	
	
	public void rysuj(Graphics2D g) {
		Color kolor=Color.white;
		for(int i=elementy;i>=0;i--) {
			kwadrat(g,iksy[i], igreki[i],kolor);
		}
	}
	
	
	
	public void ciauo(int x, int y) {
		
		for (int i=elementy;i>=1;i--) {
			iksy[i]=iksy[i-1];
			igreki[i]=igreki[i-1];
			
		}
		
		iksy[0]=x;
		igreki[0]=y;
	}
	
	
	
	public Timer tajmer(TimerTask task, int delay) {
		
		Timer timer1=new Timer();
		timer1.schedule(task,delay, 20);
		return timer1;
	}

	public Timer tajmer(TimerTask task) {
		
		Timer timer1=new Timer();
		timer1.schedule(task,new Date(), 20);
		return timer1;
	}
	
	public boolean sprawdzLosowaniePunktu(int x, int y) {
		boolean test=true;
		
		for(int i=elementy;i>=0;i-=5) {
			
			if(		(		((x-iksy[i])>=-35) && (x-iksy[i]<=35)
					&& 
					(		(y-igreki[i])>=-35) && (y-igreki[i]<=35))
					==true) {
				test=false;
			}
			
		}
		
		
		return test;
	}
	public void losuj() {
		Random x=new Random();
		
		int xtest=x.nextInt(380);
		int ytest=x.nextInt(365);
		
		
		if(sprawdzLosowaniePunktu(xtest,ytest)==true) {
			xpunkt=xtest;
			ypunkt=ytest;
			punkty+=1;
		}
		else {
			losuj();
		}
		
	}
	public void petlaPoczatkowa() {
		for (int i=elementy;i>=1;i--) {
			iksy[i]=800;
			igreki[i]=800;
		}
	}
	public void petlaZebySieNiePojawialyUGory() {
		for(int i=elementy;i>=elementy-20;i--) {
			iksy[i]=800;
			igreki[i]=800;
		}
	}
	
	
	
	
	
	
	public void rysujpunkt(Graphics2D g,int x,int y) {
		
		Color kolor=Color.red;
		punkt=kwadrat(g,x,y,kolor);
		
	}
	
	
	
	public void sprawdzaj() {
		if(  (			iksy[0]-punkt.getX() >=-15 && iksy[0]-punkt.getX()<=15			)
				
				&&(				igreki[0]-punkt.getY()>=-15	&& igreki[0]-punkt.getY()<=15							) ) {
			
			elementy+=5;
			petlaZebySieNiePojawialyUGory();
			losuj();
			
		}
	}
	
	
	

	public Rectangle kwadrat(Graphics2D g,int x,int y,Color kolor) {
		g.setColor(kolor);
		Rectangle kwadrat=new Rectangle();
		kwadrat.setBounds(x,y,15,15);
		g.fill(kwadrat);
		return kwadrat;
	}
	
	
	
	

	@Override
	public void keyPressed(KeyEvent e) {
		
		//System.out.println(e.getKeyCode());
		//System.out.println("x "+iksy[0]);
		//System.out.println("y "+igreki[0]);
		
		switch(e.getKeyCode()) {
		
		case (39):
		case (68):
				xplus();
				break;
				
				
		case(87):
		case(38):
				yminus();
				break;
		case(65):
		case(37):
				xminus();
				break;
		case(40):
		case(83):
				yplus();
				break;
		}

		
	}

	static int predkoscx=7;
	static int predkoscy=7;
	static Timer timer1;
	static Timer timer2;
	static Timer timer3;
	static Timer timer4;
	
	public void xplus() {
		if(direction!=3&&direction!=1&&direction!=0) {
			switch(direction) {
			case 4:timer4.cancel();
			break;
			case 2:timer2.cancel();
			break;
			}
			
			
				timer1=tajmer(new Timer1());
				direction=1;
				predkoscy=0;
				}

			
			
		}
	
	public void yplus() {
		if(direction!=2&&direction!=4&&direction!=0)
		{
			switch(direction) {
			case 1:timer1.cancel();
			break;
			case 3:timer3.cancel();
			}
			
			

				timer4=tajmer(new TimerDol());
				direction=4;
				predkoscx=0;

			}
			
			
		}
	
	public void yminus() {
		if(direction!=4&&direction!=2&&direction!=0) {
			switch(direction) {
			case 3:timer3.cancel();
			break;
			case 1:timer1.cancel();
			break;
			}

				timer2=tajmer(new TimerGora());
				direction=2;
				predkoscx=0;


		}
	}
	public void xminus() {
		if(direction!=1&&direction!=3&&direction!=0) {
			switch(direction) {
			case 2:timer2.cancel();
			break;
			case 4:timer4.cancel();
			break;
			}
			
				timer3=tajmer(new TimerLewo());
				direction=3;
				predkoscy=0;
			
		}
	}
	

	
	
	//-------------------nothing-----------------//
	@Override
	public void keyTyped(KeyEvent e) {
		
		//nothing
	}

	@Override
	public void keyReleased(KeyEvent e) {
		//nothing
		
	}
	//-------------------nothing-----------------//






	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	public static void setiksy(boolean x) {
		if(x==true) {
			iksy[0]+=15;
		}
		else {
			iksy[0]-=15;
		}
	}
	public static void setigreki(boolean y) {
		if(y==true) {
			igreki[0]+=15;
		}
		else {
			igreki[0]-=15;
		}
	}
	
	
	public static void sprawdzajKolizjePrawo() {
		
		if(		(iksy[0]-szerokosc>=-10)	&& (iksy[0]-szerokosc<=0)	) {
			przegrana();
			System.out.println("łeb5");
		}
			
	}
	public static void sprawdzajKolizjeLewo() {
		
		if( (iksy[0]<=0)) {
			przegrana();
			System.out.println("łeb4");
		}
		
	}
	public static void sprawdzajKolizjeDol() {
		
		if(		(igreki[0]-szerokosc>=-10)	&& (igreki[0]-szerokosc<=0)	) {
			przegrana();
			System.out.println("łeb3");
		}
		
	}
	public static void sprawdzajKolizjeGora() {
		
		if( (igreki[0]<=0)) {
			przegrana();
			System.out.println("łeb2");
		}
	}
	

	public static void sprawdzajKolizjeCialo() {
		
		
		for(int i=elementy;i>=20;i-=1) {
			
			
			if(			((iksy[0]-iksy[i])>=-10 && (iksy[0]-iksy[i]<=10))	
					
					
					&&		
					
					(((igreki[0]-igreki[i])>=-10) &&	(igreki[0]-igreki[i])<=10)		) {
				
				przegrana();
				//System.out.println("łeb1");
				
				
				
				
				
			}
		}
	}
	
	public static void przegrana() {
		
		switch(direction) {	
		case 1:
			timer1.cancel();
			break;
		case 2:
			timer2.cancel();
			break;
		case 3:
			timer3.cancel();
			break;
		case 4:
			timer4.cancel();
			break;	
		}
		
		
		czyKoniec=true;
		punkty--;
		koniec();
		
		
	}
	public static void koniec() {
		
		direction=0;
		if(czyKoniec==true) {
			oknkoKoniec=new oknoKoncowe();
		}
	}
	public static int getPunkty() {
		return punkty;
	}
	

	
	
}
