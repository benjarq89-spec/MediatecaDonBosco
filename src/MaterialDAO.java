import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MaterialDAO {
    public void insertarMaterial(Material m) {
        String sql = "INSERT INTO materiales (codigo_id, titulo, ubicacion_fisica, ejemplares_totales, tipo_material) VALUES (?, ?, ?, ?, ?)";
        try (Connection cn = Conexion.getConexion();
             PreparedStatement ps = cn.prepareStatement(sql)) {

            ps.setString(1, m.codigoId);
            ps.setString(2, m.titulo);
            ps.setString(3, m.ubicacionFisica);
            ps.setInt(4, m.ejemplaresTotales);
            // Aquí definimos el tipo según la clase
            ps.setString(5, m.getClass().getSimpleName());

            ps.executeUpdate();
            System.out.println("Material guardado en la base de datos.");
        } catch (SQLException e) {
            System.out.println("Error al insertar: " + e.getMessage());
        }
    }
}
