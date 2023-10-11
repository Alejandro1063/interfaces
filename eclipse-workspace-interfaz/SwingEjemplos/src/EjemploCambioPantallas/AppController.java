package EjemploCambioPantallas;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class AppController {

	private JFrame frame;
	
	private Pantalla1View pantalla1;
	private Pantalla2View pantalla2;
	private Pantalla3View pantalla3;

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
		
		pantalla1 = new Pantalla1View(this);
		pantalla2 = new Pantalla2View(this);
		pantalla3 = new Pantalla3View(this);
		
		irAPantalla1();
	}
	
	public void irAPantalla1() {
		frame.setContentPane(pantalla1);
		frame.revalidate();
		
	}
	public void irAPantalla2() {
		frame.setContentPane(pantalla2);
		frame.revalidate();
		
	}
	public void irAPantalla3() {
		frame.setContentPane(pantalla3);
		frame.revalidate();
		
	}
	public void login(String usuario, String pass) {
		
		System.out.println("Haciendo login...");
		System.out.println(usuario);
		System.out.println(pass);
	}
	
}
