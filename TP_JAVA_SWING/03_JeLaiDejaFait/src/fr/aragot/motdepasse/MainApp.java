package fr.aragot.motdepasse;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import javax.swing.JTextField;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JButton;
import java.awt.Insets;
import javax.swing.JPasswordField;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainApp {

	private JFrame frmMotDePasse;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainApp window = new MainApp();
					window.frmMotDePasse.setVisible(true);
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
		frmMotDePasse = new JFrame();
		frmMotDePasse.setTitle("Mot de passe");
		frmMotDePasse.setResizable(false);
		frmMotDePasse.setBounds(100, 100, 427, 157);
		frmMotDePasse.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMotDePasse.getContentPane().setLayout(null);
		
		JLabel lblTapez = new JLabel("Tapez votre mot de passe");
		lblTapez.setBounds(24, 11, 148, 14);
		frmMotDePasse.getContentPane().add(lblTapez);
		
		JButton btnVisualiser = new JButton("Visualiser");
		btnVisualiser.addActionListener(a->textField.setText(new String(passwordField.getPassword())));
		btnVisualiser.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnVisualiser.setBounds(298, 35, 89, 23);
		btnVisualiser.setMnemonic('V');
		
		frmMotDePasse.getContentPane().add(btnVisualiser);
		
		JButton btnEffacer = new JButton("Effacer");
		btnEffacer.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				textField.setText(null);
				passwordField.setText(null);
				passwordField.requestFocus();
				
			}
			
		});
		btnEffacer.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnEffacer.setBounds(298, 69, 89, 23);
		btnVisualiser.setMnemonic('E');
		frmMotDePasse.getContentPane().add(btnEffacer);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(10, 70, 244, 20);
		frmMotDePasse.getContentPane().add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setEchoChar('*');
		passwordField.setBounds(10, 36, 244, 20);
		frmMotDePasse.getContentPane().add(passwordField);
	}
}
