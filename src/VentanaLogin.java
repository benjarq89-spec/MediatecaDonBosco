import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaLogin extends JFrame {
    private JTextField txtUsuario;
    private JPasswordField txtClave;
    private JButton btnEntrar;

    public VentanaLogin() {
        setTitle("Login - Mediateca Don Bosco");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centrar en pantalla
        setLayout(new GridLayout(4, 1, 10, 10));

        add(new JLabel("Usuario:", SwingConstants.CENTER));
        txtUsuario = new JTextField();
        add(txtUsuario);

        add(new JLabel("Contraseña:", SwingConstants.CENTER));
        txtClave = new JPasswordField();
        add(txtClave);

        btnEntrar = new JButton("Iniciar Sesión");
        add(btnEntrar);

        // EVENTO DEL BOTÓN
        btnEntrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                validarAcceso();
            }
        });
    }

    private void validarAcceso() {
        String user = txtUsuario.getText();
        String pass = new String(txtClave.getPassword());

        if (user.equals("admin") && pass.equals("1234")) {
            JOptionPane.showMessageDialog(this, "¡Bienvenido Administrador!");
            // Aquí luego abriremos la ventana principal
        } else {
            JOptionPane.showMessageDialog(this, "Usuario o clave incorrectos", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new VentanaLogin().setVisible(true);
        });
    }
}