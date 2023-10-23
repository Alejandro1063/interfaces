import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import ceu_fct.modelo.Registro;

public class TableModel extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4582474162306156777L;
	private List<Registro> registros;

	public TableModel() {
		registros = new ArrayList<Registro>();
	}

	@Override
	public int getRowCount() {

		return registros.size();
	}

	public List<Registro> getRegistros() {
		return registros;
	}

	public void setRegistros(List<Registro> Registro) {
		this.registros = Registro;
	}

	@Override
	public int getColumnCount() {

		return 3;
	}

	@Override
	public String getColumnName(int column) {

		if (column == 0) {
			return "Nombre";
		}
		return "Apellidos";
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {

		Registro nombreFila = registros.get(rowIndex);
		if (columnIndex == 0) {
			return nombreFila.getFecha();
		}
		if (columnIndex == 1) {
		return nombreFila.getNum_horas();
		}
		else {
			return nombreFila.getDescripcion();
		}
	}

}
