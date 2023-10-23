import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import ceu_fct.exception.AutenticationException;
import ceu_fct.exception.UsuarioNoExisteException;
import ceu_fct.exception.UsuarioServiceException;
import ceu_fct.modelo.Usuario;
import ceu_fct.servicio.UsuarioService;

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
		frame.setBounds(250, 200, 600, 400);
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
		// menuBar.setVisible(false);

		ActionListener actionMenu = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (e.getSource() == itemCerrarSesion) {

					irALoginView();
				}
				if (e.getSource() == itemCrearNuevoRegistro) {

					irANuevoRegistroView();
				}
				if (e.getSource() == itemSalir) {
					System.exit(0);

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

	public void irABienvenidaView() {
		frame.setContentPane(bienvenida);
		menuBar.setVisible(true);
		frame.revalidate();

	}

	public void irAConsultaRegistroView() {
		frame.setContentPane(consularR);
		frame.revalidate();
	}
	public void iniciarSesion(String usuario, String contra) {
		UsuarioService userS = new UsuarioService();
		try {
			userS.loginUsuario(usuario, contra);
		} catch (UsuarioNoExisteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (AutenticationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UsuarioServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void altaUsuario(Usuario user) {
		UsuarioService userS = new UsuarioService();
		try {
			userS.altaUsuario(user);
		} catch (UsuarioServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void irALoginView() {
		frame.setContentPane(login);
		menuBar.setVisible(false);
		frame.revalidate();
	}

	public void irANuevoRegistroView() {
		frame.setContentPane(nuevoReg);
		frame.revalidate();
	}

	public void irASolicitarAccesoView() {
		frame.setContentPane(solAcceso);
		menuBar.setVisible(true);
		frame.revalidate();

	}

	public void salir() {

		System.exit(0);
	}
}
