package FCT;

import javax.swing.JPanel;

public abstract class View extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4344300847225376952L;

	protected AppController appController;

	public View(AppController appController) {

		this.appController = appController;

	}
}
