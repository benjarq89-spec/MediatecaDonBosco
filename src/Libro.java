public class Libro extends Material {
    private String autor;
    private int numPaginas;
    private String editorial;
    private String isbn;
    private int anioPublicacion;

    public Libro(String codigoId, String titulo, String ubicacionFisica, int ejemplaresTotales,
                 String autor, int numPaginas, String editorial, String isbn, int anioPublicacion) {
        // 'super' llama al constructor del padre (Material)
        super(codigoId, titulo, ubicacionFisica, ejemplaresTotales);
        this.autor = autor;
        this.numPaginas = numPaginas;
        this.editorial = editorial;
        this.isbn = isbn;
        this.anioPublicacion = anioPublicacion;
    }

    @Override
    public void mostrarDetalles() {
        System.out.println("ID: " + codigoId + " | Título: " + titulo + " | Autor: " + autor);
    }
    // Estos son los "Getters" que el DAO necesita para leer los datos
    public String getAutor() { return autor; }
    public int getNumPaginas() { return numPaginas; }
    public String getEditorial() { return editorial; }
    public String getIsbn() { return isbn; }
    public int getAnioPublicacion() { return anioPublicacion; }
}
