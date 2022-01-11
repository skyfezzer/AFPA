package fr.aragot.login;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.GridData;

public class FrmConnexion {

	private static FrmConnexion window;
	
	protected Shell frmConnexion;
	private Button btnAnnuler;
	private Button btnEffacer;
	private Button btnOk;
	private Label lblEntrezVotrePseudo;
	private Label lblVoiciVotrePseudo;
	private Text inputText;
	private Text outputText;
	private Composite composite;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {

		try {
			window = new FrmConnexion();
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
		frmConnexion.open();
		frmConnexion.layout();
		while (!frmConnexion.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		frmConnexion = new Shell();
		frmConnexion.setSize(296, 155);
		frmConnexion.setText("Connexion avec votre pseudo");
		frmConnexion.setLayout(new FormLayout());
		
		composite = new Composite(frmConnexion, SWT.NONE);
		composite.setLayout(new GridLayout(3, true));
		FormData fd_composite = new FormData();
		fd_composite.top = new FormAttachment(0, 10);
		fd_composite.left = new FormAttachment(0, 10);
		fd_composite.bottom = new FormAttachment(100, -10);
		fd_composite.right = new FormAttachment(100, -10);
		composite.setLayoutData(fd_composite);
		new Label(composite, SWT.NONE);
		lblEntrezVotrePseudo = new Label(composite, SWT.NONE);
		lblEntrezVotrePseudo.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, true, false, 1, 1));
		lblEntrezVotrePseudo.setSize(0, 15);
		lblEntrezVotrePseudo.setText("Entrez votre pseudo :");
		inputText = new Text(composite, SWT.BORDER);
		inputText.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		inputText.setSize(348, 21);
		
		
		btnAnnuler = new Button(composite, SWT.NONE);
		btnAnnuler.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		btnAnnuler.setSize(54, 25);
		btnAnnuler.setText("Annuler");
		
		
		btnAnnuler.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				System.exit(0);
			}
		});
		btnEffacer = new Button(composite, SWT.NONE);
		btnEffacer.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		btnEffacer.setSize(164, 25);
		
		btnEffacer.setText("Effacer");
		btnEffacer.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				FrmConnexion.getInstance().flushTextBoxes();
			}
		});
		
		btnOk = new Button(composite, SWT.NONE);
		btnOk.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		btnOk.setSize(28, 0);
		
		
		btnOk.setText("OK");
		btnOk.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				FrmConnexion.getInstance().parseText();
			}
		});
		new Label(composite, SWT.NONE);
		lblVoiciVotrePseudo = new Label(composite, SWT.NONE);
		lblVoiciVotrePseudo.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, true, false, 1, 1));
		lblVoiciVotrePseudo.setSize(0, 15);
		
		
		lblVoiciVotrePseudo.setText("Voici votre pseudo :");
		outputText = new Text(composite, SWT.BORDER);
		outputText.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		outputText.setSize(348, 21);
		
		outputText.setEditable(false);

	}
	
	protected void parseText() {
		this.outputText.setText(this.inputText.getText());
		
	}

	private void flushTextBoxes() {
		FrmConnexion.getInstance().inputText.setText("");
		FrmConnexion.getInstance().outputText.setText("");
	}

	public static FrmConnexion getInstance() {
		return window;
	}
}
