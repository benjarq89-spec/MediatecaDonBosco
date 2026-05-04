import javax.swing.*;
import java.awt.*;

public class VentanaRevista extends JFrame {
    private JTextField txtCod = new JTextField(), txtTit = new JTextField(), txtUbi = new JTextField();
    private JTextField txtEjemp = new JTextField(), txtIssn = new JTextField(), txtEdit = new JTextField();
    private JTextField txtPer = new JTextField(), txtEdic = new JTextField(), txtFech = new JTextField();
    private JTextField txtTem = new JTextField(), txtIdi = new JTextField(), txtPais = new JTextField();
    private JButton btnGuardar = new JButton("Guardar Revista");

    public VentanaRevista() {
        setTitle("Registro de Revistas - Mediateca UDB");
        setSize(450, 600);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(13, 2, 5, 5));

        add(new JLabel("Código ID:")); add(txtCod);
        add(new JLabel("Título:")); add(txtTit);
        add(new JLabel("Ubicación Física:")); add(txtUbi);
        add(new JLabel("Ejemplares Totales:")); add(txtEjemp);
        add(new JLabel("ISSN:")); add(txtIssn);
        add(new JLabel("Editorial:")); add(txtEdit);
        add(new JLabel("Periodicidad:")); add(txtPer);
        add(new JLabel("N° Edición (Número):")); add(txtEdic);
        add(new JLabel("Año Publicación (Número):")); add(txtFech);
        add(new JLabel("Temática:")); add(txtTem);
        add(new JLabel("Idioma:")); add(txtIdi);
        add(new JLabel("País Origen:")); add(txtPais);
        add(btnGuardar);

        btnGuardar.addActionListener(e -> guardar());
    }

    private void guardar() {
        try {
            // Este orden es el EXACTO de tu constructor de Revista.java
            Revista r = new Revista(
                    txtCod.getText(),      // 1. codigoId
                    txtTit.getText(),      // 2. titulo
                    txtUbi.getText(),      // 3. ubicacionFisica
                    txtEjemp.getText(),    // 4. ejemplaresTotales (Tu clase lo pide como String)
                    txtPer.getText(),      // 5. periodicidad (¡OJO! Aquí lo pide tu clase)
                    Integer.parseInt(txtEdic.getText()), // 6. numEdicion (int)
                    Integer.parseInt(txtFech.getText()), // 7. fechaPublicacion (int)
                    txtTem.getText(),      // 8. tematica
                    txtIdi.getText(),      // 9. idioma
                    txtIssn.getText(),     // 10. issn
                    txtPais.getText(),     // 11. paisOrigen
                    txtEdit.getText()      // 12. editorial
            );

            new MaterialDAO().insertarRevista(r);
            JOptionPane.showMessageDialog(this, "✅ Revista guardada correctamente.");

        } catch (NumberFormatException nfe) {
            JOptionPane.showMessageDialog(this, "Error: En Edición y Año poné solo números.");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }
}
