package IGU;

import java.util.ArrayList;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class FrmTabla {

    static JTable tabla;
    static DefaultTableModel model;

    public JScrollPane TablaPropietarios() {
        model = new DefaultTableModel();
        tabla = new JTable(model);

        model.addColumn("ID");
        model.addColumn("Nombre");
        model.addColumn("Apellidos");
        model.addColumn("Edad");
        model.addColumn("Documento");

        ArrayList<String[]> propietarios = CSVUtils.readCSV();
        for (String[] propietario : propietarios) {
            model.addRow(propietario);
        }

        JScrollPane scroll = new JScrollPane(tabla);
        scroll.setBounds(10, 10, 500, 300);
        return scroll;

    }

    public JScrollPane TablaPropietarios(ArrayList<String[]> propietariosFiltrados) {
        model = new DefaultTableModel();
        tabla = new JTable(model);

        model.addColumn("ID");
        model.addColumn("Nombre");
        model.addColumn("Apellidos");
        model.addColumn("Edad");
        model.addColumn("Documento");

        for (String[] propietario : propietariosFiltrados) {
            model.addRow(propietario);
        }

        JScrollPane scroll = new JScrollPane(tabla);
        scroll.setBounds(10, 10, 500, 300);
        return scroll;

    }

}
