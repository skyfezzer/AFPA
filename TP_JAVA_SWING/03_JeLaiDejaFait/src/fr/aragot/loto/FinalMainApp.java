package fr.aragot.loto;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.TreeMap;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class FinalMainApp {

	private static final String CSV_FILE = "./src/res/loto.csv";
	private TreeMap<String, String[]> map;
	private JFrame frmRsultatsLoto;
	private JButton btnnb;
	private JButton[] buttons = new JButton[5];
	private JRadioButton rdbtnTirage1;
	private JRadioButton rdbtnTirage2;
	private DatePicker dp;
	private JTextField textFieldDate;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FinalMainApp window = new FinalMainApp();
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
	public FinalMainApp() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmRsultatsLoto = new JFrame();
		frmRsultatsLoto.getContentPane().setBackground(Color.WHITE);
		frmRsultatsLoto.setTitle("Résultats LOTO");
		frmRsultatsLoto.setResizable(false);
		frmRsultatsLoto.setBounds(100, 100, 600, 547);
		frmRsultatsLoto.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmRsultatsLoto.getContentPane().setLayout(null);
		

		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setIcon(new ImageIcon(new ImageIcon(FinalMainApp.class.getResource("/res/loto.png")).getImage()
				.getScaledInstance(585, 200, Image.SCALE_DEFAULT)));
		lblNewLabel.setBounds(0, -3, 584, 218);
		frmRsultatsLoto.getContentPane().add(lblNewLabel);

		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setAlignOnBaseline(true);
		flowLayout.setVgap(10);
		flowLayout.setHgap(10);
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 205, 380, 220);
		frmRsultatsLoto.getContentPane().add(panel);

		btnnb = new JButton("XX");
		btnnb.setFont(new Font("Consolas", Font.BOLD, 16));
		btnnb.setBackground(Color.WHITE);
		btnnb.setForeground(Color.RED);
		btnnb.setBorder(new RoundedBorder(20));
		btnnb.setBounds(410, 226, 150, 150);
		frmRsultatsLoto.getContentPane().add(btnnb);

		JLabel lblTirage = new JLabel("Tirage du");
		lblTirage.setFont(new Font("Consolas", Font.PLAIN, 16));
		lblTirage.setBounds(102, 457, 207, 19);
		frmRsultatsLoto.getContentPane().add(lblTirage);

		rdbtnTirage1 = new JRadioButton("1er Tirage");
		rdbtnTirage1.addActionListener(x -> refreshButtons());
		rdbtnTirage1.setSelected(true);
		rdbtnTirage1.setBackground(Color.WHITE);
		rdbtnTirage1.setBounds(430, 433, 109, 23);
		frmRsultatsLoto.getContentPane().add(rdbtnTirage1);

		rdbtnTirage2 = new JRadioButton("2nd Tirage");
		rdbtnTirage2.addActionListener(x -> refreshButtons());
		rdbtnTirage2.setBackground(Color.WHITE);
		rdbtnTirage2.setBounds(430, 454, 109, 23);
		frmRsultatsLoto.getContentPane().add(rdbtnTirage2);


		textFieldDate = new JTextField(10);
		textFieldDate.setEditable(false);
		textFieldDate.setBounds(190, 454, 109, 23);
		frmRsultatsLoto.getContentPane().add(textFieldDate);
        dp = new DatePicker();
        textFieldDate.setText(dp.getFormattedDate());
        ImageIcon ii = dp.getImage();
//      System.out.println(ii.getIconWidth());
//      System.out.println(ii.getIconHeight());
        final JButton datePicker = new JButton(ii);
        datePicker.setBounds(302, 454, 38, 23);
        frmRsultatsLoto.getContentPane().add(datePicker);
        datePicker.setPreferredSize(new Dimension(30, 24));
        datePicker.setMargin(new Insets(0,0,0,0));
        datePicker.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dp.setDate(textFieldDate.getText());
                dp.popupShow(datePicker);
                datePicker.setEnabled(false);
            }
        });
        dp.addPopupListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textFieldDate.setText(dp.getFormattedDate());
                refreshButtons();
                dp.popupHide();
                datePicker.setEnabled(true);
                
            }
        });

		ButtonGroup bg = new ButtonGroup();
		bg.add(rdbtnTirage2);
		bg.add(rdbtnTirage1);

		for (int i = 0; i < 5; i++) {
			JButton button = new JButton();
			button.setBackground(Color.WHITE);
			button.setForeground(Color.BLUE);
			button.setFont(new Font("Consolas", Font.BOLD, 16));
			button.setPreferredSize(new Dimension(100, 100));
			button.setBorder(new RoundedBorder(20)); 
			panel.add(button);
			buttons[i] = button;
		}

		refreshButtons();
	}

	private void refreshButtons() {
		Path path = Path.of(CSV_FILE);
		try {
			readCsv(path);
			String selectedDate = dp.getFormattedDate();
			if(map.get(selectedDate)==null) {
				selectedDate="10/01/2022";
				textFieldDate.setText(selectedDate);
			}
			
			// 4 -> 9 offset 28
			for (int i = 0; i < 5; i++) {
				int offset = rdbtnTirage1.isSelected() ? 0 : 28;
				buttons[i].setText(map.get(selectedDate)[4 + i + offset]);
			}
			btnnb.setText(map.get(selectedDate)[9]);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void readCsv(Path path) throws IOException {
		BufferedReader br = Files.newBufferedReader(path);
		map = new TreeMap<String, String[]>();
		br.readLine();
		while(br.ready()) {
			String[] line = br.readLine().split(";");
			map.put(line[2], line);
		}
	}
}
