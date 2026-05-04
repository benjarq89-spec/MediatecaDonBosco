import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class VentanaCD extends JFrame {
    // Definición de los campos de texto
    private JTextField txtCod = new JTextField();
    private JTextField txtTit = new JTextField();
    private JTextField txtUbi = new JTextField();
    private JTextField txtEjemp = new JTextField();
    private JTextField txtArt = new JTextField();
    private JTextField txtGen = new JTextField();
    private JTextField txtDur = new JTextField();
    private JTextField txtCan = new JTextField();
    private JButton btnGuardar = new JButton("Registrar CD");

    public VentanaCD() {
        // Configuración de la ventana
        setTitle("Registro de CDs - Mediateca UDB");
        setSize(400, 450);
        setLocationRelativeTo(null);

        // Usamos un grid para que se vea ordenado
        setLayout(new GridLayout(9, 2, 10, 10));

        // Agregando etiquetas y campos
        add(new JLabel(" Código del Material:")); add(txtCod);
        add(new JLabel(" Título del Álbum:")); add(txtTit);
        add(new JLabel(" Ubicación en Estante:")); add(txtUbi);
        add(new JLabel(" Total Ejemplares:")); add(txtEjemp);
        add(new JLabel(" Artista / Banda:")); add(txtArt);
        add(new JLabel(" Género Musical:")); add(txtGen);
        add(new JLabel(" Duración Total:")); add(txtDur);
        add(new JLabel(" Número de Canciones:")); add(txtCan);
        add(new JLabel("")); // Espacio vacío
        add(btnGuardar);

        // Evento para procesar el registro
        btnGuardar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                guardarRegistro();
            }
        });
    }

    private void guardarRegistro() {
        try {
            // Creamos el objeto siguiendo el orden de tu constructor en CD.java
            CD nuevoCd = new CD(
                    txtCod.getText(),
                    txtTit.getText(),
                    txtUbi.getText(),
                    Integer.parseInt(txtEjemp.getText()), // Convertimos a int
                    txtArt.getText(),
                    txtGen.getText(),
                    txtDur.getText(),
                    Integer.parseInt(txtCan.getText())    // Convertimos a int
            );

            // Llamada al DAO para insertar en la base de datos
            MaterialDAO dao = new MaterialDAO();
            dao.insertarCD(nuevoCd);

            JOptionPane.showMessageDialog(this, "El CD se registró correctamente en el sistema.");
            limpiarFormulario();

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Revisa los campos numéricos (Ejemplares y Canciones).");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Hubo un problema al guardar: " + ex.getMessage());
        }
    }

    private void limpiarFormulario() {
        txtCod.setText("");
        txtTit.setText("");
        txtUbi.setText("");
        txtEjemp.setText("");
        txtArt.setText("");
        txtGen.setText("");
        txtDur.setText("");
        txtCan.setText("");
    }
}
