import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.math.BigDecimal;
import java.math.RoundingMode;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class NuevoRegistroView extends View{

	public NuevoRegistroView(AppController appController) {
		
		super(appController);
		setLayout(null);
		
		JLabel fechaLabel = new JLabel("Fecha:");
		fechaLabel.setBounds(159, 93, 89, 14);
		add(fechaLabel);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setBounds(159, 137, 100, 27);
		add(comboBox);
		
		JLabel horaLabel = new JLabel("Horas:");
		horaLabel.setBounds(159, 192, 89, 14);
		add(horaLabel);
		
		JSlider slider = new JSlider();
		slider.setMaximum(20);
		slider.setMajorTickSpacing(5);
		slider.setValue(0);
		slider.setBounds(159, 240, 200, 26);
		slider.setMinorTickSpacing(1);
		slider.setPaintTicks(true);
		add(slider);
		
		JLabel tareasLabel = new JLabel("Tareas realizadas:");
		tareasLabel.setBounds(159, 267, 176, 14);
		add(tareasLabel);
		
		JButton aceptarButton = new JButton("ACEPTAR");
		aceptarButton.setBounds(375, 389, 89, 23);
		add(aceptarButton);
		
		JButton cancelarButton = new JButton("CANCELAR");
		cancelarButton.setBounds(488, 389, 89, 23);
		add(cancelarButton);
		
		JLabel labelNumHoras = new JLabel("0");
		labelNumHoras.setBounds(377, 252, 46, 14);
		add(labelNumHoras);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(142, 309, 338, 70);
		add(scrollPane);
		
		textField = new JTextField();
		scrollPane.setViewportView(textField);
		textField.setColumns(10);
		
		ChangeListener sliderListener = new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				BigDecimal valor = new BigDecimal(slider.getValue()).divide(new BigDecimal(2) , 1, RoundingMode.HALF_DOWN);
				labelNumHoras.setText(valor.toString());
				
			}
		};
		slider.addChangeListener(sliderListener);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -4742660105408096166L;
	private JTextField textField;
}
