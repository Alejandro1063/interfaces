package Ejercicio14;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import javax.swing.JTextField;
import javax.swing.JLabel;


public class Pantalla1 extends View {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1333519284598441100L;
	private JTextField textField;

	public Pantalla1(AppController ap) {

		super(ap);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Pantalla 1");
		lblNewLabel.setBounds(177, 25, 86, 14);
		add(lblNewLabel);

		textField = new JTextField();
		textField.setBounds(159, 64, 86, 20);

		add(textField);
		textField.setColumns(10);

		JButton btnNewButton = new JButton("Ir a boton 1");
		btnNewButton.setBounds(159, 124, 89, 23);
		add(btnNewButton);
		btnNewButton.setEnabled(false);

		JButton btnNewButton_1 = new JButton("Ir a boton 2");
		btnNewButton_1.setBounds(159, 177, 89, 23);

		btnNewButton_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ap.irAPantalla2(textField.getText());

			}
		});
		add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("Ir a boton 3");
		btnNewButton_2.setBounds(156, 237, 89, 23);

		btnNewButton_2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ap.irAPantalla3(textField.getText());

			}
		});

		add(btnNewButton_2);

	}

	public void setMensaje(String mensaje) {
		textField.setText(mensaje);

	}

	public void cambiarTexto(String texto) {
		textField.setText(texto);
	}
}
