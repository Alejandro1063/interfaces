package Ejercicio9;

import java.awt.EventQueue;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.Color;



public class Ejercicio9 {


	private JFrame frame;
	private JTextField textTab1;
	private JTextField textTab2;
	private JTextField textTab3;
	private JTextField textTab4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ejercicio9 window = new Ejercicio9();
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
	public Ejercicio9() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 560, 470);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		textTab1 = new JTextField();
		textTab1.setBounds(205, 71, 125, 20);
		frame.getContentPane().add(textTab1);
		textTab1.setColumns(10);

		textTab2 = new JTextField();
		textTab2.setBounds(205, 146, 125, 20);
		frame.getContentPane().add(textTab2);
		textTab2.setColumns(10);

		textTab3 = new JTextField();
		textTab3.setBounds(205, 233, 125, 20);
		frame.getContentPane().add(textTab3);
		textTab3.setColumns(10);

		textTab4 = new JTextField();
		textTab4.setBounds(205, 322, 125, 20);
		frame.getContentPane().add(textTab4);
		textTab4.setColumns(10);
		
		FocusListener focus = new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				JTextField colorChange = new JTextField();
				colorChange = (JTextField) e.getSource();
				colorChange.setBackground(new Color(255, 255, 255));
				
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				JTextField colorChange = new JTextField();
				colorChange = (JTextField) e.getSource();
				colorChange.setBackground(new Color(255, 128, 128));
			}
		};
		
		textTab1.addFocusListener(focus);
		textTab2.addFocusListener(focus);
		textTab3.addFocusListener(focus);
		textTab4.addFocusListener(focus);
		
		KeyListener keyListen = new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {

			}

			@Override
			public void keyReleased(KeyEvent e) {

			}

			@Override
			public void keyPressed(KeyEvent e) {

				if (e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_ENTER) {
					JTextField transferT = new JTextField();
					transferT = (JTextField) e.getSource();
					transferT.transferFocus();
				}
				
				if (e.getKeyCode() == KeyEvent.VK_UP ) {
					JTextField transferT = new JTextField();
					transferT = (JTextField) e.getSource();
					transferT.transferFocusBackward();
				}
				
				
			}

		};
		textTab1.addKeyListener(keyListen);
		textTab2.addKeyListener(keyListen);
		textTab3.addKeyListener(keyListen);
		textTab4.addKeyListener(keyListen);

		
	}
	
	}