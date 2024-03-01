package IGU;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrmTabla {

    static JTable tabla;
    static DefaultTableModel model;

    public FrmTabla(){
        model = new DefaultTableModel();
        tabla = new JTable(model);

        model.addColumn("ID");
        model.addColumn("Nombre");
        model.addColumn("Apellidos");
        model.addColumn("Edad");
        model.addColumn("Documento");

        //Lista de OBject[] = {"ID", "Nombre", "Apellidos", "Edad", "Documento"}
        // model.addRow[Lista]
    }

}
