package EjercicioRepaso3;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;



public class EjercicioRepaso3 {


	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EjercicioRepaso3 window = new EjercicioRepaso3();
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
	public EjercicioRepaso3() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel labelEdad = new JLabel("Edad: ");
		labelEdad.setBounds(88, 74, 46, 14);
		frame.getContentPane().add(labelEdad);

		textField = new JTextField();
		textField.setBounds(184, 71, 86, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JCheckBox check = new JCheckBox("Acepto la política de privacidad");
		check.setSelected(true);
		check.setBounds(123, 179, 188, 23);
		frame.getContentPane().add(check);
		
		JButton cleanButton = new JButton("CLEAN");
		cleanButton.setBounds(305, 70, 89, 23);
		frame.getContentPane().add(cleanButton);

		KeyListener keyListen = new KeyListener() {

			
			@Override

			public void keyTyped(KeyEvent e) {

				Character c = e.getKeyChar();

				if (Character.isDigit(c) != true || (c.equals('0') && textField.getText().isEmpty())) {

					e.consume();
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
			}

			@Override
			public void keyPressed(KeyEvent e) {

				if (e.getKeyCode() == KeyEvent.VK_DOWN) {

					if (textField.getText().isEmpty()) {

						textField.setText("1");

					} else if (!textField.getText().equals("1")) {

						textField.setText(Integer.parseInt(textField.getText()) - 1 + "");
					}
				}
				if (e.getKeyCode() == KeyEvent.VK_UP) {

					if (textField.getText().isEmpty()) {

						textField.setText("1");

					} else {

						textField.setText(Integer.parseInt(textField.getText()) + 1 + "");
					}
				}
			}
		};
		textField.addKeyListener(keyListen);

	
	ActionListener action = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if (check.isSelected()== false) {
				textField.setEnabled(false);
			}
			else {
				
				textField.setEnabled(true);
			}
		}
	};
	textField.addActionListener(action);
	check.addActionListener(action);
	
	ActionListener actionBut = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			textField.setText(null);
			
		}
	};
	
	cleanButton.addActionListener(actionBut);
	}
		
}