import javax.swing.*;
import java.awt.*;

public class VentanaLibro extends JFrame {
    // Campos de texto para los datos del libro
    private JTextField txtCodigo = new JTextField();
    private JTextField txtTitulo = new JTextField();
    private JTextField txtUbicacion = new JTextField();
    private JTextField txtEjemplares = new JTextField();
    private JTextField txtAutor = new JTextField();
    private JTextField txtPaginas = new JTextField();
    private JTextField txtEditorial = new JTextField();
    private JTextField txtIsbn = new JTextField();
    private JTextField txtAnio = new JTextField();
    private JButton btnGuardar = new JButton("Guardar Libro");

    public VentanaLibro() {
        setTitle("Registro de Libros - Mediateca UDB");
        setSize(400, 500);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(10, 2, 5, 5));

        // Agregamos los componentes a la ventana
        add(new JLabel("Código ID:")); add(txtCodigo);
        add(new JLabel("Título:")); add(txtTitulo);
        add(new JLabel("Ubicación Física:")); add(txtUbicacion);
        add(new JLabel("Ejemplares Totales:")); add(txtEjemplares);
        add(new JLabel("Autor:")); add(txtAutor);
        add(new JLabel("N° Páginas:")); add(txtPaginas);
        add(new JLabel("Editorial:")); add(txtEditorial);
        add(new JLabel("ISBN:")); add(txtIsbn);
        add(new JLabel("Año Publicación:")); add(txtAnio);
        add(btnGuardar);

        // Acción del botón Guardar
        btnGuardar.addActionListener(e -> guardarDatos());
    }

    private void guardarDatos() {
        try {
            // Creamos el objeto Libro con lo que escribiste en los cuadros
            Libro nuevoLibro = new Libro(
                    txtCodigo.getText(),
                    txtTitulo.getText(),
                    txtUbicacion.getText(),
                    Integer.parseInt(txtEjemplares.getText()),
                    txtAutor.getText(),
                    Integer.parseInt(txtPaginas.getText()),
                    txtEditorial.getText(),
                    txtIsbn.getText(),
                    Integer.parseInt(txtAnio.getText())
            );

            // Usamos el DAO para mandarlo a la base de datos
            new MaterialDAO().insertarLibro(nuevoLibro);
            JOptionPane.showMessageDialog(this, "¡Libro guardado exitosamente!");

            // Limpiamos los campos para el siguiente registro
            txtCodigo.setText(""); txtTitulo.setText("");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error en los datos: " + ex.getMessage());
        }
    }
}
