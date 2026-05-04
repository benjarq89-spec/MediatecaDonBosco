import java.sql.*;

public class UsuarioDAO {

    // PASO A: Corregido para que coincida con la DB en español
    public void inicializarSistema() {
        try (Connection cn = Conexion.getConexion();
             Statement st = cn.createStatement()) {
            if (cn == null) return;

            st.executeUpdate("CREATE DATABASE IF NOT EXISTS MediatecaDB");
            st.executeUpdate("USE MediatecaDB");
            // Usamos los nombres exactos que pusimos en phpMyAdmin
            st.executeUpdate("CREATE TABLE IF NOT EXISTS usuarios ("
                    + "usuario VARCHAR(50) PRIMARY KEY, "
                    + "clave VARCHAR(50), "
                    + "rol VARCHAR(50))");

            // Insertamos al admin con las 3 columnas correctas
            st.executeUpdate("INSERT IGNORE INTO usuarios (usuario, clave, rol) VALUES ('admin', '1234', 'Administrador')");
            System.out.println("✅ Sistema MediatecaDB inicializado correctamente.");
        } catch (SQLException e) {
            System.out.println("❌ Error al inicializar: " + e.getMessage());
        }
    }

    // PASO B: Corregido para usar 'usuario' y 'clave'
    public boolean login(String user, String pass) {
        String sql = "SELECT * FROM MediatecaDB.usuarios WHERE usuario = ? AND clave = ?";
        try (Connection cn = Conexion.getConexion();
             PreparedStatement ps = cn.prepareStatement(sql)) {
            if (cn == null) return false;

            ps.setString(1, user);
            ps.setString(2, pass);
            ResultSet rs = ps.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            System.out.println("❌ Error en Login: " + e.getMessage());
            return false;
        }

      }
    }


