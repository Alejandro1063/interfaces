package EjemploCambioPantallas;
import javax.swing.JLabel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Pantalla1View extends View{
	
	
	public Pantalla1View(AppController ap) {
		super(ap);
		
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Pantalla1");
		lblNewLabel.setBounds(143, 126, 217, 14);
		add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Ir a pantalla 2");
		btnNewButton.setBounds(278, 174, 125, 23);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Login");
		btnNewButton_1.setBounds(41, 201, 89, 23);
		btnNewButton_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String user = textField.getText();
				String pass = new String(passwordField.getPassword());
				ap.login(user, pass);
				
			}
		});
		add(btnNewButton_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(36, 175, 104, 20);
		add(passwordField);
		
		textField = new JTextField();
		textField.setBounds(44, 146, 86, 20);
		add(textField);
		textField.setColumns(10);
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ap.irAPantalla2();
				
			}
		});
		
		
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 5430617681923355797L;
	private JPasswordField passwordField;
	private JTextField textField;
}
