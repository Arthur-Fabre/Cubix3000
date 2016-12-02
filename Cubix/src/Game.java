import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;



public class Game extends JFrame {
	private static Grille pan = new Grille();
	
	private JTextField jtf;
	private boolean End;
	private boolean Tour;
	
	
	
	public Game(){
		// Affichage de la fenètre
		this.setTitle("Cubix3000"); 							// Nom
		this.setSize(606, 628);									// Dimention
		this.setLocationRelativeTo(null);						// Position
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	// Fermeture sur le bouton
		this.setResizable(false);								// redimetionnement
		this.setContentPane(pan);								// images contenues
		this.setVisible(true);									// affiche la fenètre
		GO();													// lance le programe principal
		}

		
	    
		static void pause(int P){
	    	try {
	    		Thread.sleep(P);
	    	} catch (InterruptedException e){
	    		e.printStackTrace();
	    	}
		}
		
		static void T(){
			java.io.OutputStreamWriter ff;
	    	ff=Isn.openOut("T");
	    	Isn.printlnToFile(ff, 0);
	    	Isn.closeOut(ff);
	    	
		}
		
		static void Clear(int a){
			pan.setGrilleC(9,0,a);
	    	pan.repaint();
		}
		
		static void InitialisationNiveaux(int i, int x, int y){
			if(i<10){
				pan.setNiv(i,x,y,i,0);
				InitialisationNiveaux(i+1,x+10,y);
			}
			
		}
		
		static void Initialisation(int i, int j, int x, int y, int Occup,int V){
			if (i<250){
		
				pan.setGrille(i,x,y,9,Occup,i,V);
				if(i==j){
					 Initialisation(i+1,j+10,104,y+20,Occup,0);
				}else{
					 Initialisation(i+1,j,x+20,y,Occup,V+1);
				}
			}
			for(i=250;i<300;i++){
				pan.setGrilleC(9,1,i);
			}
			
		}
		
		private void Tour(int P,int Position,int Couleur1,int Couleur2,int i,int j,int a,int Bas){
			if(i<250 && Tour==false)
			{	
				if(Bas==0){
					if (Position==4)
					{
						Position=0;
					}
					java.util.Scanner f;
					f=Isn.openIn("T");
					a=Isn.readIntFromFile(f);
					Isn.closeIn(f);
					//gauche
				
					if((a==37)&&(i!=50)&&(i!=60)&&(i!=70)&&(i!=80)&&(i!=90)&&(i!=100)&&(i!=110)&&(i!=120)&&(i!=130)&&(i!=140)&&(i!=150)&&(i!=160)&&(i!=170)&&(i!=180)&&(i!=190)&&(i!=200)&&(i!=210)&&(i!=220)&&(i!=230)&&(i!=240)   &&    (j!=50)&&(j!=60)&&(j!=70)&&(j!=80)&&(j!=90)&&(j!=100)&&(j!=110)&&(j!=120)&&(j!=130)&&(j!=140)&&(j!=150)&&(j!=160)&&(j!=170)&&(j!=180)&&(j!=190)&&(j!=200)&&(j!=210)&&(j!=220)&&(j!=230)&&(j!=240)){
						if((Position==0 && pan.getGrille(i-1, 4)==0)||(Position==2 && pan.getGrille(i-2, 4)==0)||(Position==1 && pan.getGrille(i-1, 4)==0 && pan.getGrille(j-1, 4)==0)||(Position==3 && pan.getGrille(i-1, 4)==0 && pan.getGrille(j-1, 4)==0)){
							i=i-1;
							j=j-1;	
						}
						T();
					}
					//fin gauche
					//droite
					if((a==39)&&(i!=59)&&(i!=69)&&(i!=79)&&(i!=89)&&(i!=99)&&(i!=109)&&(i!=119)&&(i!=129)&&(i!=139)&&(i!=149)&&(i!=159)&&(i!=169)&&(i!=179)&&(i!=189)&&(i!=199)&&(i!=209)&&(i!=219)&&(i!=229)&&(i!=239)&&(i!=249)   &&    (j!=59)&&(j!=69)&&(j!=79)&&(j!=89)&&(j!=99)&&(j!=109)&&(j!=119)&&(j!=129)&&(j!=139)&&(j!=149)&&(j!=159)&&(j!=169)&&(j!=179)&&(j!=189)&&(j!=199)&&(j!=209)&&(j!=219)&&(j!=229)&&(j!=239)&&(j!=249)){
						if((Position==0 && pan.getGrille(i+2, 4)==0)||(Position==2 && pan.getGrille(i+1, 4)==0)||(Position==1 && pan.getGrille(i+1, 4)==0 && pan.getGrille(j+1, 4)==0)||(Position==3 && pan.getGrille(i+1, 4)==0 && pan.getGrille(j+1, 4)==0)){
							i=i+1;
							j=j+1;
						}
						T();
					}
				
					//fin droite
					//Rotation
					if(Position==3 && a==38){
						if((j!=59)&&(j!=69)&&(j!=79)&&(j!=89)&&(j!=99)&&(j!=109)&&(j!=119)&&(j!=129)&&(j!=139)&&(j!=149)&&(j!=159)&&(j!=169)&&(j!=179)&&(j!=189)&&(j!=199)&&(j!=209)&&(j!=219)&&(j!=229)&&(j!=239)&&(j!=249)){
							if(pan.getGrille(i-1, 4)==0 && pan.getGrille(j-1, 4)==0){
								i=i+10;
								j=j+1;
							} else {
								i=i+9;
							}
						} else {
							i=i+9;
						}
						Position=4;
						T();
					}

					if(Position==2 && a==38){
						i=i-10;
						j=j+1;
						Position=3;	
						T();
					}
					if(Position==1 && a==38){
						if((i!=50)&&(i!=60)&&(i!=70)&&(i!=80)&&(i!=90)&&(i!=100)&&(i!=110)&&(i!=120)&&(i!=130)&&(i!=140)&&(i!=150)&&(i!=160)&&(i!=170)&&(i!=180)&&(i!=190)&&(i!=200)&&(i!=210)&&(i!=220)&&(i!=230)&&(i!=240)){
							if(pan.getGrille(i-1, 4)==0 && pan.getGrille(j-1, 4)==0){
								j=j+9;
							} else {
								j=j+10;
								i=i+1;
							}
						} else {
							j=j+10;
							i=i+1;
						}
						Position=2;
						T();	
					}
					if(Position==0 && a==38){
						j=j-11;
						Position=1;
						T();
					}
					System.out.println("Position : " +Position);
					// fin rotation
					//direc en bas
					if((a==40)){
						Bas=1;
						P=100;
						T();
					}
				}
				//fin direct en bas
				pan.setGrilleC(Couleur1,1,i);
				pan.setGrilleC(Couleur2,1,j);
		    	pan.repaint();
		    	//System.out.println("i : " +i);
		    	//System.out.println("j : " +j);
		    	pause(P);
				if((i==240||i==241||i==242||i==243||i==244||i==245||i==246||i==247||i==248||i==249)||(j==240||j==241||j==242||j==243||j==244||j==245||j==246||j==247||j==248||j==249)){
					Tour=true;
				}else{
					if(Position==3){
						if(pan.getGrille(j+10, 4)==1){
							Tour=true;
							System.out.println("R");
						}	
						if(pan.getGrille(j+10, 4)==0){
							Clear(i);
							Clear(j);
							Tour(P,Position,Couleur1,Couleur2,i=i+10,j=j+10,0,Bas);
						}
					}
					if(Position==1){
						if(pan.getGrille(i+10, 4)==1){
							Tour=true;
							System.out.println("R");
						}
						if(pan.getGrille(i+10, 4)==0){
							Clear(i);
							Clear(j);
							Tour(P,Position,Couleur1,Couleur2,i=i+10,j=j+10,0,Bas);
						}
					}
					if((Position==0) || (Position==2) || (Position==4)){
						if(pan.getGrille(i+10, 4)==1 && pan.getGrille(j+10, 4)==1){
							Tour=true;
						}
						if(pan.getGrille(i+10, 4)==0 && pan.getGrille(j+10, 4)==0){
							Clear(i);
							Clear(j);
							Tour(P,Position,Couleur1,Couleur2,i+10,j+10,0,Bas);
						}
						if(pan.getGrille(i+10, 4)==0 && pan.getGrille(j+10, 4)==1){
							Clear(i);
							Tour(100,Position,Couleur1,Couleur2,i+10,j,0,1);
						}
						if(pan.getGrille(i+10, 4)==1 && pan.getGrille(j+10, 4)==0){
							Clear(j);
							Tour(100,Position,Couleur1,Couleur2,i,j+10,0,1);
						}
					}
				
				}
			}
		}
		private void mvt(int i, int mvt){
			if(i>49){
				System.out.println(pan.getGrille(i+10, 4)+"   "+pan.getGrille(i, 3));
				if((pan.getGrille(i+10, 4)==0)&&(pan.getGrille(i, 3)!=9)){
					int C=pan.getGrille(i, 3);
					Clear(i);
					pause(75);
					pan.setGrilleC(C,1,i+10);
					pan.repaint();
					pause(75);
					mvt(249,1);
				}
				mvt(i-1,0);
			}
		}
		private void VerifClear(int i1,int i2,int i3, int i4, int i5, int i6){
			Clear(i6);
			Clear(i1);
			Clear(i2);
			Clear(i3);
			Clear(i4);
			Clear(i5);
		}
		
		private void Verif(int multi){
			int i;
			for(i=50;i<250;i++){
				int a=-1;
				int mvt=0;
				int xx=multi;
				if(pan.getGrille(i, 4)==1){
					a=pan.getGrille(i, 3);
					//pour 6 blocks
					if(pan.getGrille(i+10, 3)==a && pan.getGrille(i+20, 3)==a && pan.getGrille(i+30, 3)==a && pan.getGrille(i+40, 3)==a && pan.getGrille(i+50, 3)==a){
						VerifClear(i,i+10,i+20,i+30,i+40,i+50);
						mvt=4;
					}
					
					if(pan.getGrille(i, 5)==0 || pan.getGrille(i, 5)==1 || pan.getGrille(i, 5)==2 || pan.getGrille(i, 5)==3 || pan.getGrille(i, 5)==4){
						if(pan.getGrille(i+1, 3)==a && pan.getGrille(i+2, 3)==a && pan.getGrille(i+3, 3)==a && pan.getGrille(i+4, 3)==a && pan.getGrille(i+5, 3)==a){
							VerifClear(i,i+1,i+2,i+3,i+4,i+5);
							mvt=4;
						}
					}
					//fin pour 6 block
					//pour 5 blocks
					if(pan.getGrille(i+10, 3)==a && pan.getGrille(i+20, 3)==a && pan.getGrille(i+30, 3)==a && pan.getGrille(i+40, 3)==a){
						VerifClear(i,i+10,i+20,i+30,i+40,0);
						mvt=3;
					}
					if(pan.getGrille(i, 5)==0 || pan.getGrille(i, 5)==1 || pan.getGrille(i, 5)==2 || pan.getGrille(i, 5)==3 || pan.getGrille(i, 5)==4 || pan.getGrille(i, 5)==5){
						if(pan.getGrille(i+1, 3)==a && pan.getGrille(i+2, 3)==a && pan.getGrille(i+3, 3)==a && pan.getGrille(i+4, 3)==a){
							VerifClear(i,i+1,i+2,i+3,i+4,0);
							mvt=3;
						}
					}
					//fin pour 5 block
					//pour 4 blocks
					if(pan.getGrille(i+10, 3)==a && pan.getGrille(i+20, 3)==a && pan.getGrille(i+30, 3)==a){
						VerifClear(i,i+10,i+20,i+30,0,0);
						mvt=2;
					}
					if(pan.getGrille(i, 5)==0 || pan.getGrille(i, 5)==1 || pan.getGrille(i, 5)==2 || pan.getGrille(i, 5)==3 ||pan.getGrille(i, 5)==4 || pan.getGrille(i, 5)==5 || pan.getGrille(i, 5)==6){
						if(pan.getGrille(i+1, 3)==a && pan.getGrille(i+2, 3)==a && pan.getGrille(i+3, 3)==a){
							VerifClear(i,i+1,i+2,i+3,0,0);
							mvt=2;
						}
					}
					//fin pour 4 block
					//pour 3 blocks
					if(pan.getGrille(i+10, 3)==a && pan.getGrille(i+20, 3)==a){
						VerifClear(i,i+20,i+10,0,0,0);
						mvt=1;
					}
					if(pan.getGrille(i, 5)==0 || pan.getGrille(i, 5)==1 ||pan.getGrille(i, 5)==2 || pan.getGrille(i, 5)==3 || pan.getGrille(i, 5)==4 || pan.getGrille(i, 5)==5 || pan.getGrille(i, 5)==6 || pan.getGrille(i, 5)==7){
						if(pan.getGrille(i+1, 3)==a && pan.getGrille(i+2, 3)==a){
							VerifClear(i,i+2,i+1,0,0,0);
							mvt=1;
						}
					}
					//fin pour 3 blocks
				
				}
				if (mvt>0){
					if(mvt==4){
						xx=multi+3;
					}
					if(mvt==3){
						xx=multi+2;
					}
					if(mvt==2){
						xx=multi+1;
					}
					int Score=pan.getScore();
					Score=Score+(10*xx);
					pan.setScore(Score);
					System.out.println("retest");
					mvt(249,1);
					pause(50);
					Verif(multi);	
				}
			}
		}
		
	    private void GO(){									//debut programme principal
	    	jtf = new JTextField();							//score
			jtf.addKeyListener(new ClavierListener());		//clavier interface
			pan.add(jtf);									//ajout de jtf
			
			
			this.End = false;								//fin du jeux a faux
			int Next1=(int) (Math.random()*4)+1;			//tirage cube suivant 1
			int Next2=(int) (Math.random()*4)+1;			//tirage cube suivant 2
			//int Next1=3;
			//int Next2=3;
			
			int multi=1;									//multiplicateur de score

			int score=20;									//prochaine barre de chargement
			int nextLevel=200;								//niveaux suivant
			int lastLevel=0;
			int i=0;
			int niv=0;										//niveaux de départ
			int acc=1;										//que faire prochain niv
			
			int speed=500; 									//vitesse dep
			int P=speed;
			int couleurs=4;									//nb de couleur départ
			int C1=couleurs;								
			int C2=couleurs;
			
			pan.setNext(0,366,184,0,0);						//poss cube suivant 1 et 2
			pan.setNext(1,406,184,0,1);
			pan.setScore(0);								//met le score à 0
			pan.setEND(0);									//met mais end a 0
			pan.setNiveaux(niv);							//met le Niv a 0
			
			
			InitialisationNiveaux(0,356,312);				// initialise la bare de chargement
			Initialisation(50,59,104,154,0,0);				// initialise la grille
			T();											// initialise les touche
			
			while(End==false)								//commence le jeux
			{
				if (pan.getScore()>nextLevel && niv!=6){				//verifi le score/niveaux
					for(i=0;i<10;i++){
						pan.setNivO(0, i);
					}
					pan.setNiveaux(niv=niv+1);
					lastLevel=nextLevel;
					nextLevel=nextLevel+200*niv;
					i=0;
					if(pan.getNiveaux()==acc){
						couleurs=couleurs+2;
						C1=C2=couleurs;
					}
					if(pan.getNiveaux()==(acc+1)){
						speed=speed-100;
						P=speed;
					}
					
				}
				while(pan.getScore()>=score && niv!=6){
					pan.setNivO(1, i);
					score=score+(10*(nextLevel-lastLevel)/100);
					i=i+1;
				}
				if (niv==6){
					for(i=0;i<10;i++){
						pan.setNivO(0, i);
					}
					pan.setNiveauxMax(1);
				}
				System.out.println(score);
				pan.repaint();
				this.Tour = false;							//

				
				int Couleur1=Next1;							//Assigne les couleurs
				int Couleur2=Next2;	
				Next1 = (int) (Math.random()*C1)+1;			//Choisis les prochaines couleurs 
				Next2 = (int) (Math.random()*C2)+1;

				pan.setNextC(Next1,0);						//Donne les prochaine couleur a grille
				pan.setNextC(Next2,1);

				Tour(P,0,Couleur1,Couleur2,44,45,0,0);		//commance l'animation d'unee pair de block
				//System.out.println("test");					
				Verif(multi);								//verifi les cases
				if((pan.getGrille(50, 4)==1)||(pan.getGrille(51, 4)==1)||(pan.getGrille(52, 4)==1)||(pan.getGrille(53, 4)==1)||(pan.getGrille(54, 4)==1)||(pan.getGrille(55, 4)==1)||(pan.getGrille(56, 4)==1)||(pan.getGrille(57, 4)==1)||(pan.getGrille(58, 4)==1)||(pan.getGrille(59, 4)==1)){
					End=true;
					pan.setEND(1);
					pan.repaint();
				
				}
			}
	    }
	}
	
		


