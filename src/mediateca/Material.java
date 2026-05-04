package mediateca;

public abstract class Material {
    protected String codigoId;
    protected String titulo;
    protected String ubicacionFisica;
    protected int ejemplaresTotales;
    protected int ejemplaresPrestados;

    public Material(String codigoId, String titulo, String ubicacionFisica, int ejemplaresTotales) {
        this.codigoId = codigoId;
        this.titulo = titulo;
        this.ubicacionFisica = ubicacionFisica;
        this.ejemplaresTotales = ejemplaresTotales;
        this.ejemplaresPrestados = 0;
    }

    // Método que todos los hijos deben tener, pero cada uno lo hace distinto
    public abstract void mostrarDetalles();

    // Estos van AQUÍ, en la clase Material
    public String getCodigoId() { return codigoId; }
    public String getTitulo() { return titulo; }
    public String getUbicacionFisica() { return ubicacionFisica; }
    public int getEjemplaresTotales() { return ejemplaresTotales; }
}

