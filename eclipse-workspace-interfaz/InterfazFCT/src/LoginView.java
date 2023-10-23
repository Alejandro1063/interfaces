import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPasswordField;

public class LoginView extends View {

	public LoginView(AppController app) {
		super(app);
		setLayout(null);
		
		JLabel EmailLabel = new JLabel("Email:");
		EmailLabel.setBounds(83, 79, 46, 14);
		add(EmailLabel);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setBounds(76, 104, 173, 20);
		add(textFieldEmail);
		textFieldEmail.setColumns(10);
		
		JLabel ContraseñaLabel = new JLabel("Contraseña:");
		ContraseñaLabel.setBounds(83, 137, 142, 14);
		add(ContraseñaLabel);
		
		JButton ButtonEntrar = new JButton("ENTRAR");
		ButtonEntrar.setBounds(136, 211, 89, 23);
		add(ButtonEntrar);
		
		JButton ButtonSolicitarAcceso = new JButton("SOLICITAR ACCESO");
		ButtonSolicitarAcceso.setBounds(210, 304, 193, 23);
		add(ButtonSolicitarAcceso);
		
		
		JButton ButtonSalir = new JButton("SALIR");
		ButtonSalir.setBounds(424, 304, 86, 23);
		add(ButtonSalir);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(83, 179, 165, 21);
		add(passwordField);
	
	
	    ActionListener login = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
		if(e.getSource() == ButtonEntrar)
			app.irABienvenidaView();
		
		if(e.getSource() == ButtonSolicitarAcceso)
		{
			app.irASolicitarAccesoView();
		}
		if(e.getSource() == ButtonSalir) {
			app.salir();
		}
		}
		};
		ButtonEntrar.addActionListener(login);
		ButtonSolicitarAcceso.addActionListener(login);
		ButtonSalir.addActionListener(login);

	
	}


	/**
	 * 
	 */
	private static final long serialVersionUID = 5826034887252164944L;
	private JTextField textFieldEmail;
	private JPasswordField passwordField;
}
