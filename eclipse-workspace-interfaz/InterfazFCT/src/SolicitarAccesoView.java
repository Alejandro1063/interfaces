import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextField;

import ceu_fct.modelo.Usuario;

import javax.swing.JComboBox;
import javax.swing.JPasswordField;

public class SolicitarAccesoView extends View {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8899039715388880447L;
	private JLabel emailLabel;
	private JLabel contraseñaLabel;
	private JLabel repetirLabel;
	private JLabel nombreLabel;
	private JLabel apellidosLabel;
	private JLabel cicloLabel;
	private JButton aceptarButton;
	private JButton cancelarButton;
	private JComboBox<String> cicloComboBox;

	public SolicitarAccesoView(AppController app) {
		super(app);

		setLayout(null);

		emailLabel = new JLabel("Email:");
		emailLabel.setBounds(183, 35, 46, 14);
		add(emailLabel);

		 contraseñaLabel = new JLabel("Contraseña:");
		contraseñaLabel.setBounds(183, 91, 104, 14);
		add(contraseñaLabel);

		emailTextField = new JTextField();
		emailTextField.setBounds(168, 60, 119, 20);
		add(emailTextField);
		emailTextField.setColumns(10);

		 repetirLabel = new JLabel("Repetir contraseña:");
		repetirLabel.setBounds(183, 147, 131, 14);
		add(repetirLabel);

		nombreLabel = new JLabel("Nombre:");
		nombreLabel.setBounds(183, 203, 46, 14);
		add(nombreLabel);

		nombreTextField = new JTextField();
		nombreTextField.setColumns(10);
		nombreTextField.setBounds(168, 228, 119, 20);
		add(nombreTextField);

		apellidosLabel = new JLabel("Apellidos:");
		apellidosLabel.setBounds(183, 259, 46, 14);
		add(apellidosLabel);

		apellidosTextField = new JTextField();
		apellidosTextField.setColumns(10);
		apellidosTextField.setBounds(168, 284, 119, 20);
		add(apellidosTextField);

		 cicloLabel = new JLabel("Ciclo formativo:");
		cicloLabel.setBounds(183, 315, 104, 14);
		add(cicloLabel);

		aceptarButton = new JButton("ACEPTAR");
		aceptarButton.setBounds(338, 355, 89, 23);
		add(aceptarButton);

		cancelarButton = new JButton("CANCELAR");
		cancelarButton.setBounds(440, 355, 89, 23);
		add(cancelarButton);

		cicloComboBox = new JComboBox<String>();
		cicloComboBox.setBounds(168, 338, 119, 22);
		cicloComboBox.addItem("DAM");
		cicloComboBox.addItem("DAW");
		cicloComboBox.addItem("ASIR");
		cicloComboBox.setSelectedIndex(-1);
		add(cicloComboBox);

		passwordField = new JPasswordField();
		passwordField.setBounds(168, 120, 119, 16);
		add(passwordField);

		passwordFieldRepetir = new JPasswordField();
		passwordFieldRepetir.setBounds(168, 176, 119, 16);
		add(passwordFieldRepetir);

		ActionListener login = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (e.getSource() == aceptarButton) {
					if (validardatos() == true){
						Usuario usuario = new Usuario();
						usuario.setEmail(emailTextField.getText());
						usuario.setPassword(passwordField.getPassword().toString());
						usuario.setNombre(nombreTextField.getText());
						usuario.setApellidos(apellidosTextField.getText());
						usuario.setCiclo(cicloComboBox.getSelectedItem().toString());
						usuario.setActivo(true);
						
						app.altaUsuario(usuario);
						app.irALoginView();
						
						emailTextField.setText("");
						passwordField.setText("");
						nombreTextField.setText("");
						apellidosTextField.setText("");
						cicloComboBox.setSelectedIndex(-1);
					} else {

						String error = "Error al introducir los datos.";

						JOptionPane.showMessageDialog(null, error);

					}

				}
				if (e.getSource() == cancelarButton) {
					
					app.irALoginView();
				}
			}

		};
		aceptarButton.addActionListener(login);
		cancelarButton.addActionListener(login);
	}
	public Boolean validardatos() {
		
		if (String.valueOf(passwordField.getPassword()).equals(
				String.valueOf(passwordFieldRepetir.getPassword())) && !emailLabel.getText().isEmpty()
				&& !contraseñaLabel.getText().isEmpty() && !repetirLabel.getText().isEmpty()
				&& !nombreLabel.getText().isEmpty() && !apellidosLabel.getText().isEmpty()
				&& cicloComboBox.getSelectedItem() != null) {
			return true;
		} else {

			String error = "Error al introducir los datos.";

			JOptionPane.showMessageDialog(null, error);
			return false;
		}

	}
	

	/**
	 * 
	 */
	private JTextField emailTextField;
	private JTextField nombreTextField;
	private JTextField apellidosTextField;
	private JPasswordField passwordField;
	private JPasswordField passwordFieldRepetir;
}
