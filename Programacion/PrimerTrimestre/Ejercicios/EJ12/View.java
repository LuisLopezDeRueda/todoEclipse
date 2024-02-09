package EJ12;

import javax.swing.JPanel;
import javax.swing.JTextField;

public class View extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1002098485526788291L;
	protected JTextField textField;
	protected App12 appController;
	
	public View(App12 app) {
		appController = app;
		
		
		
	}
	public String getTexto() {
		
		return textField.getText();
		}
	public void setTexto(String msj) {
		textField.setText(msj);
	}
}
