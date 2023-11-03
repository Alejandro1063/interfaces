package FCT;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class BienvenidaView extends View {

	JLabel BienvenidaLabel;

	private static final long serialVersionUID = -2415830530643501307L;

	public BienvenidaView(AppController appController) {
		super(appController);
		setLayout(null);
		BienvenidaLabel = new JLabel();
		BienvenidaLabel.setHorizontalAlignment(SwingConstants.CENTER);
		BienvenidaLabel.setFont(new Font("Tahoma", Font.PLAIN, 40));
		BienvenidaLabel.setBounds(70, 92, 379, 130);

		add(BienvenidaLabel);

	}
	/**
	 * Método que devuelve un mensaje junto con el nombre del usuario que ya haya hecho login.
	 */
	public void mensajeBien() {

		BienvenidaLabel.setText("Hola, " + appController.getUser().getNombre());

	}

}
