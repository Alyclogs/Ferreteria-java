package Control.Tablas;

import java.awt.Component;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;


public class Render extends DefaultTableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
            boolean isSelected, boolean hasFocus, int row, int column) {

        if (value instanceof JCheckBox) {
            JCheckBox chk = (JCheckBox) value;
            return chk;
        }

        return super.getTableCellRendererComponent(table, value, isSelected,
                hasFocus, row, column);

    }

}
