import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.font.TextAttribute;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.AttributedString;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;

public class Menu extends JFrame {

	private JButton bNouveau_Jeu = new JButton("Nouveau Jeu");
	private JButton bOptions = new JButton("Options");
	private JButton bScores = new JButton("Scores");
	private JButton[] boutons = { bNouveau_Jeu, bOptions, bScores };
	private Options fOptions;
	private Scores fScores;
	private ImageIcon fond;
	private Background Background = new Background();
	private String LOL;

	public Menu(Options fOptions, Scores fScores) {

		// Mise à jour des fenêtres
		this.fOptions = fOptions;
		this.fScores = fScores;

		// Propriétés de la fenêtre
		this.setTitle("Cubix3000");
		this.setSize(606, 628);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setContentPane(Background);
		this.setVisible(true);
		this.setResizable(false);
		this.setLayout(null);

		// Configuration des boutons
		for (JButton bouton : boutons) {
			bouton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			Background.add(bouton);
		}

		//  Position des boutons
		bNouveau_Jeu.setBounds(200,200,200,40);
		bOptions.setBounds(200,300,200,40);
		bScores.setBounds(200,400,200,40);

		// habillage des boutons :
		fond = new ImageIcon("bNouveau jeu.png");
		bNouveau_Jeu.setIcon(fond);
		fond = new ImageIcon("bNouveau jeu V.png");
		bNouveau_Jeu.setPressedIcon(fond);

		fond = new ImageIcon("bOptions.png");
		bOptions.setIcon(fond);
		fond = new ImageIcon("bOptions V.png");
		bOptions.setPressedIcon(fond);
		
		fond = new ImageIcon("bScores.png");
		bScores.setIcon(fond);
		fond = new ImageIcon("bScores V.png");
		bScores.setPressedIcon(fond);

		// Liaison des évênements
		bNouveau_Jeu.addActionListener(new bNouveau_JeuListener());
		bOptions.addActionListener(new bOptionsListener());
		bScores.addActionListener(new bScoresListener());
		
	}

	class bNouveau_JeuListener implements ActionListener {
		// Redéfinition de la méthode actionPerformed()
		public void actionPerformed(ActionEvent e) {
			try {
				Runtime runtime = Runtime.getRuntime();
				runtime.exec("java -jar Cubix.jar");
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}

	class bOptionsListener implements ActionListener {
		// Redéfinition de la méthode actionPerformed()
		public void actionPerformed(ActionEvent e) {
			fOptions.Ouvrir();
		}
	}

	class bScoresListener implements ActionListener {
		// Redéfinition de la méthode actionPerformed()
		public void actionPerformed(ActionEvent e) {
			fScores.Ouvrir();
		}
	}

	class Background extends JPanel {
		public void paintComponent(Graphics g) {
			try {
				Image background = ImageIO.read(new File("fond.png"));
				g.drawImage(background, 0, 0, this);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
