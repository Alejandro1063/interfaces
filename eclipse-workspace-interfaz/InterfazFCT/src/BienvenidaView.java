import javax.swing.JLabel;

public class BienvenidaView extends View{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2415830530643501307L;

	public BienvenidaView(AppController app) {
		super(app);
		setLayout(null);
		
		JLabel BienvenidaLabel = new JLabel("Hola, ");
		BienvenidaLabel.setBounds(184, 133, 127, 14);
		add(BienvenidaLabel);
	}

}
