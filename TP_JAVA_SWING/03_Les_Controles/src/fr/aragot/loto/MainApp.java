package fr.aragot.loto;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JRadioButton;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Insets;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.DirectoryIteratorException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainApp {

	private JFrame frmFranaiseDesJeux;
	private JButton btnn1;
	private JButton btnn2 ;
	private JButton btnn3 ;
	private JButton btnn4 ;
	private JButton btnn5 ;
	private JButton btnnb ;
	private JRadioButton rdbtnPremierTirage;
	private JLabel lblTirageDate;
	private static final String CSV_FILE_LOCATION = "./src/resources/loto_resultats.csv";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainApp window = new MainApp();
					window.frmFranaiseDesJeux.setVisible(true);
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
		frmFranaiseDesJeux = new JFrame();
		frmFranaiseDesJeux.getContentPane().setBackground(Color.WHITE);
		frmFranaiseDesJeux.setResizable(false);
		frmFranaiseDesJeux.setTitle("Fran\u00E7aise des jeux");
		frmFranaiseDesJeux.setBounds(100, 100, 387, 374);
		frmFranaiseDesJeux.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmFranaiseDesJeux.getContentPane().setLayout(null);
		
		JLabel lblLotoImg = new JLabel("");
		lblLotoImg.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLotoImg.setBounds(10, 0, 339, 130);
		lblLotoImg.setIcon(new ImageIcon(MainApp.class.getResource("/resources/loto.png")));
		frmFranaiseDesJeux.getContentPane().add(lblLotoImg);
		
		rdbtnPremierTirage = new JRadioButton("Premier Tirage");
		
		rdbtnPremierTirage.setSelected(true);
		rdbtnPremierTirage.setBackground(Color.WHITE);
		rdbtnPremierTirage.setBounds(236, 276, 119, 23);
		frmFranaiseDesJeux.getContentPane().add(rdbtnPremierTirage);
		
		JRadioButton rdbtnSecondTirage = new JRadioButton("Second Tirage");
		rdbtnSecondTirage.setBackground(Color.WHITE);
		rdbtnSecondTirage.setBounds(236, 302, 119, 23);
		frmFranaiseDesJeux.getContentPane().add(rdbtnSecondTirage);
		
		ButtonGroup group = new ButtonGroup();
		group.add(rdbtnSecondTirage);
		group.add(rdbtnPremierTirage);
		
		lblTirageDate = new JLabel("Tirage du xx/xx/xxxx");
		lblTirageDate.setBackground(Color.WHITE);
		lblTirageDate.setHorizontalAlignment(SwingConstants.CENTER);
		lblTirageDate.setFont(new Font("Consolas", Font.BOLD, 14));
		lblTirageDate.setBounds(30, 294, 200, 20);
		frmFranaiseDesJeux.getContentPane().add(lblTirageDate);
		
		btnnb = new JButton("XX");
		btnnb.setBackground(Color.WHITE);
		btnnb.setEnabled(false);
		btnnb.setBounds(257, 174, 70, 70);
		btnnb.setBorder(new RoundedBorder(22));
		btnnb.setForeground(Color.RED);
		frmFranaiseDesJeux.getContentPane().add(btnnb);
		
		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setHgap(15);
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 144, 240, 139);
		frmFranaiseDesJeux.getContentPane().add(panel);
		
		btnn2 = new JButton("XX");
		panel.add(btnn2);
		btnn2.setBackground(Color.WHITE);
		btnn2.setEnabled(false);
		btnn2.setBorder(new RoundedBorder(22));
		btnn2.setForeground(Color.BLUE);
		
		btnn3 = new JButton("XX");
		panel.add(btnn3);
		btnn3.setBackground(Color.WHITE);
		btnn3.setEnabled(false);
		btnn3.setBorder(new RoundedBorder(22));
		btnn3.setForeground(Color.BLUE);
		
		btnn1 = new JButton("XX");
		btnn1.setEnabled(false);
		panel.add(btnn1);
		btnn1.setBackground(Color.WHITE);
		btnn1.setBorder(new RoundedBorder(22));
		btnn1.setForeground(Color.BLUE);
		
		btnn4 = new JButton("XX");
		panel.add(btnn4);
		btnn4.setBackground(Color.WHITE);
		btnn4.setEnabled(false);
		btnn4.setBorder(new RoundedBorder(22));
		btnn4.setForeground(Color.BLUE);
		
		btnn5 = new JButton("XX");
		panel.add(btnn5);
		btnn5.setBackground(Color.WHITE);
		btnn5.setEnabled(false);
		btnn5.setBorder(new RoundedBorder(22));
		btnn5.setForeground(Color.BLUE);
		
		parseLotoNumbers();
		
		MouseAdapter refresher = new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				parseLotoNumbers();
			}
		};
		rdbtnPremierTirage.addMouseListener(refresher);
		rdbtnSecondTirage.addMouseListener(refresher);
		
	}
	
	
	private void parseLotoNumbers() {
		try {
			//4,5,6,7,8,9 offset : 28
			Path path = Path.of(CSV_FILE_LOCATION);
			BufferedReader in = Files.newBufferedReader(path);
			in.readLine();
			String[] tab = in.readLine().split(";");
			int offset = rdbtnPremierTirage.isSelected()?0:28;
			btnn1.setText(tab[4+offset]);
			btnn2.setText(tab[5+offset]);
			btnn3.setText(tab[6+offset]);
			btnn4.setText(tab[7+offset]);
			btnn5.setText(tab[8+offset]);
			btnnb.setText(tab[9]);
			lblTirageDate.setText("Tirage du " + tab[3]);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


	private static class RoundedBorder implements Border {
	    private int radius;
	    RoundedBorder(int radius) {
	        this.radius = radius;
	    }

	    public Insets getBorderInsets(Component c) {
	        return new Insets(this.radius+1, this.radius+1, this.radius+1, this.radius);
	    }

	    public boolean isBorderOpaque() {
	        return true;
	    }

	    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
	        g.drawRoundRect(x, y, width-1, height-1, radius, radius);
	    }
	}
}


