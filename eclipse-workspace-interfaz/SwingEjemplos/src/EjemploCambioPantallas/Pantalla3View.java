package EjemploCambioPantallas;
import javax.swing.JLabel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class Pantalla3View extends View{
	public Pantalla3View(AppController ap) {
		super(ap);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Pantalla 3");
		lblNewLabel.setBounds(108, 132, 121, 14);
		add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Ir a pantalla 1");
		btnNewButton.setBounds(292, 184, 137, 23);
		add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ap.irAPantalla1();
				
			}
		});
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 5430617681923355797L;

}
