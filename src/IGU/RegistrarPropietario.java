package IGU;

import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

import javax.swing.*;

import UML.Propietario;

public abstract class RegistrarPropietario {
    public static void actionPerformed(ActionEvent e, ArrayList<Propietario> propietarios) {
        Propietario propietario = crearPropietario();
        JOptionPane.showMessageDialog(null, "Propietario registrado");
        ingresarPropietario(propietario);
    }

    private static Propietario crearPropietario() {
        String documento = JOptionPane.showInputDialog("Documento");
        String nombres = JOptionPane.showInputDialog("Nombres");
        String apellidos = JOptionPane.showInputDialog("Apellidos");
        String edad = JOptionPane.showInputDialog("Edad");
        String id_Propietario = JOptionPane.showInputDialog("Id Propietario");
        Propietario propietario = new Propietario(Integer.parseInt(documento), nombres, apellidos,
                Integer.parseInt(edad), Integer.parseInt(id_Propietario));
        return propietario;
    }

    private static void ingresarPropietario(Propietario propietario) {
        File f = new File("./src/IGU/Propietarios.csv");
        if (!f.exists()) {
            try {
                f.createNewFile();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        try (FileWriter fw = new FileWriter(f, true)) {
            fw.write(propietario.toCSV() + "\n");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
