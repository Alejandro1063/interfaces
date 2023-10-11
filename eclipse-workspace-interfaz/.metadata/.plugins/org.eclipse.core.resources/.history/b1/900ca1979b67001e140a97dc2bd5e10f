package Ejercicio14;
import javax.swing.JLabel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class PantallaBienvenida extends View{

	/**
	 * 
	 */
	private static final long serialVersionUID = 936649860877894710L;

	public PantallaBienvenida(AppController ap) {
		super(ap);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Bienvenido a mi aplicación");
		lblNewLabel.setBounds(142, 66, 146, 14);
		add(lblNewLabel);
		
		JButton entrarBoton = new JButton("ENTRAR");
		entrarBoton.setBounds(172, 156, 89, 23);
		add(entrarBoton);

		entrarBoton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ap.irAPantalla1(null);

			}
		});
	}
}
