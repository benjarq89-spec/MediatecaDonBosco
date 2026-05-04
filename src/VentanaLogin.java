import javax.swing.*;
import java.awt.*;

public class VentanaLogin extends JFrame {
    private JTextField txtUser = new JTextField();
    private JPasswordField txtPass = new JPasswordField();
    private JButton btnLogin = new JButton("Entrar");

    public VentanaLogin() {
        // Al abrir la ventana, nos aseguramos que la DB esté lista
        new UsuarioDAO().inicializarSistema();

        setTitle("Login - Mediateca UDB");
        setSize(300, 250);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(3, 1));

        add(new JLabel("Usuario:")); add(txtUser);
        add(new JLabel("Clave:")); add(txtPass);
        add(btnLogin);

        // Acción del botón
        btnLogin.addActionListener(e -> ejecutarLogin());
    }

    private void ejecutarLogin() {
        String u = txtUser.getText();
        String p = new String(txtPass.getPassword());

        if (new UsuarioDAO().login(u, p)) {
            JOptionPane.showMessageDialog(this, "¡Bienvenido, " + u + "!");

            MenuPrincipal menu = new MenuPrincipal(); // Creamos la instancia del menú
            menu.setVisible(true);                   // La hacemos visible
            this.dispose();                          // Cerramos la ventana de login

        } else {
            JOptionPane.showMessageDialog(this, "Credenciales incorrectas.");
        }
    }

    public static void main(String[] args) {
        new VentanaLogin().setVisible(true);
    }
}