package fr.aragot.loto;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Popup;
import javax.swing.PopupFactory;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class DatePicker extends JPanel {

	private static final long serialVersionUID = 1L;

	protected boolean controlsOnTop;
	protected boolean removeOnDaySelection;

	protected Calendar currentDisplayDate;

	protected JButton prevMonth;
	protected JButton nextMonth;
	protected JButton prevYear;
	protected JButton nextYear;

	protected JTextField textField;

	protected List<ActionListener> popupListeners = new ArrayList<ActionListener>();

	protected Popup popup;

	protected SimpleDateFormat dayName = new SimpleDateFormat("d");
	protected SimpleDateFormat monthName = new SimpleDateFormat("MMMM");

	protected String iconFile = "datepicker.gif";
	protected String[] weekdayNames = { "Lun", "Mar", "Mer", "Jeu", "Ven", "Sam", "Dim" };

	public DatePicker() {
		super();
		Locale.setDefault(Locale.FRENCH);
		currentDisplayDate = Calendar.getInstance();
		controlsOnTop = true;
		removeOnDaySelection = true;
		createPanel();
	}

	public DatePicker(Calendar date) {
		super();
		setDate(date);
		controlsOnTop = true;
		removeOnDaySelection = true;
		createPanel();
	}

	public DatePicker(int month, int day, int year) {
		super();
		setDate(month, day, year);
		controlsOnTop = true;
		removeOnDaySelection = true;
		createPanel();
	}

	public void setDate(String date) {
		currentDisplayDate = Calendar.getInstance();
		editDate(date);
	}

	public void setDate(Calendar date) {
		currentDisplayDate = date;
		createPanel();
		validate();
		repaint();
	}

	public void setDate(int month, int day, int year) {
		currentDisplayDate = Calendar.getInstance();
		currentDisplayDate.set(expandYear(year), month - 1, day);
		createPanel();
		validate();
		repaint();
	}

	protected int expandYear(int year) {
		if (year < 100) { // 2 digit year
			int currentYear = Calendar.getInstance().get(Calendar.YEAR);
			int current2DigitYear = currentYear % 100;
			int currentCentury = currentYear / 100 * 100;
			// set 2 digit year range +20 / -80 from current year
			int high2DigitYear = (current2DigitYear + 20) % 100;
			if (year <= high2DigitYear) {
				year += currentCentury;
			} else {
				year += (currentCentury - 100);
			}
		}
		return year;
	}

	public void setControlsOnTop(boolean flag) {
		controlsOnTop = flag;
		createPanel();
		validate();
		repaint();
	}

	public void setRemoveOnDaySelection(boolean flag) {
		removeOnDaySelection = flag;
	}

	public Popup getPopup(Container c) {
		if (popup == null) {
			Point p = c.getLocation();
			PopupFactory factory = PopupFactory.getSharedInstance();
			popup = factory.getPopup(c, this, p.x, p.y);
		}
		return popup;
	}

	public void popupShow(Container c) {
		getPopup(c);
		popup.show();
	}

	public void popupHide() {
		popup.hide();
	}

	public Calendar getCalendarDate() {
		return currentDisplayDate;
	}

	public Date getDate() {
		return currentDisplayDate.getTime();
	}

	public String getFormattedDate() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		return sdf.format(getDate());
		//return String.format(Integer.toString(getDay()),"%02d") + "/" + Integer.toString(getMonth()) + "/" + Integer.toString(getYear());
	}

	public int getMonth() {
		return currentDisplayDate.get(Calendar.MONTH) + 1;
	}

	public int getDay() {
		return currentDisplayDate.get(Calendar.DAY_OF_MONTH);
	}

	public int getYear() {
		return currentDisplayDate.get(Calendar.YEAR);
	}

	public ImageIcon getImage() {
		return createImageIcon(iconFile, "Calendar date picker");
	}

	/*
	 * Returns an ImageIcon, or null if the path was invalid.
	 */
	protected ImageIcon createImageIcon(String path, String description) {
		ImageIcon icon = new ImageIcon("./src/res/datepicker.gif", description);
		return icon;
	}

	protected void createPanel() {
		removeAll();
		setBorder(BorderFactory.createLineBorder(Color.black, 3));
		setFocusable(true);
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		if (controlsOnTop) {
			add(createControls());
			add(createCalendar());
		} else {
			add(createCalendar());
			add(createControls());
		}
		Dimension d = getPreferredSize();
		setPreferredSize(new Dimension(d.width, d.height + 8));
	}

	protected JPanel createControls() {
		JPanel c = new JPanel();
		c.setBorder(BorderFactory.createRaisedBevelBorder());
		c.setFocusable(true);
		c.setLayout(new FlowLayout(FlowLayout.CENTER));

		prevYear = new JButton("<<");
		c.add(prevYear);
		prevYear.setMargin(new Insets(0, 0, 0, 0));
		prevYear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				addYear(-1);
			}
		});

		prevMonth = new JButton("<");
		c.add(prevMonth);
		prevMonth.setMargin(new Insets(0, 0, 0, 0));
		prevMonth.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				addMonth(-1);
			}
		});

		textField = new JTextField(getFormattedDate(), 10);
		c.add(textField);
		textField.setEditable(true);
		textField.setEnabled(true);
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editDate(textField.getText());
			}
		});

		nextMonth = new JButton(">");
		c.add(nextMonth);
		nextMonth.setMargin(new Insets(0, 0, 0, 0));
		nextMonth.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				addMonth(+1);
			}
		});

		nextYear = new JButton(">>");
		c.add(nextYear);
		nextYear.setMargin(new Insets(0, 0, 0, 0));
		nextYear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				addYear(+1);
			}
		});

		return c;
	}

	protected JPanel createCalendar() {
		JPanel x = new JPanel();
		GridBagLayout gridbag = new GridBagLayout();
		GridBagConstraints c = new GridBagConstraints();

		x.setFocusable(true);
		x.setLayout(gridbag);

		String month = monthName.format(currentDisplayDate.getTime());
		String year = Integer.toString(getYear());

		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 7;
		c.gridheight = 1;
		JLabel title = new JLabel(month + " " + year);
		x.add(title, c);
		Font font = title.getFont();
//        Font titleFont = new Font(font.getName(), font.getStyle(),
//              font.getSize() + 2);
		Font weekFont = new Font(font.getName(), font.getStyle(), font.getSize() - 2);
		title.setFont(font);

		c.gridy = 1;
		c.gridwidth = 1;
		c.gridheight = 1;
		for (c.gridx = 0; c.gridx < 7; c.gridx++) {
			JLabel label = new JLabel(weekdayNames[c.gridx]);
			x.add(label, c);
			label.setFont(weekFont);
		}

		Calendar draw = (Calendar) currentDisplayDate.clone();
		draw.set(Calendar.DATE, 1);
		draw.add(Calendar.DATE, -draw.get(Calendar.DAY_OF_WEEK) + 2);
		int monthInt = currentDisplayDate.get(Calendar.MONTH);

		c.gridwidth = 1;
		c.gridheight = 1;
		int width = getFontMetrics(weekFont).stringWidth(" Mer ");
		int width1 = getFontMetrics(weekFont).stringWidth("Mer");
		int height = getFontMetrics(weekFont).getHeight() + (width - width1);

		for (c.gridy = 2; c.gridy < 8; c.gridy++) {
			for (c.gridx = 0; c.gridx < 7; c.gridx++) {
				JButton dayButton;
				if (draw.get(Calendar.MONTH) == monthInt) {
					String dayString = dayName.format(draw.getTime());
					if (draw.get(Calendar.DAY_OF_MONTH) < 10)
						dayString = "0" + dayString;
					dayButton = new JButton(dayString);
					if (draw.get(Calendar.DAY_OF_WEEK) != 2 &&draw.get(Calendar.DAY_OF_WEEK) != 4 && draw.get(Calendar.DAY_OF_WEEK) != 7) {
						dayButton.setEnabled(false);
					}
					if(draw.getTime().after(Date.from(Instant.now()))) {
						dayButton.setEnabled(false);
					}

				} else {
					dayButton = new JButton();
					dayButton.setEnabled(false);
				}
				x.add(dayButton, c);
				Color color = dayButton.getBackground();
				if ((draw.get(Calendar.DAY_OF_MONTH) == getDay()) && (draw.get(Calendar.MONTH) == monthInt)) {
					dayButton.setBackground(Color.yellow);
//                  dayButton.setFocusPainted(true);
//                  dayButton.setSelected(true);
				} else
					dayButton.setBackground(color);
				dayButton.setFont(weekFont);
				dayButton.setFocusable(true);
				dayButton.setPreferredSize(new Dimension(width, height));
				dayButton.setMargin(new Insets(0, 0, 0, 0));
				dayButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						changeDay(e.getActionCommand());
					}

				});
				draw.add(Calendar.DATE, +1);
			}
//          if (draw.get(Calendar.MONTH) != monthInt) break;
		}
		return x;
	}

	public void addMonth(int month) {
		currentDisplayDate.add(Calendar.MONTH, month);
		createPanel();
		validate();
		repaint();
	}

	public void addYear(int year) {
		currentDisplayDate.add(Calendar.YEAR, year);
		createPanel();
		validate();
		repaint();
	}

	public void editDate(String date) {
		parseDate(date);
		createPanel();
		validate();
		repaint();
	}

	protected void parseDate(String date) {
		String[] parts = date.split("/");
		if (parts.length == 3) {
			currentDisplayDate.set(Calendar.DAY_OF_MONTH, Integer.valueOf(parts[0]) - 1);
			currentDisplayDate.set(Calendar.MONTH, Integer.valueOf(parts[1]));
			currentDisplayDate.set(Calendar.YEAR, expandYear(Integer.valueOf(parts[2])));
		} else if (parts.length == 2) {
			currentDisplayDate = Calendar.getInstance();
			currentDisplayDate.set(Calendar.DAY_OF_MONTH, Integer.valueOf(parts[0]) - 1);
			currentDisplayDate.set(Calendar.MONTH, Integer.valueOf(parts[1]));
		} else {
			// invalid date
			currentDisplayDate = Calendar.getInstance();
		}
	}

	public void changeDay(String day) {
		currentDisplayDate.set(Calendar.DAY_OF_MONTH, Integer.valueOf(day.trim()));
		if (removeOnDaySelection) {
			firePopupEvent(new ActionEvent(this, 1, "hide"));
			popup = null;
		} else {
			createPanel();
			validate();
			repaint();
		}
	}

	public void addPopupListener(ActionListener l) {
		popupListeners.add(l);
	}

	public void removePopupListener(ActionListener l) {
		popupListeners.remove(l);
	}

	public void firePopupEvent(ActionEvent e) {
		for (int i = popupListeners.size() - 1; i >= 0; i--) {
			ActionListener l = popupListeners.get(i);
			l.actionPerformed(e);
		}
	}

	public static void main(String[] args) {
		final JFrame frame = new JFrame("Date Picker");
		Container pane = frame.getContentPane();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setPreferredSize(new Dimension(450, 250));
		pane.setLayout(new FlowLayout(FlowLayout.LEFT));
		final JTextField testDate = new JTextField(10);
		pane.add(testDate);
		final DatePicker dp = new DatePicker();
		ImageIcon ii = dp.getImage();
//      System.out.println(ii.getIconWidth());
//      System.out.println(ii.getIconHeight());
		final JButton datePicker = new JButton(ii);
		pane.add(datePicker);
		datePicker.setPreferredSize(new Dimension(30, 24));
		datePicker.setMargin(new Insets(0, 0, 0, 0));
		datePicker.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dp.setDate(testDate.getText());
				dp.popupShow(datePicker);
			}
		});
		dp.addPopupListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				testDate.setText(dp.getFormattedDate());
				dp.popupHide();
			}
		});
		frame.pack();
		frame.setFocusable(true);
		frame.setResizable(true);
		frame.setVisible(true);
	}
}