import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    private static final String URL = "jdbc:mysql://localhost:3306/MediatecaDB";
    private static final String USER = "root";
    private static final String PASSWORD = "1234";

    public static Connection getConexion() {
        Connection cn = null;
        try {
            cn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("¡Conexión exitosa con la MediatecaDB!");
        } catch (SQLException e) {
            System.out.println("Error de conexión: " + e.getMessage());
        }
        return cn;
    }

    public static void main(String[] args) {
        getConexion();
    }
}
