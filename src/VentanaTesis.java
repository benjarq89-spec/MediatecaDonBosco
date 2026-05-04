import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class VentanaTesis extends JFrame {
    // Campos de texto para la captura de datos
    private JTextField txtCod = new JTextField();
    private JTextField txtTit = new JTextField();
    private JTextField txtUbi = new JTextField();
    private JTextField txtEjemp = new JTextField();
    private JTextField txtAut = new JTextField();
    private JTextField txtFac = new JTextField();
    private JTextField txtCar = new JTextField();
    private JTextField txtAnio = new JTextField();
    private JButton btnGuardar = new JButton("Registrar Tesis");

    public VentanaTesis() {
        // Configuración de la ventana según el estándar del proyecto
        setTitle("Registro de Tesis - Mediateca UDB");
        setSize(400, 450);
        setLocationRelativeTo(null);

        // Layout para organizar etiquetas y campos
        setLayout(new GridLayout(9, 2, 10, 10));

        add(new JLabel(" Código ID:")); add(txtCod);
        add(new JLabel(" Título de Tesis:")); add(txtTit);
        add(new JLabel(" Ubicación Física:")); add(txtUbi);
        add(new JLabel(" Cantidad Ejemplares:")); add(txtEjemp);
        add(new JLabel(" Autor de la Tesis:")); add(txtAut);
        add(new JLabel(" Facultad:")); add(txtFac);
        add(new JLabel(" Carrera:")); add(txtCar);
        add(new JLabel(" Año de Graduación:")); add(txtAnio);
        add(new JLabel("")); // Celda vacía para diseño
        add(btnGuardar);

        // Acción para el botón guardar
        btnGuardar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                registrarTesis();
            }
        });
    }

    private void registrarTesis() {
        try {
            // Instancia de Tesis respetando el orden de tu constructor
            Tesis nuevaTesis = new Tesis(
                    txtCod.getText(),
                    txtTit.getText(),
                    txtUbi.getText(),
                    Integer.parseInt(txtEjemp.getText()), // Conversión a int
                    txtAut.getText(),
                    txtFac.getText(),
                    txtCar.getText(),
                    Integer.parseInt(txtAnio.getText())   // Conversión a int
            );

            // Persistencia mediante el DAO
            MaterialDAO dao = new MaterialDAO();
            dao.insertarTesis(nuevaTesis);

            JOptionPane.showMessageDialog(this, "La tesis ha sido almacenada correctamente.");
            limpiarCampos();

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Error: Ejemplares y Año deben ser valores numéricos.");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error al procesar el registro: " + ex.getMessage());
        }
    }

    private void limpiarCampos() {
        txtCod.setText("");
        txtTit.setText("");
        txtUbi.setText("");
        txtEjemp.setText("");
        txtAut.setText("");
        txtFac.setText("");
        txtCar.setText("");
        txtAnio.setText("");
    }
}