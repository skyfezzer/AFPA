package fr.aragot.login.dessin;

import java.awt.Cursor;

import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseTrackAdapter;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class MainApp {

	protected Shell shlApplicationDeDessin;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			MainApp window = new MainApp();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shlApplicationDeDessin.open();
		shlApplicationDeDessin.layout();
		while (!shlApplicationDeDessin.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlApplicationDeDessin = new Shell();
		shlApplicationDeDessin.addMouseTrackListener(new MouseTrackAdapter() {
			@Override
			public void mouseEnter(MouseEvent e) {
				
			}
		});
		shlApplicationDeDessin.setSize(450, 300);
		shlApplicationDeDessin.setText("Application de dessin");
		shlApplicationDeDessin.setCursor(null);
		Cursor c = new Cursor(Cursor.CROSSHAIR_CURSOR);
		

	}

}
