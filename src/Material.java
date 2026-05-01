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
}
