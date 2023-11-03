package FCT;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import proyectoFCT.modelo.Registro;

public class TableModel extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4582474162306156777L;
	private List<Registro> registros;

	public TableModel() {
		registros = new ArrayList<Registro>();
	}
	/**
	 * Método que devuelve la cantidad de registros que haya
	 */
	@Override
	public int getRowCount() {

		return registros.size();
	}
	/**
	 * Método para obtener la lista completa de registros.
	 * @return Lista de registros
	 */
	public List<Registro> getRegistros() {
		return registros;
	}
	/**
	 * Método para asignar una lista de registros
	 * @param Registro Lista de registros
	 */
	public void setRegistros(List<Registro> Registro) {
		this.registros = Registro;
	}
	/**
	 * Método que asigna el número de columnas que va a haber en una tabla
	 */
	@Override
	public int getColumnCount() {

		return 3;
	}
	/**
	 * Método para asignar, dependiendo de el número de la columna, un nombre a la misma
	 */
	@Override
	public String getColumnName(int column) {
		if (column == 0) {
			return "Fecha";
		} else if (column == 1) {
			return "Horas";
		}
		return "Tareas";

	}
	/**
	 * Método en el cual, dependiendo de la columna y la fila, asigna los datos que corresponde en la casilla
	 */
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {

		Registro nombreFila = registros.get(rowIndex);
		if (columnIndex == 0) {
			return nombreFila.getFecha();
		}
		if (columnIndex == 1) {
			return nombreFila.getNumHoras();
		} else {
			return nombreFila.getDescripcion();
		}
	}

}
