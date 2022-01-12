package fr.aragot.loto;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class MainApp {

	private JFrame frmRsultatsLoto;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainApp window = new MainApp();
					window.frmRsultatsLoto.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainApp() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmRsultatsLoto = new JFrame();
		frmRsultatsLoto.setTitle("Résultats LOTO");
		frmRsultatsLoto.setResizable(false);
		frmRsultatsLoto.setBounds(100, 100, 600, 547);
		frmRsultatsLoto.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmRsultatsLoto.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setIcon(new ImageIcon(MainApp.class.getResource("/res/loto.png")));
		lblNewLabel.setBounds(-3, 0, 603, 218);
		frmRsultatsLoto.getContentPane().add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBounds(18, 226, 302, 200);
		frmRsultatsLoto.getContentPane().add(panel);
		
		JButton btnNewButton = new JButton("XX");
		btnNewButton.setSize(100, 100);
		panel.add(btnNewButton);
	}
}
