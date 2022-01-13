package fr.aragot.dessin;

import java.awt.EventQueue;
import java.awt.Component;
import java.awt.Cursor;
import javax.swing.JFrame;
import javax.swing.LookAndFeel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class MainApp {

	private JFrame frmApplicationDeDessin;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainApp window = new MainApp();
					window.frmApplicationDeDessin.setVisible(true);
					
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
		try {
			UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		frmApplicationDeDessin = new JFrame();
		frmApplicationDeDessin.setTitle("Application de dessin");
		frmApplicationDeDessin.setBounds(100, 100, 450, 300);
		frmApplicationDeDessin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmApplicationDeDessin.setCursor(Cursor.CROSSHAIR_CURSOR);
		frmApplicationDeDessin.setResizable(false);
		
		
	}

}
