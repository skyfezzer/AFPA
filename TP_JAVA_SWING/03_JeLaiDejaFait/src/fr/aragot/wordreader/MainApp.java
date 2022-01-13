package fr.aragot.wordreader;

import java.awt.BorderLayout;
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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.ListSelectionModel;

public class MainApp {

	private static final String FILE_PATH = "./src/res/shadock.txt";
	private JFrame frame;
	private JTextField textFieldLocation;
	private JTextPane textPane;
	private DefaultListModel<String> dlm;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainApp window = new MainApp();
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
	public MainApp() {
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
		
		textPane = new JTextPane();
		JScrollPane scrollPane = new JScrollPane(textPane);
		textPane.setFont(new Font("Consolas", Font.PLAIN, 14));
		splitPane.setRightComponent(scrollPane);
		
		dlm = new DefaultListModel<String>();
		JList<String> listWords = new JList<String>(dlm);
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
				// [.,:/\\?\\\"]
				String[] words = line.replaceAll("[.,:/'\\\\?\"]", "").toLowerCase().split("\\s+");
				for(String word : words) {
					tree.add(word);
				}
			}
			for(String s : tree) {
				dlm.addElement(s);
			}
			textPane.setText(sb.toString());
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
