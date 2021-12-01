package fr.afpa.util;

import java.awt.BorderLayout;
import java.awt.*;
import java.awt.event.*;
import java.math.BigDecimal;
import javax.swing.*;

import fr.afpa.math.Math;

public class Convertisseur extends JFrame{
	private JFrame mainFrame;
	private JPanel panel;
	private JTextField dollarTF, euroTF;
	private JButton toDollarButton, toEuroButton;
	public Convertisseur() {
		prepareGUI();
		
	}
	
	public static void main(String[] args) {
		Convertisseur c = new Convertisseur();
		c.mainFrame.setVisible(true);
		
	}
	
	private void prepareGUI() {
		mainFrame = new JFrame("Convertisseur Euro/Dollar");
		mainFrame.setSize(250,250);
		//c.setVisible(true);
		mainFrame.setResizable(false);
		mainFrame.setLayout(new GridLayout(0,1));
		
		
		panel = new JPanel();
		panel.setLayout(new BorderLayout());
		JPanel euroPanel = new JPanel();
		euroPanel.setLayout(new BorderLayout());
		JPanel dollarPanel = new JPanel();
		dollarPanel.setLayout(new BorderLayout());
		
		
		
		dollarTF = new JTextField();
		dollarTF.setHorizontalAlignment(JTextField.CENTER);
		dollarTF.setColumns(8);
		euroTF = new JTextField();
		euroTF.setHorizontalAlignment(JTextField.CENTER);
		euroTF.setColumns(8);
		
		Font bigFont = dollarTF.getFont().deriveFont(Font.PLAIN, 24f);
		dollarTF.setFont(bigFont);
		euroTF.setFont(bigFont);
		
		
		panel.add(toDollarButton = new JButton("Vers Euros"),BorderLayout.NORTH); 
		panel.add(toEuroButton = new JButton("Vers Dollars"),BorderLayout.SOUTH);
		dollarPanel.add(new JLabel("Euros :"));
		dollarPanel.add(dollarTF,BorderLayout.EAST);
		mainFrame.add(euroPanel);
		mainFrame.add(panel);
		euroPanel.add(new JLabel("Dollars :"));
		euroPanel.add(euroTF,BorderLayout.EAST);
		mainFrame.add(dollarPanel);
		mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		toEuroButton.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent ev){  
		           try{
		        	   euroTF.setText(Math.dollarToEuro(new BigDecimal(dollarTF.getText())).toString());;  
		           }catch(NumberFormatException ex) {
		        	   JOptionPane.showMessageDialog(null,"Erreur dans la conversion : Vérifiez les valeurs.");
		           }
		}  
		});
		
		toDollarButton.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent ev){  
		           try{
		        	   dollarTF.setText(Math.euroToDollar(new BigDecimal(euroTF.getText())).toString());;  
		           }catch(NumberFormatException ex) {
		        	   JOptionPane.showMessageDialog(null,"Erreur dans la conversion : Vérifiez les valeurs.");
		           }
		}  
		});
	}
	

	
	
	
}

