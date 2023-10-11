package EjemploCambioPantallas;

import javax.swing.JPanel;

public abstract class View extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2855259171103620927L;

	protected AppController app;
	
	public View(AppController ap) {
		this.app = ap;
		
	}
}
