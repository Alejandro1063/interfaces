import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPasswordField;

public class LoginView extends View {

	private String pass;
	
	public LoginView(AppController appController) {
		super(appController);
		setLayout(null);
		
		JLabel emailLabel = new JLabel("Email:");
		emailLabel.setBounds(83, 79, 46, 14);
		add(emailLabel);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setBounds(76, 104, 173, 20);
		add(textFieldEmail);
		textFieldEmail.setColumns(10);
		
		JLabel contraseñaLabel = new JLabel("Contraseña:");
		contraseñaLabel.setBounds(83, 137, 142, 14);
		add(contraseñaLabel);
		
		JButton buttonEntrar = new JButton("ENTRAR");
		buttonEntrar.setBounds(136, 211, 89, 23);
		add(buttonEntrar);
		
		JButton buttonSolicitarAcceso = new JButton("SOLICITAR ACCESO");
		buttonSolicitarAcceso.setBounds(210, 304, 193, 23);
		add(buttonSolicitarAcceso);
		
		
		JButton buttonSalir = new JButton("SALIR");
		buttonSalir.setBounds(424, 304, 86, 23);
		add(buttonSalir);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(83, 179, 165, 21);
		add(passwordField);
		
		String error = "Uno o los dos campos de usuario y contraseña están vacíos";
	    ActionListener login = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
		pass = new String (passwordField.getPassword());
		if(e.getSource() == buttonEntrar)
			if(!textFieldEmail.getText().isEmpty() && !pass.isEmpty()) {
				appController.iniciarSesion(textFieldEmail.getText(), pass);
			}
			else 
			JOptionPane.showMessageDialog(null, error);
			textFieldEmail.setText("");
			passwordField.setText("");
		
		if(e.getSource() ==buttonSolicitarAcceso)
		{
			appController.irASolicitarAccesoView();
		}
		if(e.getSource() == buttonSalir) {
			appController.salir();
		}
		}
		};
		buttonEntrar.addActionListener(login);
		buttonSolicitarAcceso.addActionListener(login);
		buttonSalir.addActionListener(login);
	
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 5826034887252164944L;
	private JTextField textFieldEmail;
	private JPasswordField passwordField;
}
