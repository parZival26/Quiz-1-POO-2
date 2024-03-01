package IGU;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

import UML.Propietario;

public class FrmInicio extends JFrame {

    static JPanel panel;
    static JButton registrarPropietario, listarUsuario;
    static ArrayList<Propietario> propietarios = new ArrayList<Propietario>();

    public FrmInicio() {
        // Panel
        panel = new JPanel();
        add(panel);

        // Botones
        registrarPropietario = new JButton("Registrar Propietario");
        registrarPropietario.setBounds(100, 100, 10, 30);
        registrarPropietario.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        RegistrarPropietario.actionPerformed(e, propietarios);
                    }
                });

        panel.add(registrarPropietario);

        // config ventana
        setTitle("Quiz 1");
        setSize(500, 600);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);
    }

    public static void initialize() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new FrmInicio();
            }
        });
    }
}
