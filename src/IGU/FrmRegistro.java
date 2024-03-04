package IGU;

import java.io.File;
import java.io.FileWriter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener; 

import javax.swing.*;

import UML.Propietario;

public class FrmRegistro extends JFrame {

    JLabel lblDocumento, lblNombres, lblApellidos, lblEdad, lblIdPropietario;
    JTextField txtDocumento, txtNombres, txtApellidos, txtEdad, txtIdPropietario;
    JButton btnRegistrar, btnRegresar;
    ImageIcon imgPen, imgBack;
    JPanel panel;

    public FrmRegistro(FrmInicio frmInicio) {

        // Panel
        panel = new JPanel();
        add(panel);

        // inputs
        lblDocumento = new JLabel("Documento");
        lblDocumento.setBounds(10, 20, 50, 10);
        panel.add(lblDocumento);
        txtDocumento = new JTextField(15);
        panel.add(txtDocumento);

        lblNombres = new JLabel("Nombres");
        lblNombres.setBounds(10, 50, 70, 25);
        panel.add(lblNombres);
        txtNombres = new JTextField(15);
        panel.add(txtNombres);

        lblApellidos = new JLabel("Apellidos");
        lblApellidos.setBounds(80, 80, 70, 25);
        panel.add(lblApellidos);
        txtApellidos = new JTextField(15);
        panel.add(txtApellidos);

        lblEdad = new JLabel("Edad");
        lblEdad.setBounds(10, 110, 70, 25);
        panel.add(lblEdad);
        txtEdad = new JTextField(15);
        panel.add(txtEdad);

        lblIdPropietario = new JLabel("Id Propietario");
        lblIdPropietario.setBounds(10, 140, 70, 25);
        panel.add(lblIdPropietario);
        txtIdPropietario = new JTextField(15);
        panel.add(txtIdPropietario);

        // Botones

        imgPen = new ImageIcon("./src/IGU/image/pen.png");
        btnRegistrar = new JButton("Registrar", imgPen);
        btnRegistrar.setBounds(100, 500, 80, 25);
        btnRegistrar.addActionListener(
                e -> {
                    Propietario propietario = new Propietario(Integer.parseInt(txtDocumento.getText()),
                            txtNombres.getText(),
                            txtApellidos.getText(), Integer.parseInt(txtEdad.getText()),
                            Integer.parseInt(txtIdPropietario.getText()));
                    JOptionPane.showMessageDialog(null, "Propietario registrado");
                    ingresarPropietario(propietario);

                    dispose();
                    frmInicio.setVisible(true);
                    if (frmInicio.tablaPropietarios != null) {
                        frmInicio.panel.remove(frmInicio.tablaPropietarios);
                    }
                    // Crear una nueva tabla y agregarla al panel
                    frmInicio.tablaPropietarios = new FrmTabla().TablaPropietarios();
                    frmInicio.panel.add(frmInicio.tablaPropietarios);
                    // Actualizar el panel para mostrar la nueva tabla
                    frmInicio.panel.revalidate();
                    frmInicio.panel.repaint();
                });
        panel.add(btnRegistrar);

        imgBack = new ImageIcon("./src/IGU/image/back.png");
        btnRegresar = new JButton("Regresar", imgBack);
        btnRegresar.setBounds(300, 500, 80, 25);
        btnRegresar.addActionListener(
            new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                setVisible(false);
                frmInicio.setVisible(true);

            }
        });


        panel.add(btnRegresar);

        setTitle("Registrar Usuario");
        setSize(500, 200);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);
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
