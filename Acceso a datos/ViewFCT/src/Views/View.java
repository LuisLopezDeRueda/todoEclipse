package Views;

import javax.swing.JPanel;

public abstract class View extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = -120508152664128693L;
	protected AppController appView;

	public View(AppController appView) {
		this.appView = appView;
	}

}
