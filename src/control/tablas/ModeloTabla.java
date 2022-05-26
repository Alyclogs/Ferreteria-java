package Control.Tablas;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.JTable;

public class ModeloTabla {

    public DefaultTableModel modeloTablaProductos() {
        String[] header = {"SEL.", "ID", "NOMBRE DEL PRODUCTO", "PRECIO", "STOCK"};
        boolean[] columnaEditable = {true, false, false, false, false};
        Class[] types = new Class[]{java.lang.Boolean.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class};
        
        DefaultTableModel ModeloTabla = new DefaultTableModel(header, 0) {

            @Override
            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }

            @Override
            public boolean isCellEditable(int row, int column) {
                return columnaEditable[column];
            }
        };
        return ModeloTabla;
    }
    
    public DefaultTableModel modeloTablaFacturas() {
        String[] header = {"SEL.", "ID", "NOMBRE DEL CLIENTE", "PRODUCTO VENDIDO", "CANT", "MONTO"};
        boolean[] columnaEditable = {true, false, false, false, false, false};
        Class[] types = new Class[]{java.lang.Boolean.class, java.lang.Object.class, java.lang.Object.class,
            java.lang.Object.class, java.lang.Object.class, java.lang.Object.class};
        
        DefaultTableModel ModeloTabla = new DefaultTableModel(header, 0) {

            @Override
            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }

            @Override
            public boolean isCellEditable(int row, int column) {
                return columnaEditable[column];
            }
        };
        return ModeloTabla;
    }
    
    public void redimensionarColumnas(JTable t, int col0, int col1, int col2, int col3, int col4) {
        TableColumn column = null;

        column = t.getColumnModel().getColumn(0);
        column.setPreferredWidth(col0);
        column = t.getColumnModel().getColumn(1);
        column.setPreferredWidth(col1);
        column = t.getColumnModel().getColumn(2);
        column.setPreferredWidth(col2);
        column = t.getColumnModel().getColumn(3);
        column.setPreferredWidth(col3);
        column = t.getColumnModel().getColumn(4);
        column.setPreferredWidth(col4);
    }
}
