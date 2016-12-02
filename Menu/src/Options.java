import java.awt.Cursor;
import java.awt.Dimension;
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

public class Options extends JFrame {

	private JButton bRetour = new JButton("Retour");
	private JButton bDifficulte = new JButton ("Difficulte");
	private JButton[] boutons = { bRetour, bDifficulte };
	private ImageIcon fond;
	private Background Background = new Background();
	int niveau = 0;
	
	public Options() {

		// Propriétés de la fenêtre
		this.setTitle("Cubix3000 - Options");
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
		bRetour.setBounds(200, 500, 200, 40);
		bDifficulte.setBounds(200, 300, 200, 40);

		// habillage des boutons
		fond = new ImageIcon("bRetour.png");
		bRetour.setIcon(fond);
		fond = new ImageIcon("bRetour V.png");
		bRetour.setPressedIcon(fond);

		fond = new ImageIcon("bFacile.png");
		bDifficulte.setIcon(fond);

		// Liaison des évênements
		bRetour.addActionListener(new bRetourListener());
		bDifficulte.addActionListener(new Niveau());

	}

	public void Ouvrir() {
		this.setVisible(true);
	}

	public void Fermer() {
		this.setVisible(false);
	}

	class Niveau implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String Difficulte ="Difficulte.txt";
			java.io.OutputStreamWriter ff;
			ff=Isn.openOut(Difficulte);
			if (niveau < 2) {
				niveau++;
				System.out.println(niveau);
			} else if (niveau == 2) {
				niveau = 0;
				System.out.println(niveau);
			}
			Isn.printlnToFile(ff, niveau);
			System.out.println(niveau);
			Isn.closeOut(ff);
			switch(niveau) {
				case 1 :
					fond = new ImageIcon("bNormal.png");
					bDifficulte.setIcon(fond);
				break;
				case 2 :
					fond = new ImageIcon("bDifficile.png");
					bDifficulte.setIcon(fond);
				break;
				default :
					fond = new ImageIcon("bFacile.png");
					bDifficulte.setIcon(fond);
				break;
			}
		}
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
				Image background = ImageIO.read(new File("fond.png"));
				g.drawImage(background, 0, 0, this);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
	