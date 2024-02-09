package Ejemplo;

import javax.swing.JPanel;

public class View extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1002098485526788291L;
	
	protected App appController;
	
	public View(App app) {
		appController = app;
	}
}
