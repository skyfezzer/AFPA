package fr.aragot.wordreader;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.TreeSet;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.ListSelectionModel;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FinalMainApp {

	private final class WordActionListener implements ActionListener {
		private final JList<String> listWords;

		private WordActionListener(JList<String> listWords) {
			this.listWords = listWords;
		}

		public void actionPerformed(ActionEvent e) {
			searchWord();
		}

		private void searchWord() {
			if(listWords.getSelectedValue() == null) {
				JOptionPane.showMessageDialog(null, "Veuillez sélectionner un mot à chercher.");
				return;
			}
			Highlighter.HighlightPainter painter = 
				    new DefaultHighlighter.DefaultHighlightPainter( Color.yellow );
			String searchWord = listWords.getSelectedValue();
			int offset = textArea.getText().toLowerCase().indexOf(searchWord);
			int length = searchWord.length();
			textArea.getHighlighter().removeAllHighlights();
			while ( offset != -1)
			{
			    try
			    {
			        textArea.getHighlighter().addHighlight(offset, offset + length, painter);
			        
			        offset = textArea.getText().toLowerCase().indexOf(searchWord, offset+1);
			    }
			    catch(BadLocationException ble) { System.out.println(ble); }
			}
		}
	}

	private static final String FILE_PATH = "./src/res/shadock.txt";
	private JFrame frame;
	private JTextField textFieldLocation;
	private JTextArea textArea;
	private DefaultListModel<String> dlm;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FinalMainApp window = new FinalMainApp();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FinalMainApp() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 496, 410);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JSplitPane splitPane = new JSplitPane();
		frame.getContentPane().add(splitPane, BorderLayout.CENTER);
		
		textArea = new JTextArea();
		JScrollPane scrollPane = new JScrollPane(textArea);
		textArea.setFont(new Font("Consolas", Font.PLAIN, 14));
		splitPane.setRightComponent(scrollPane);
		
		dlm = new DefaultListModel<String>();
		JList<String> listWords = new JList<String>(dlm);
		listWords.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount()==2) {
					new WordActionListener(listWords).searchWord();
				}
			}
		});
		listWords.setVisibleRowCount(32);
		listWords.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		splitPane.setLeftComponent(new JScrollPane(listWords));
		splitPane.setResizeWeight(0.2);
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.SOUTH);
		panel.setLayout(new BorderLayout(0, 0));
		
		textFieldLocation = new JTextField();
		panel.add(textFieldLocation, BorderLayout.CENTER);
		textFieldLocation.setColumns(10);
		
		JButton btnLocation = new JButton("Ouvrir");
		panel.add(btnLocation, BorderLayout.EAST);
		
		JPanel topPanel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) topPanel.getLayout();
		flowLayout.setAlignment(FlowLayout.TRAILING);
		frame.getContentPane().add(topPanel, BorderLayout.NORTH);
		
		JLabel lblRecherche = new JLabel("Recherche du mot");
		topPanel.add(lblRecherche);
		
		JButton btnNewButton = new JButton("Chercher");
		btnNewButton.addActionListener(new WordActionListener(listWords));
		topPanel.add(btnNewButton);
		
		parseFile(FILE_PATH);
	}

	private void parseFile(String filePath) {
		Path path = Path.of(filePath);
		try {
			TreeSet<String> tree = new TreeSet<String>();
			StringBuffer sb = new StringBuffer();
			BufferedReader br = Files.newBufferedReader(path);
			while(br.ready()) {
				String line = br.readLine();
				sb.append(line+"\n");
				String[] words = line.replaceAll("[.,:/'\\\\?\"]", "").toLowerCase().split("\\s+");
				for(String word : words) {
					tree.add(word);
				}
			}
			for(String s : tree) {
				dlm.addElement(s);
			}
			textArea.setText(sb.toString());
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
