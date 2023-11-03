package FCT;

import javax.swing.JTable;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JScrollPane;

public class ConsultaRegistroView extends View {

	private static final long serialVersionUID = 7438431858062329945L;
	private JTable table;
	private TableModel tModel;

	public ConsultaRegistroView(AppController appController) {
		super(appController);
		setLayout(null);

		table = new JTable();
		table.setBounds(225, 5, 0, 0);
		add(table);

		JButton refrescarButton = new JButton("REFRESCAR");
		refrescarButton.setBounds(388, 351, 146, 23);
		add(refrescarButton);

		JScrollPane scrollRegistro = new JScrollPane();
		scrollRegistro.setBounds(98, 65, 434, 239);
		add(scrollRegistro);

		table = new JTable();
		scrollRegistro.setViewportView(table);

		tModel = new TableModel();
		table.setModel(tModel);

		refrescarButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				actualizarTabla();
			}
		});
	}

	/*
	 * Método que actualiza la tabla con los datos obtenidos desde la bbdd con el
	 * método devolverRegis().
	 */
	public void actualizarTabla() {
		tModel.setRegistros(appController.devolverRegis());
		tModel.fireTableDataChanged();
	}
	/**
	 * 
	 */

}
