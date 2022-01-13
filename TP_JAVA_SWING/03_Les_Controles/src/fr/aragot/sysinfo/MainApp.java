package fr.aragot.sysinfo;

import java.awt.EventQueue;
import java.net.Inet4Address;
import java.net.UnknownHostException;
import java.util.Properties;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JTextField;

public class MainApp {

	private JFrame frmInformationsSystme;
	private JTextField tfNomMachine;
	private JTextField tfIP;
	private JTextField tfUtilisateur;
	private JTextField tfOS;
	private JTextField tfVM;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainApp window = new MainApp();
					window.frmInformationsSystme.setVisible(true);
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
		frmInformationsSystme = new JFrame();
		frmInformationsSystme.setResizable(false);
		frmInformationsSystme.setTitle("Propri\u00E9t\u00E9s syst\u00E8me");
		frmInformationsSystme.setBounds(100, 100, 415, 196);
		frmInformationsSystme.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmInformationsSystme.getContentPane().setLayout(null);
		
		JLabel lblJavaImg = new JLabel("");
		lblJavaImg.setHorizontalAlignment(SwingConstants.CENTER);
		lblJavaImg.setIcon(new ImageIcon(MainApp.class.getResource("/resources/javalogo.gif")));
		lblJavaImg.setBounds(0, 0, 86, 157);
		frmInformationsSystme.getContentPane().add(lblJavaImg);
		
		JLabel lblNomMachine = new JLabel("Nom de la machine :");
		lblNomMachine.setBounds(59, 11, 96, 14);
		frmInformationsSystme.getContentPane().add(lblNomMachine);
		
		JLabel lblNewLabel = new JLabel("Utilisateur :");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(59, 71, 96, 14);
		frmInformationsSystme.getContentPane().add(lblNewLabel);
		
		JLabel lblAdresseIp = new JLabel("Adresse IP :");
		lblAdresseIp.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAdresseIp.setBounds(59, 41, 96, 14);
		frmInformationsSystme.getContentPane().add(lblAdresseIp);
		
		JLabel lblOSName = new JLabel("Nom de l'OS :");
		lblOSName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblOSName.setBounds(59, 102, 96, 14);
		frmInformationsSystme.getContentPane().add(lblOSName);
		
		JLabel lblMachineVirtuelle = new JLabel("Machine virtuelle :");
		lblMachineVirtuelle.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMachineVirtuelle.setBounds(59, 135, 96, 14);
		frmInformationsSystme.getContentPane().add(lblMachineVirtuelle);
		
		tfNomMachine = new JTextField();
		tfNomMachine.setEditable(false);
		tfNomMachine.setBounds(161, 8, 233, 20);
		frmInformationsSystme.getContentPane().add(tfNomMachine);
		tfNomMachine.setColumns(10);
		
		tfIP = new JTextField();
		tfIP.setEditable(false);
		tfIP.setColumns(10);
		tfIP.setBounds(161, 38, 233, 20);
		frmInformationsSystme.getContentPane().add(tfIP);
		
		tfUtilisateur = new JTextField();
		tfUtilisateur.setEditable(false);
		tfUtilisateur.setColumns(10);
		tfUtilisateur.setBounds(161, 68, 233, 20);
		frmInformationsSystme.getContentPane().add(tfUtilisateur);
		
		tfOS = new JTextField();
		tfOS.setEditable(false);
		tfOS.setColumns(10);
		tfOS.setBounds(161, 99, 233, 20);
		frmInformationsSystme.getContentPane().add(tfOS);
		
		tfVM = new JTextField();
		tfVM.setEditable(false);
		tfVM.setColumns(10);
		tfVM.setBounds(161, 132, 233, 20);
		frmInformationsSystme.getContentPane().add(tfVM);
		
		
		// Once GUI is set up, fill text fields.
		fillTextBoxes();
	}

	private void fillTextBoxes() {
		try {
			tfIP.setText(Inet4Address.getLocalHost().getHostAddress());
			tfNomMachine.setText(Inet4Address.getLocalHost().getHostName());
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			tfIP.setText("ERREUR");
		}
		Properties props = System.getProperties();
		tfUtilisateur.setText(props.getProperty("user.name"));
		tfOS.setText(props.getProperty("os.name"));
		tfVM.setText(props.getProperty("java.vm.name"));
		System.out.println("test\n\n");
		props.forEach((x,y)->System.out.println(x+"="+y));
		
	}
}
