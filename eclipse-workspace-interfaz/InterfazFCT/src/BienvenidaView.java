import javax.swing.JLabel;


public class BienvenidaView extends View{
	
	JLabel BienvenidaLabel;
	
	private static final long serialVersionUID = -2415830530643501307L;

	public BienvenidaView(AppController appController) {
		super(appController);
		setLayout(null);
		BienvenidaLabel = new JLabel();
		BienvenidaLabel.setBounds(184, 133, 127, 14);
		add(BienvenidaLabel);
		
	}
	public void mensajeBien() {
		
		BienvenidaLabel.setText("Hola, " + appController.getUser().getNombre());
		
	}

}
