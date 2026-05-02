import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAO {

    public boolean validarLogin(String user, String pass) {
        // Asegúrate de que el nombre de la tabla y columnas coincidan con tu DB en MySQL
        String sql = "SELECT * FROM usuarios WHERE username = ? AND password = ?";

        try (Connection cn = Conexion.getConexion();
             PreparedStatement ps = cn.prepareStatement(sql)) {

            ps.setString(1, user);
            ps.setString(2, pass);

            try (ResultSet rs = ps.executeQuery()) {
                return rs.next(); // Retorna true si encontró al usuario
            }

        } catch (SQLException e) {
            System.out.println("Error en la validación de login: " + e.getMessage());
            return false;
        }
    }
}

