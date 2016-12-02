import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Scores extends JFrame {

	private JButton bRetour = new JButton("Retour");
	private JButton[] boutons = { bRetour };
	private ImageIcon fond;
	private Background Background = new Background();
	private String Score[] = new String[10];

	public Scores(){
		// Propriétés de la fenêtre
		this.setTitle("Cubix3000 - Scores");
		this.setSize(606, 628);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setContentPane(Background);
		this.setVisible(false);
		this.setResizable(false);
		this.setLayout(null);
		
		// Configuration des boutons
		for (JButton bouton : boutons) {
			bouton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			Background.add(bouton);
		}

		// Position des boutons
		bRetour.setBounds(200,500,200,40);
		
		//habillage des boutons
		fond = new ImageIcon("bRetour.png");
		bRetour.setIcon(fond);
		fond = new ImageIcon("bRetour V.png");
		bRetour.setPressedIcon(fond);
		
		// Liaison des évênements
		bRetour.addActionListener(new bRetourListener());
	}

	public void Ouvrir() {
		this.setVisible(true);
	}

	public void Fermer() {
		this.setVisible(false);
	}

	class bRetourListener implements ActionListener {
		// Redéfinition de la méthode actionPerformed()
		public void actionPerformed(ActionEvent e) {
			Fermer();
		}
	}
	
	class Background extends JPanel {
		public void paintComponent(Graphics g) {
			try {
				Image background = ImageIO.read(new File("fond-score.png"));
				g.drawImage(background, 0, 0, this);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			int i;
			int x=200;
			int y=200;
			g.setColor(new Color(70, 102, 175));
			Font font = new Font("Fixedsys", Font.BOLD, 15);
			g.setFont(font);
			java.util.Scanner f;
			f=Isn.openIn("Score.txt");
			for(i=0;i<10;i++){
				Score[i]=Isn.readStringFromFile(f);
				g.drawString(Score[i], x, y=20+y);
			}																								
			Isn.closeIn(f);
			
		}
	}
}