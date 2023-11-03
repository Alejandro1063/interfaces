package FCT;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextField;

import proyectoFCT.modelo.Usuario;

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
	private String pass1;
	private String pass2;
	private JTextField emailTextField;
	private JTextField nombreTextField;
	private JTextField apellidosTextField;
	private JPasswordField passwordField;
	private JPasswordField passwordFieldRepetir;

	public SolicitarAccesoView(AppController appController) {
		super(appController);

		setLayout(null);

		emailLabel = new JLabel("Email:");
		emailLabel.setBounds(164, 35, 131, 14);
		add(emailLabel);

		contraseñaLabel = new JLabel("Contraseña:");
		contraseñaLabel.setBounds(164, 89, 131, 14);
		add(contraseñaLabel);

		emailTextField = new JTextField();
		emailTextField.setBounds(164, 59, 119, 20);
		add(emailTextField);
		emailTextField.setColumns(10);

		repetirLabel = new JLabel("Repetir contraseña:");
		repetirLabel.setBounds(164, 140, 131, 14);
		add(repetirLabel);

		nombreLabel = new JLabel("Nombre:");
		nombreLabel.setBounds(164, 190, 131, 14);
		add(nombreLabel);

		nombreTextField = new JTextField();
		nombreTextField.setColumns(10);
		nombreTextField.setBounds(164, 214, 119, 20);
		add(nombreTextField);

		apellidosLabel = new JLabel("Apellidos:");
		apellidosLabel.setBounds(164, 244, 131, 14);
		add(apellidosLabel);

		apellidosTextField = new JTextField();
		apellidosTextField.setColumns(10);
		apellidosTextField.setBounds(164, 268, 119, 20);
		add(apellidosTextField);

		cicloLabel = new JLabel("Ciclo formativo:");
		cicloLabel.setBounds(179, 298, 116, 14);
		add(cicloLabel);

		aceptarButton = new JButton("ACEPTAR");
		aceptarButton.setBounds(317, 355, 105, 23);
		add(aceptarButton);

		cancelarButton = new JButton("CANCELAR");
		cancelarButton.setBounds(440, 355, 105, 23);
		add(cancelarButton);

		cicloComboBox = new JComboBox<String>();
		cicloComboBox.setBounds(164, 322, 119, 22);
		cicloComboBox.addItem("DAM");
		cicloComboBox.addItem("DAW");
		cicloComboBox.addItem("ASIR");
		cicloComboBox.setSelectedIndex(-1);
		add(cicloComboBox);

		passwordField = new JPasswordField();
		passwordField.setBounds(164, 113, 119, 17);
		add(passwordField);

		passwordFieldRepetir = new JPasswordField();
		passwordFieldRepetir.setBounds(164, 164, 119, 16);
		add(passwordFieldRepetir);

		ActionListener login = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				pass1 = new String(passwordField.getPassword());
				pass2 = new String(passwordFieldRepetir.getPassword());

				if (e.getSource() == aceptarButton) {
					if (validardatos() == true) {
						Usuario usuario = new Usuario();
						usuario.setEmail(emailTextField.getText());
						usuario.setPassword(pass1);
						usuario.setNombre(nombreTextField.getText());
						usuario.setApellidos(apellidosTextField.getText());
						usuario.setCiclo(cicloComboBox.getSelectedItem().toString());
						usuario.setActivo(true);
						if (appController.altaUsuario(usuario) == true) {

							limpiarDatos();

							JOptionPane.showMessageDialog(null, "Usuario insertado correctamente");

							appController.irALoginView();
						} else {
							limpiarDatos();
						}

					}

				}
				if (e.getSource() == cancelarButton) {

					limpiarDatos();

					appController.irALoginView();
				}
			}

		};
		aceptarButton.addActionListener(login);
		cancelarButton.addActionListener(login);
	}

	/**
	 * Método que asigna valores vacíos a todos los campos de la clase
	 */
	public void limpiarDatos() {
		emailTextField.setText("");
		passwordField.setText("");
		nombreTextField.setText("");
		apellidosTextField.setText("");
		passwordFieldRepetir.setText("");
		cicloComboBox.setSelectedIndex(-1);
	}

	/**
	 * Método que comprueba si las contraseñas son iguales en los dos passwordField,
	 * y que todos los campos de l aclase tienen algún dato introducido.
	 * 
	 * @return devuelve true si todo está correcto, y false si hay algún error.
	 */
	public Boolean validardatos() {
		if (!pass1.equals(pass2)) {
			JOptionPane.showMessageDialog(aceptarButton, "Las contraseñas no son iguales", "ERROR",
					JOptionPane.ERROR_MESSAGE);
			limpiarDatos();
			return false;
		} else if (!emailLabel.getText().isEmpty() && !contraseñaLabel.getText().isEmpty()
				&& !repetirLabel.getText().isEmpty() && !nombreLabel.getText().isEmpty()
				&& !apellidosLabel.getText().isEmpty() && cicloComboBox.getSelectedItem() != null) {
			return true;
		} else {

			String error = "Error al introducir los datos.";

			JOptionPane.showMessageDialog(null, error);
			limpiarDatos();

			return false;
		}

	}

	/**
	 * 
	 */

}
