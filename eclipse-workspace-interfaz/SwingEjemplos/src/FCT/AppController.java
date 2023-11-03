package FCT;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import proyectoFCT.exception.AutenticationException;
import proyectoFCT.exception.RegistroServiceException;
import proyectoFCT.exception.UsuarioNoExisteException;
import proyectoFCT.exception.UsuarioServiceException;
import proyectoFCT.modelo.Registro;
import proyectoFCT.modelo.Usuario;
import proyectoFCT.servicio.RegistroService;
import proyectoFCT.servicio.UsuarioService;

public class AppController {

	private JFrame frame;

	private BienvenidaView bienvenida;
	private ConsultaRegistroView consularR;
	private LoginView login;
	private NuevoRegistroView nuevoReg;
	private SolicitarAccesoView solAcceso;
	private JMenuBar menuBar;
	private JMenu menuApp;
	private JMenuItem itemCerrarSesion;
	private JMenuItem itemSalir;
	private JMenuItem menuRegistros;
	private JMenuItem itemCrearNuevoRegistro;
	private JMenuItem itemConsultarregistros;
	private Usuario user;

	public Usuario getUser() {

		return user;
	}

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
		frame.setBounds(250, 200, 694, 509);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		bienvenida = new BienvenidaView(this);
		consularR = new ConsultaRegistroView(this);
		login = new LoginView(this);
		nuevoReg = new NuevoRegistroView(this);
		solAcceso = new SolicitarAccesoView(this);

		menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 101, 22);
		frame.setJMenuBar(menuBar);

		menuApp = new JMenu("App");
		menuBar.add(menuApp);

		itemCerrarSesion = new JMenuItem("Cerrar sesión");
		menuApp.add(itemCerrarSesion);

		itemSalir = new JMenuItem("Salir");
		menuApp.add(itemSalir);

		menuRegistros = new JMenu("Registros");
		menuBar.add(menuRegistros);

		itemCrearNuevoRegistro = new JMenuItem("Crear nuevo registro");
		menuRegistros.add(itemCrearNuevoRegistro);

		itemConsultarregistros = new JMenuItem("Consultar registros");
		menuRegistros.add(itemConsultarregistros);
		nuevoReg = new NuevoRegistroView(this);
		solAcceso = new SolicitarAccesoView(this);
		irALoginView();

		ActionListener actionMenu = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (e.getSource() == itemCerrarSesion) {

					if (JOptionPane.showConfirmDialog(itemSalir, "¿Seguro que quieres cerrar sesión?",
							"¿Cerrar sesión?", JOptionPane.YES_NO_OPTION) != 1) {
						irALoginView();
					}

				}
				if (e.getSource() == itemCrearNuevoRegistro) {

					irANuevoRegistroView();
				}
				if (e.getSource() == itemSalir) {
					if (JOptionPane.showConfirmDialog(itemSalir, "¿Seguro que quieres salir?", "¿Cerrar programa?",
							JOptionPane.YES_NO_OPTION) != 1) {
						salir();
					}

				}

				if (e.getSource() == itemConsultarregistros) {

					irAConsultaRegistroView();
				}
			}

		};
		itemCerrarSesion.addActionListener(actionMenu);
		itemCrearNuevoRegistro.addActionListener(actionMenu);
		itemSalir.addActionListener(actionMenu);
		itemConsultarregistros.addActionListener(actionMenu);

	}

	/**
	 * Método que hace un cambio de ventana hacia BienvenidaView. También vuelve
	 * visible el menú.
	 */
	public void irABienvenidaView() {
		frame.setContentPane(bienvenida);
		menuBar.setVisible(true);
		bienvenida.mensajeBien();
		frame.revalidate();

	}

	/**
	 * Método que hace un cambio de ventana hacia ConsultaRegistroView.
	 */
	public void irAConsultaRegistroView() {
		frame.setContentPane(consularR);
		frame.revalidate();
	}

	/**
	 * Método para llamada hacia la bbdd con los datos de usuario y contraseña
	 * introducidos por parámetros, usando el método loginUsuario del service.
	 * También controla excepciones lanzando un popup si hay alguna excepción.
	 * 
	 * @param usuario String de usuario en la bbdd.
	 * @param contra  String de contraseña en la bbdd.
	 */
	public void iniciarSesion(String usuario, String contra) {
		UsuarioService userS = new UsuarioService();

		try {
			user = userS.loginUsuario(usuario, contra);

			irABienvenidaView();
		} catch (UsuarioNoExisteException | AutenticationException | UsuarioServiceException e) {
			String error = "Error al introducir el usuario y contraseña.";
			JOptionPane.showMessageDialog(null, error);
			e.printStackTrace();
		}

	}

	/**
	 * Método para introducir un nuevo usuario en la bbdd. También controla
	 * excepciones.
	 * 
	 * @param user Usuario completo.
	 * @return devuelve true si se ha dado de alta correctamente y false si no.
	 */
	public Boolean altaUsuario(Usuario user) {
		UsuarioService userS = new UsuarioService();
		try {
			userS.altaUsuario(user);
			return true;
		} catch (UsuarioServiceException e) {
			JOptionPane.showMessageDialog(frame, e.getMessage(), "Error de nuevo usuario", JOptionPane.ERROR_MESSAGE);
			return false;
		}
	}

	/**
	 * Método que hace un cambio de ventana hacia LoginView.
	 */
	public void irALoginView() {
		frame.setContentPane(login);
		menuBar.setVisible(false);
		frame.revalidate();
	}

	/**
	 * Método que hace un cambio de ventana hacia NuevoRegistroView.
	 */
	public void irANuevoRegistroView() {
		frame.setContentPane(nuevoReg);
		frame.revalidate();
	}

	/**
	 * Método que hace un cambio de ventana hacia SolicitarAccesoView.
	 */
	public void irASolicitarAccesoView() {
		frame.setContentPane(solAcceso);
		menuBar.setVisible(false);
		frame.revalidate();

	}

	/**
	 * Método que inserta un registro completo, y asigna al mismo el id del usuario
	 * que lo está registrando. Controla excepciones. También si el registro se ha
	 * realizado correctamente, cambia de pantalla hacia BienvenidaView.
	 * 
	 * @param reg
	 */
	public void crearNuevoRegistro(Registro reg) {

		RegistroService insertarRegis = new RegistroService();
		try {
			reg.setIdUsuario(user.getId_usuario());
			insertarRegis.insertarRegistro(reg);
			JOptionPane.showMessageDialog(frame, "Registro insertado de forma correcta", "REGISTRO INSERTADO",
					JOptionPane.INFORMATION_MESSAGE);
			irABienvenidaView();
		} catch (RegistroServiceException e) {

			JOptionPane.showMessageDialog(frame, "Ha habido algún error al insertar el registro", "ERROR",
					JOptionPane.INFORMATION_MESSAGE);
			e.printStackTrace();
		}

	}

	/**
	 * Método que cierra la aplicación
	 */
	public void salir() {

		System.exit(0);
	}

	/**
	 * Método que obtiene una lista de registros por id del usuario, y la devuelve.
	 * Control de excepciones.
	 * 
	 * @return Devuelve la lista de registros si no ha habido algún error, y si no,
	 *         devuelve null.
	 */
	public List<Registro> devolverRegis() {
		RegistroService serviRegistro = new RegistroService();

		try {
			try {
				return serviRegistro.consultarRegistrosUsuarios(user.getId_usuario());
			} catch (UsuarioNoExisteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (RegistroServiceException e) {
			JOptionPane.showMessageDialog(frame, e.getMessage(), "Error al consultar la lista de registros",
					JOptionPane.ERROR_MESSAGE);
		}
		return null;
	}
}
