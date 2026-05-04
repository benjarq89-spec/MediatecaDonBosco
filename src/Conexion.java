import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
    // Datos de tu servidor local en la Mac
    private static final String URL = "jdbc:mysql://localhost:3307/MediatecaDB?allowPublicKeyRetrieval=true&useSSL=false";
    private static final String USER = "root";
    private static final String PASS = ""; // La clave de 10 caracteres que configuraste

    public static Connection getConexion() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (Exception e) {
            System.out.println("❌ Error de conexión: " + e.getMessage());
            return null;
        }
    }
}
