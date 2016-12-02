import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Grille extends JPanel {
	 private int Grille[][]=new int[300][6];		//grille morpion
	 private int Next[][]=new int[2][4];			//block suivant
	 private int Niv[][]=new int [10][4];			//niveau en cour
	 private int Niveaux;
	 private int NiveauxMax=0;
	 private int Score;								//score de la partie
	 private int END;								//fin du jeux
	 
	 public void setNiveauxMax(int s){
		 NiveauxMax=s;
	 }
	 public int getScore(){
		 return Score;
	 }
	 public void setScore(int s){
		 Score=s;
	 }
	 public int getNiveaux(){
		 return Niveaux;
	 }
	 public void setNiveaux(int s){
		 Niveaux=s;
	 }
	 public void setEND(int s){
		 END=s;
	 }
	 
	 public int getGrille(int i,int j){
		 return Grille[i][j];
	 }
	 public int getNiv(int i,int j){
		 return Niv[i][j];
	 }
	 public void setNiv(int Case,int x,int y, int i, int Occup) {
		 Niv[i][0] = Case;
	  	 Niv[i][1] = x;
	  	 Niv[i][2] = y;
	  	 Niv[i][3] = Occup;
	  	 //System.out.println(this.Niv[i][0]+"   "+this.Niv[i][1]+"   "+this.Niv[i][2]);
	    }
	 
	 public void setNivO(int Occup, int i) {
	  	 Niv[i][3] = Occup;
	  	 //System.out.println(this.Niv[i][3]);
	    }
	 public void setNext(int Case,int x,int y,int Couleur, int i) {
	  	 Next[i][0] = Case;
	  	 Next[i][1] = x;
	  	 Next[i][2] = y;
	  	 Next[i][3] = Couleur;
	  	 //System.out.println(this.Next[i][0]+"   "+this.Next[i][1]+"   "+this.Next[i][2]+"    "+this.Next[i][3]);
	    }
	 
	 public void setNextC(int Couleur, int i) {
	  	 Next[i][3] = Couleur;
	  	 //System.out.println(this.Next[i][3]);
	    }
	 
	 public void setGrille(int Case,int x,int y,int Couleur, int Occup, int i,int Verif) {
	  	 Grille[i][0] = Case;
	  	 Grille[i][1] = x;
	  	 Grille[i][2] = y;
	  	 Grille[i][3] = Couleur;
	  	 Grille[i][4] = Occup;
	  	 Grille[i][5] = Verif;
	  	 //System.out.println(this.Grille[i][0]+"   "+this.Grille[i][1]+"   "+this.Grille[i][2]+"    "+this.Grille[i][3]+"   "+this.Grille[i][4]+"   "+this.Grille[i][5]);
	    }
	 
	 public void setGrilleC(int Couleur, int Occup,int i) {
	  	 Grille[i][3] = Couleur;
	  	 Grille[i][4] = Occup;
	  	  //System.out.println(this.Grille[i][3]+"   "+this.Grille[i][4]);
	    }
	 
	 public void paintComponent(Graphics g){

		 int i;
		 //for(i=0;i<72;i++){
		 	//System.out.println(Grille[i][0]+"   "+Grille[i][1]+"   "+Grille[i][2]+"    "+Grille[i][3]);
		 //}
		 try{
			 Image img1 = ImageIO.read(new File("Background.png"));
			 g.drawImage(img1, 0, 0, this.getWidth(), this.getHeight(), this);
	     	} 
		 catch (IOException e) {
		      e.printStackTrace();
		 	}
		 g.setColor(new Color(70, 102, 175));
		 String n = String.valueOf(Niveaux);
		 Font font1 = new Font("Fixedsys", Font.BOLD, 15);
		 g.setFont(font1);
		 g.drawString(n, 420, 297);
		 //score
		 String t = String.valueOf(Score);
		 Font font = new Font("Fixedsys", Font.BOLD, 15);
		 g.setFont(font);
		 g.drawString(t, 366, 397);
		 
		 if (NiveauxMax==1){
			 g.setColor(Color.RED); 
			 g.drawString("MAX", 300, 225);
		 }
		 for(i=0;i<10 && NiveauxMax==0;i++)
		 {
			 try {
				 if(Niv[i][3]==1){
					 Image IMG = ImageIO.read(new File("Bnoir.png"));
				      g.drawImage(IMG, Niv[i][1], Niv[i][2], this);  
				 }
				 if(Niv[i][3]==0){
					 Image IMG = ImageIO.read(new File("Bvert.png"));
				      g.drawImage(IMG, Niv[i][1], Niv[i][2], this);  
				 }
			 } catch (IOException e) {
			      e.printStackTrace();
			   } 
		 }
		 
		 for(i=0;i<2;i++)
		 {
			 
			 try {
			 if(Next[i][3]==1){

				      Image IMG = ImageIO.read(new File("red.png"));
				      g.drawImage(IMG, Next[i][1], Next[i][2], 40,40, this);
			 	}
			 	if(Next[i][3]==2){

				      Image IMG = ImageIO.read(new File("green.png"));
				      g.drawImage(IMG, Next[i][1], Next[i][2],40,40, this);
			 	}
			 	if(Next[i][3]==3){

				      Image IMG = ImageIO.read(new File("bleu.png"));
				      g.drawImage(IMG, Next[i][1], Next[i][2], 40,40,this);
			 	}
			 	if(Next[i][3]==4){

				      Image IMG = ImageIO.read(new File("orange.png"));
				      g.drawImage(IMG, Next[i][1], Next[i][2],40,40, this);
			 	}
			 	if(Next[i][3]==5){
			 		Image IMG = ImageIO.read(new File("cyan.png"));
				      g.drawImage(IMG, Next[i][1], Next[i][2],40,40, this); 
			 	}
			 	if(Next[i][3]==6){
			 		Image IMG = ImageIO.read(new File("violet.png"));
				      g.drawImage(IMG, Next[i][1], Next[i][2],40,40, this);  
			 	}
			 	if(Next[i][3]==7){
			 		Image IMG = ImageIO.read(new File("jaune.png"));
				      g.drawImage(IMG, Next[i][1], Next[i][2],40,40, this);  
			 	}
			 	if(Next[i][3]==8){
			 		Image IMG = ImageIO.read(new File("pink.png"));
				      g.drawImage(IMG, Next[i][1], Next[i][2],40,40, this);;  
			 	}

			 } catch (IOException e) {
			      e.printStackTrace();
			   } 
		 }

		 for(i=50;i<250;i++)
		 {
			 try {
				 if(Grille[i][3]==1){
				 	Image IMG = ImageIO.read(new File("red.png"));
				 	g.drawImage(IMG, Grille[i][1], Grille[i][2], this);    
			 	}
			 	if(Grille[i][3]==2){
			 		Image IMG = ImageIO.read(new File("green.png"));
			 		g.drawImage(IMG, Grille[i][1], Grille[i][2], this);  ;  
			 	}
			 	if(Grille[i][3]==3){
			 		Image IMG = ImageIO.read(new File("bleu.png"));
			 		g.drawImage(IMG, Grille[i][1], Grille[i][2], this);   
			 	}
			 	if(Grille[i][3]==4){
			 		Image IMG = ImageIO.read(new File("orange.png"));
			 		g.drawImage(IMG, Grille[i][1], Grille[i][2], this);  
			 	}
			 	if(Grille[i][3]==5){
			 		Image IMG = ImageIO.read(new File("cyan.png")); 
			 		g.drawImage(IMG, Grille[i][1], Grille[i][2], this); 
			 	}
			 	if(Grille[i][3]==6){
			 		Image IMG = ImageIO.read(new File("violet.png")); 
			 		g.drawImage(IMG, Grille[i][1], Grille[i][2], this); 
			 	}
			 	if(Grille[i][3]==7){
			 		Image IMG = ImageIO.read(new File("jaune.png"));
			 		g.drawImage(IMG, Grille[i][1], Grille[i][2], this); 
			 	}
			 	if(Grille[i][3]==8){
			 		Image IMG = ImageIO.read(new File("pink.png"));  
			 		g.drawImage(IMG, Grille[i][1], Grille[i][2], this); 
			 	}
			 } catch (IOException e) {
			      e.printStackTrace();
			 } 
		 }
		 if(END==1){
			 Font GAMEOVER = new Font("Arial", Font.BOLD, 50);
			    g.setFont(GAMEOVER);
			    g.setColor(Color.red);          
			    g.drawString("GAMEOVER", 50, 400);
		 }
	  
	 } 
	
 }
