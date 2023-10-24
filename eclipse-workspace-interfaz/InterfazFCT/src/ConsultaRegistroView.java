import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

public class ConsultaRegistroView extends View{
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
		
		registroTable = new JTable();
		registroTable.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
			},
			new String[] {
				"Fecha", "Horas", "Tareas"
			}
		));
		registroTable.getColumnModel().getColumn(2).setPreferredWidth(451);
		scrollRegistro.setViewportView(registroTable);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 7438431858062329945L;
	private JTable table;
	private JTable registroTable;
}
