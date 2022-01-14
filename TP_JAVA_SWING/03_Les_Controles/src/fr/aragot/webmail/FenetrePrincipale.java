package fr.aragot.webmail;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;
import javax.swing.UIManager;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.filechooser.FileNameExtensionFilter;

public class FenetrePrincipale extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1740235497903499624L;
	private JTextField textFieldSujet;
	private JButton btnEnvoyer;
	private JButton btnNouveau;
	private JButton btnOuvrir;
	private JLabel lblInfo;
	private JMenuItem mntmEnvoyer;
	private JTextArea textAreaMail;
	private Fichier fichierOuvert;
	private JComboBox<AdresseMail> comboBoxDestinataire;
	private boolean textHasChanged = false;

	public FenetrePrincipale() {
		
		addWindowListener(new QuitterListener());
		setTitle("Envoi de mails à un destinataire");
		setBounds(200, 200, 640, 480);
		setMinimumSize(new Dimension(580,200));
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			// 
			e.printStackTrace();
		}
		
		initMenus();
		initControles();
	}

	private void initMenus() {
		MenuHoverChangeListener hoverListener = new MenuHoverChangeListener();
		JMenuBar menuBar = new JMenuBar();
		menuBar.setToolTipText("");
		setJMenuBar(menuBar);

		JMenu mnMessage = new JMenu("Message");
		mnMessage.setMnemonic('M');
		menuBar.add(mnMessage);

		JMenuItem mntmNouveau = new JMenuItem("Nouveau");
		mntmNouveau.setToolTipText("Crée un nouveau message vide");
		mntmNouveau.addChangeListener(hoverListener);
		mntmNouveau.addActionListener(new NouveauMailActionListener());
		mntmNouveau.setMnemonic('N');
		mnMessage.add(mntmNouveau);

		JMenuItem mntmOuvrir = new JMenuItem("Ouvrir...");
		mntmOuvrir.setToolTipText("Ouvre un message qui a déja été envoyé");
		mntmOuvrir.addActionListener(new OuvrirMailActionListener());
		mntmOuvrir.setMnemonic('O');
		mntmOuvrir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F2, InputEvent.ALT_DOWN_MASK));
		mnMessage.add(mntmOuvrir);
		
		mnMessage.add(new JSeparator());

		mntmEnvoyer = new JMenuItem("Envoyer");
		mntmEnvoyer.setToolTipText("Envoie le message au destinataire sélectionné");
		mntmEnvoyer.setEnabled(false);
		mntmEnvoyer.setMnemonic('E');
		mnMessage.add(mntmEnvoyer);
		
		mnMessage.add(new JSeparator());

		JMenuItem mntmQuitter = new JMenuItem("Quitter");
		mntmQuitter.setToolTipText("Quitte l'application WebMail");
		mntmQuitter.addActionListener(new QuitterListener());
		mntmQuitter.setMnemonic('Q');
		mnMessage.add(mntmQuitter);

		JMenu mnOptions = new JMenu("Options");
		mnOptions.setMnemonic('O');
		menuBar.add(mnOptions);

		JMenuItem mntmParametres = new JMenuItem("Paramètres...");
		mntmParametres.setToolTipText("Ouvre un menu avec divers paramètres de l'application");
		mntmParametres.setMnemonic('P');
		mnOptions.add(mntmParametres);

		JMenu mnHelp = new JMenu("?");
		mnHelp.setMnemonic('?');
		menuBar.add(mnHelp);

		JMenuItem mntmApropos = new JMenuItem("A propos...");
		mntmApropos.setToolTipText("Affiche des informations sur l'application");
		mntmApropos.addActionListener(new AproposActionListener());
		mntmApropos.setMnemonic('A');
		mnHelp.add(mntmApropos);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		
		for(Component item : menuBar.getComponents()) {
			if(item instanceof JMenu) {
				for(Component uItem : ((JMenu) item).getMenuComponents()) {
					if(uItem instanceof JMenuItem) {
						((JMenuItem) uItem).addChangeListener(hoverListener);
					}
				}
			}
		}
		
		

	}

	private void initControles() {	
		JToolBar toolBar = new JToolBar();
		toolBar.setFloatable(false);
		getContentPane().add(toolBar, BorderLayout.NORTH);
		
		btnNouveau = new JButton();
		btnNouveau.addActionListener(new NouveauMailActionListener());
		btnNouveau.setIcon(UIManager.getIcon("FileView.fileIcon"));
		toolBar.add(btnNouveau);
		
		btnOuvrir = new JButton();
		btnOuvrir.addActionListener(new OuvrirMailActionListener());
		btnOuvrir.setIcon(UIManager.getIcon("FileView.directoryIcon"));
		toolBar.add(btnOuvrir);
		
		btnEnvoyer = new JButton();
		btnEnvoyer.setEnabled(false);
		toolBar.add(btnEnvoyer);
		btnEnvoyer.setIcon(UIManager.getIcon("FileView.computerIcon"));
		
		JPanel panel_1 = new JPanel();
		toolBar.add(panel_1);
		
		JLabel lblSujet = new JLabel("Sujet");
		
		textFieldSujet = new JTextField();
		textFieldSujet.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textFieldSujet.setColumns(20);
		
		JLabel lblPour = new JLabel("Pour");
		
		comboBoxDestinataire = new JComboBox<AdresseMail>();
		comboBoxDestinataire.setModel(new DefaultComboBoxModel<AdresseMail>(recupereContacts()));
		FlowLayout fl_panel_1 = new FlowLayout(FlowLayout.RIGHT, 5, 5);
		fl_panel_1.setAlignOnBaseline(true);
		panel_1.setLayout(fl_panel_1);
		panel_1.add(lblSujet);
		panel_1.add(textFieldSujet);
		panel_1.add(lblPour);
		panel_1.add(comboBoxDestinataire);
		
		textAreaMail = new JTextArea();
		textAreaMail.setToolTipText("Envoyer un message");		
		textAreaMail.getDocument().addDocumentListener(new BrouillonDocumentListener());
		textAreaMail.setTabSize(4);
		textAreaMail.setBorder(BorderFactory.createLineBorder(Color.black));
		
		getContentPane().add(new JScrollPane(textAreaMail), BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		getContentPane().add(panel, BorderLayout.SOUTH);
		
		lblInfo = new JLabel("Envoyer un message");
		panel.add(lblInfo);
		
		
	}

	private Vector<AdresseMail> recupereContacts() {
		Vector<AdresseMail> records = new Vector<AdresseMail>();
		String file = FenetrePrincipale.class.getClassLoader().getResource("res/contacts.csv").getPath();
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
		    String line;
		    while ((line = br.readLine()) != null) {
		        String[] values = line.split(";");
		        records.add(new AdresseMail(values[0],values[1]));
		    }
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return records;
		
	}

	private void autoriseEnvoi(boolean value) {
		this.textHasChanged = true;
		this.btnEnvoyer.setEnabled(value);
		this.mntmEnvoyer.setEnabled(value);
	}
	
	private int demandeSauvegarde() {
		if(!textHasChanged)
			return JOptionPane.NO_OPTION;
		int reply = JOptionPane.showConfirmDialog(null, "Voulez-vous enregistrer vos changements?", "Nouveau", JOptionPane.YES_NO_CANCEL_OPTION);
		if (reply == JOptionPane.YES_OPTION) {
			JFileChooser jfc = new JFileChooser("./msg");
			jfc.setFileFilter(new FileNameExtensionFilter("Mail message (.msg)", "msg"));
			jfc.setAcceptAllFileFilterUsed(false);
			int result = jfc.showSaveDialog(FenetrePrincipale.this);
			if(result == JFileChooser.APPROVE_OPTION ) {
				AdresseMail destinataire = (AdresseMail) comboBoxDestinataire.getSelectedItem();
				Fichier nvFichier = new Fichier(destinataire.getNom());
				setFichierOuvert(nvFichier);
				try {
					nvFichier.setContenu(textAreaMail.getText());
				} catch (IOException e) {
					JOptionPane.showMessageDialog(null,"Erreur survenue lors de tentative de sauvegarde.\n" + e.getMessage());
					e.printStackTrace();
				}
			}
		}	
		return reply;
	}
	
	private void loadFile(Fichier fichier) {
		this.setFichierOuvert(fichier);
		textAreaMail.setText(fichier.getContenu());
		
	}
	
	public Fichier getFichierOuvert() {
		return fichierOuvert;
	}

	public void setFichierOuvert(Fichier fichierOuvert) {
		this.fichierOuvert = fichierOuvert;
	}
	
	
	/* ===================== */
	/* ===================== */
	/* ===== LISTENERS ===== */
	/* ===================== */
	/* ===================== */
	

	


	private class MenuHoverChangeListener implements ChangeListener {
		public void stateChanged(ChangeEvent e) {
			
			if(lblInfo != null) {
				lblInfo.setText(((JMenuItem) e.getSource()).getToolTipText());
			}
		}
	}
	
	private class BrouillonDocumentListener implements DocumentListener {
		@Override
		public void removeUpdate(DocumentEvent e) {
			if(e.getDocument().getLength()==0)
				autoriseEnvoi(false);
		}

		@Override
		public void insertUpdate(DocumentEvent e) {
			autoriseEnvoi(true);
		}

		@Override
		public void changedUpdate(DocumentEvent e) {

		}
	}
	private class QuitterListener extends WindowAdapter implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			int result = FenetrePrincipale.this.demandeSauvegarde();
			if(result == JOptionPane.CANCEL_OPTION)
				return;
			System.exit(0);
		}
		@Override
		public void windowClosing(WindowEvent e) {
			actionPerformed(null);
		}
	}
	private class OuvrirMailActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JFileChooser jfc = new JFileChooser("./msg");
			int res = jfc.showOpenDialog(FenetrePrincipale.this);
			if(res==JFileChooser.APPROVE_OPTION) {
				
				jfc.getSelectedFile();
				Fichier fichier = new Fichier(jfc.getSelectedFile().getAbsolutePath());
				loadFile(fichier);
			}
		}
	}

	private class NouveauMailActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			int result = FenetrePrincipale.this.demandeSauvegarde();
			if(result == JOptionPane.CANCEL_OPTION)
				return;
			FenetrePrincipale.this.textAreaMail.setText(null);
			
		}
	}
	
	private class AproposActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(FenetrePrincipale.this, "Envoi de mails à un destinataire\nFait par Alexis RAGOT\nVersion 1.0","A Propos de WebMail", 1);
		}
	}

	
	
}
