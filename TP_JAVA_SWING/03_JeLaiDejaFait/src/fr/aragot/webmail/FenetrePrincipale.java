package fr.aragot.webmail;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.Window.Type;
import javax.swing.JToolBar;
import javax.swing.JMenuBar;
import javax.swing.JMenu;

public class FenetrePrincipale extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1740235497903499624L;

	public FenetrePrincipale() {
		setTitle("Envoi de mails à un destinataire");
		getContentPane().setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setToolTipText("");
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Message");
		mnNewMenu.setMnemonic('M');
		menuBar.add(mnNewMenu);
		
		JMenu mnNewMenu_1 = new JMenu("Options");
		mnNewMenu_1.setMnemonic('O');
		menuBar.add(mnNewMenu_1);
		
		JMenu mnNewMenu_2 = new JMenu("?");
		mnNewMenu_2.setMnemonic('?');
		menuBar.add(mnNewMenu_2);
		initMenus();
		initControles();
	}

	private void initMenus() {
		// TODO Auto-generated method stub
		
	}

	private void initControles() {
		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
