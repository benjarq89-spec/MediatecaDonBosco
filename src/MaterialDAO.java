import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MaterialDAO {

    // --- MÉTODOS DE INSERCIÓN (Para guardar) ---

    public void insertarLibro(Libro l) {
        String sql = "INSERT INTO libro (codigoId, titulo, ubicacionFisica, ejemplaresTotales, autor, editorial, isbn) VALUES (?, ?, ?, ?, ?, ?, ?)";
        ejecutarUpdate(sql, l.getCodigoId(), l.getTitulo(), l.getUbicacionFisica(), l.getEjemplaresTotales(), l.getAutor(), l.getEditorial(), l.getIsbn());
    }

    public void insertarRevista(Revista r) {
        String sql = "INSERT INTO revista (codigoId, titulo, ubicacionFisica, ejemplaresTotales, editorial, periodicidad, issn) VALUES (?, ?, ?, ?, ?, ?, ?)";
        ejecutarUpdate(sql, r.getCodigoId(), r.getTitulo(), r.getUbicacionFisica(), r.getEjemplaresTotales(), r.getEditorial(), r.getPeriodicidad(), r.getIssn());
    }

    public void insertarCD(CD cd) {
        String sql = "INSERT INTO cd (codigoId, titulo, ubicacionFisica, ejemplaresTotales, artista, genero, duracion) VALUES (?, ?, ?, ?, ?, ?, ?)";
        ejecutarUpdate(sql, cd.getCodigoId(), cd.getTitulo(), cd.getUbicacionFisica(), cd.getEjemplaresTotales(), cd.getArtista(), cd.getGenero(), cd.getDuracion());
    }

    public void insertarTesis(Tesis t) {
        String sql = "INSERT INTO tesis (codigoId, titulo, ubicacionFisica, ejemplaresTotales, autor, facultad, carrera, anioGraduacion) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        ejecutarUpdate(sql, t.getCodigoId(), t.getTitulo(), t.getUbicacionFisica(), t.getEjemplaresTotales(), t.getAutor(), t.getFacultad(), t.getCarrera(), t.getAnioGraduacion());
    }

    // --- MÉTODOS DE CONSULTA (Para la tabla) ---

    public List<Object[]> consultarLibros() {
        return ejecutarConsulta("SELECT codigoId, titulo, autor, editorial, isbn FROM libro");
    }

    public List<Object[]> consultarRevistas() {
        return ejecutarConsulta("SELECT codigoId, titulo, periodicidad, editorial, issn FROM revista");
    }

    public List<Object[]> consultarCDs() {
        return ejecutarConsulta("SELECT codigoId, titulo, artista, genero, duracion FROM cd");
    }

    public List<Object[]> consultarTesis() {
        return ejecutarConsulta("SELECT codigoId, titulo, autor, facultad, carrera FROM tesis");
    }

    // --- MÉTODOS AUXILIARES ---

    private void ejecutarUpdate(String sql, Object... params) {
        try (Connection con = Conexion.getConexion(); PreparedStatement ps = con.prepareStatement(sql)) {
            for (int i = 0; i < params.length; i++) ps.setObject(i + 1, params[i]);
            ps.executeUpdate();
        } catch (SQLException e) { System.out.println("Error en inserción: " + e.getMessage()); }
    }

    private List<Object[]> ejecutarConsulta(String sql) {
        List<Object[]> lista = new ArrayList<>();
        try (Connection con = Conexion.getConexion(); PreparedStatement ps = con.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
            int columnas = rs.getMetaData().getColumnCount();
            while (rs.next()) {
                Object[] fila = new Object[columnas];
                for (int i = 0; i < columnas; i++) fila[i] = rs.getObject(i + 1);
                lista.add(fila);
            }
        } catch (SQLException e) { System.out.println("Error en consulta: " + e.getMessage()); }
        return lista;
    }
}