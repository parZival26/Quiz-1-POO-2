package IGU;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.*;

import UML.Propietario;

public class FrmInicio extends JFrame {

    static ImageIcon imgUsuario, imgLupa;
    static JLabel lblUsuario;
    JPanel panel;
    static JButton registrarPropietario, buscarPropietario;
    static ArrayList<Propietario> propietarios = new ArrayList<Propietario>();
    JScrollPane tablaPropietarios;

    public FrmInicio() {
        // Panel
        panel = new JPanel();
        add(panel);

        // Botones
        imgUsuario = new ImageIcon("./src/IGU/image/Usuarios.png");
        registrarPropietario = new JButton("Registrar Propietario ", imgUsuario);
        registrarPropietario.setBounds(100, 100, 10, 30);
        registrarPropietario.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        setVisible(false);
                        new FrmRegistro(FrmInicio.this);

                    }
                });

        panel.add(registrarPropietario);

        imgLupa = new ImageIcon("./src/IGU/image/lupa.png");
        buscarPropietario = new JButton("Buscar Propietario ", imgLupa);
        buscarPropietario.setBounds(100, 150, 10, 30);
        buscarPropietario.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String nombre = JOptionPane.showInputDialog("Nombre");
                        ArrayList<String[]> propietariosFiltrados = CSVUtils.buscarPorNombre(nombre);
                        if (tablaPropietarios != null) {
                            panel.remove(tablaPropietarios);
                        }
                        // Crear una nueva tabla y agregarla al panel
                        tablaPropietarios = new FrmTabla().TablaPropietarios(propietariosFiltrados);
                        panel.add(tablaPropietarios);
                        // Actualizar el panel para mostrar la nueva tabla
                        panel.revalidate();
                        panel.repaint();
                    }
                });

        panel.add(buscarPropietario);

        // tabla
        if (new File("./src/IGU/Propietarios.csv").exists()) {
            tablaPropietarios = new FrmTabla().TablaPropietarios();
            panel.add(tablaPropietarios);
        } else {
            JLabel mensaje = new JLabel("No hay propietarios registrados");
            mensaje.setBounds(100, 250, 10, 30);
            panel.add(mensaje);
        }

        // Imagenes

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
