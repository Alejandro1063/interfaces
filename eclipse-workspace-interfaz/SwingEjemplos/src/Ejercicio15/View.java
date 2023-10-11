package Ejercicio15;

import javax.swing.JPanel;

public abstract class View extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8301692346736170955L;
	private View pantallaActual;
	
protected AppController app;
	
	public View(AppController ap) {
		this.app = ap;
		
	}

	public View getPantallaActual() {
		return pantallaActual;
	}

	public void setPantallaActual(View pantallaActual) {
		this.pantallaActual = pantallaActual;
	}
	
	
}
