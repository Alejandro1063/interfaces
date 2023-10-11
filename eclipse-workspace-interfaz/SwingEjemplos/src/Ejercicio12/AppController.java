package Ejercicio12;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class AppController {

	private JFrame frame;

	private Pantalla1 pantalla1;
	private Pantalla2 pantalla2;
	private Pantalla3 pantalla3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppController window = new AppController();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AppController() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pantalla1 = new Pantalla1(this);
		pantalla2 = new Pantalla2(this);
		pantalla3 = new Pantalla3(this);
		irAPantalla1("");
	}

	public void irAPantalla1(String mensaje) {
		frame.setContentPane(pantalla1);
		pantalla1.setMensaje(mensaje);
		frame.revalidate();

	}

	public void irAPantalla2(String mensaje) {
		frame.setContentPane(pantalla2);
		frame.revalidate();
		pantalla2.setMensaje(mensaje);
	}

	public void irAPantalla3(String mensaje) {
		frame.setContentPane(pantalla3);
		frame.revalidate();
		pantalla3.setMensaje(mensaje);
	}

}