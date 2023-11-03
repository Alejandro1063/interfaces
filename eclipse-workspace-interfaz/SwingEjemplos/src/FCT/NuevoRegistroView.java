package FCT;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import proyectoFCT.exception.EvaluacionException;
import proyectoFCT.exception.FechaServiceException;
import proyectoFCT.modelo.Fecha;
import proyectoFCT.modelo.Registro;
import proyectoFCT.servicio.FechaService;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class NuevoRegistroView extends View {
	private JComboBox<String> comboBox;
	private JLabel fechaLabel;
	private List<Fecha> listado;
	private DateTimeFormatter formato;
	private JLabel horaLabel;
	private JSlider slider;
	private JScrollPane scrollPane;
	private JTextArea textArea;
	private JLabel tareasLabel;
	private JButton aceptarButton;
	private JButton cancelarButton;
	private JLabel labelNumHoras;

	public NuevoRegistroView(AppController appController) {

		super(appController);
		setLayout(null);

		fechaLabel = new JLabel("Fecha:");
		fechaLabel.setBounds(159, 93, 89, 14);
		add(fechaLabel);

		comboBox = new JComboBox<String>();
		comboBox.setSelectedIndex(-1);
		comboBox.setBounds(159, 137, 100, 27);
		FechaService fechaServ = new FechaService();
		listado = new ArrayList<>();

		try {
			listado = fechaServ.consultarFechasActuales();

		} catch (EvaluacionException | FechaServiceException e1) {
			e1.printStackTrace();
		}

		formato = DateTimeFormatter.ofPattern("dd-MM-yyyy");

		for (Fecha fecha : listado) {
			String stringFormato = formato.format(fecha.getFecha());
			comboBox.addItem(stringFormato);

		}
		comboBox.setSelectedIndex(-1);
		add(comboBox);

		horaLabel = new JLabel("Horas:");
		horaLabel.setBounds(159, 192, 89, 14);
		add(horaLabel);

		slider = new JSlider();
		slider.setMaximum(20);
		slider.setMajorTickSpacing(5);
		slider.setValue(0);
		slider.setBounds(159, 240, 200, 26);
		slider.setMinorTickSpacing(1);
		slider.setPaintTicks(true);
		add(slider);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(142, 309, 338, 70);
		add(scrollPane);

		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		textArea.setLineWrap(true);

		tareasLabel = new JLabel("Tareas realizadas:");
		tareasLabel.setBounds(159, 267, 176, 14);
		add(tareasLabel);

		aceptarButton = new JButton("ACEPTAR");
		aceptarButton.setBounds(375, 389, 105, 23);
		add(aceptarButton);

		cancelarButton = new JButton("CANCELAR");
		cancelarButton.setBounds(488, 389, 108, 23);
		add(cancelarButton);

		labelNumHoras = new JLabel("0");
		labelNumHoras.setBounds(377, 252, 46, 14);
		add(labelNumHoras);

		ActionListener action = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (e.getSource() == aceptarButton) {

					if (validarDatos() == true) {
						Registro regis = new Registro();
						BigDecimal horas = new BigDecimal(slider.getValue() / 2);
						regis.setNumHoras(horas);
						LocalDate fecha = LocalDate.parse((String) comboBox.getSelectedItem(), formato);
						regis.setFecha(fecha);
						regis.setDescripcion(textArea.getText());

						comboBox.setSelectedItem(0);
						slider.setValue(0);
						textArea.setText("");
						labelNumHoras.setText("0");

						appController.crearNuevoRegistro(regis);
					} else {
						String error = "Hay algún campo que está vacío";
						JOptionPane.showMessageDialog(null, error);
					}
				}
				if (e.getSource() == cancelarButton) {

					comboBox.setSelectedItem(null);
					slider.setValue(0);
					textArea.setText("");
					appController.irABienvenidaView();
				}

			}

		};

		aceptarButton.addActionListener(action);
		cancelarButton.addActionListener(action);

		ChangeListener sliderListener = new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				BigDecimal valor = new BigDecimal(slider.getValue()).divide(new BigDecimal(2), 1,
						RoundingMode.HALF_DOWN);
				labelNumHoras.setText(valor.toString());

			}
		};
		slider.addChangeListener(sliderListener);
	}

	/**
	 * Método que comprueba si los campos del comboBox, del textArea y del slider
	 * están rellenos.
	 * 
	 * @return Devuelve true s ies así, y false si no.
	 */
	private Boolean validarDatos() {
		if (comboBox.getSelectedIndex() == -1 || textArea.getText().isEmpty() || slider.getValue() == 0) {
			return false;
		} else
			return true;
	}

	private static final long serialVersionUID = -4742660105408096166L;
}
