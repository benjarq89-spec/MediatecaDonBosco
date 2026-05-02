public class Usuario {
    private int id;
    private String nombre;
    private String user;
    private String password;
    private String rol; // Aquí guardaremos "Administrador", "Profesor" o "Alumno"

    public Usuario(int id, String nombre, String user, String password, String rol) {
        this.id = id;
        this.nombre = nombre;
        this.user = user;
        this.password = password;
        this.rol = rol;
    }

    // Getters para poder leer los datos después
    public String getRol() { return rol; }
    public String getNombre() { return nombre; }
    public String getUser() { return user; }
    public String getPassword() { return password; }
}
