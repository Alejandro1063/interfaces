package Ejercicio15;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class AppController {

	private JFrame frame;

	private Pantalla1 pantalla1;
	private Pantalla2 pantalla2;
	private Pantalla3 pantalla3;
	private PantallaBienvenida bien;

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
		frame.setBounds(100, 100, 590, 382);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pantalla1 = new Pantalla1(this);
		pantalla2 = new Pantalla2(this);
		pantalla3 = new Pantalla3(this);
		bien = new PantallaBienvenida(this);
		
			
		
		irAPantallaBienvenida();

		JMenuBar menuBar = new JMenuBar();

		frame.setJMenuBar(menuBar);

		JMenu menuNavegar = new JMenu("Navegar");
		menuBar.add(menuNavegar);

		JMenuItem irPantalla1 = new JMenuItem("Ir a pantalla 1");
		irPantalla1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1, 0));
		menuNavegar.add(irPantalla1);
		irPantalla1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				irAPantalla1("");
			}
		});

		JMenuItem irPantalla2 = new JMenuItem("Ir a pantalla 2");
		irPantalla2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_2, 0));
		menuNavegar.add(irPantalla2);
		irPantalla2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				irAPantalla2(null);
			}
		});

		JMenuItem irPantalla3 = new JMenuItem("Ir a pantalla 3");
		irPantalla3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_3, 0));
		menuNavegar.add(irPantalla3);
		irPantalla3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				irAPantalla3(null);
			}
		});

		JMenu menuSalir = new JMenu("Salir");
		menuBar.add(menuSalir);

		JMenuItem mntmSalir = new JMenuItem("Salir");
		mntmSalir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, 0));
		menuSalir.add(mntmSalir);
		
		JMenuItem inicioItem = new JMenuItem("Volver a inicio");
		menuSalir.add(inicioItem);
		
		ActionListener inicioListener = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				irAPantallaBienvenida();
				frame.getJMenuBar().setVisible(false);
				
			}
		};
		inicioItem.addActionListener(inicioListener);
		

		ActionListener salirListener = new ActionListener() {

			@Override

			public void actionPerformed(ActionEvent e) {

				if (JOptionPane.showConfirmDialog(mntmSalir, "Estas seguro?", "¿Salir?",

						JOptionPane.YES_NO_OPTION) != 1) {

					System.exit(0);

				} else {

				}

			}

		};
		
		mntmSalir.addActionListener(salirListener);

		frame.getJMenuBar().setVisible(false);
		
	}

	public void irAPantalla1(String mensaje) {
		frame.setContentPane(pantalla1);
		pantalla1.cambiarTexto(mensaje);
		frame.getJMenuBar().setVisible(true);
		frame.revalidate();

	}

	public void irAPantalla2(String mensaje) {
		frame.setContentPane(pantalla2);
		frame.getJMenuBar().setVisible(true);
		frame.revalidate();
		pantalla2.cambiarTexto(mensaje);
	}

	public void irAPantalla3(String mensaje) {
		frame.setContentPane(pantalla3);
		frame.getJMenuBar().setVisible(true);
		frame.revalidate();
		pantalla3.cambiarTexto(mensaje);
	}
	public void irAPantallaBienvenida() {
		frame.setContentPane(bien);
		
		frame.revalidate();
		
	}
}
