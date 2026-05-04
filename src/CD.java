public class CD extends Material {
    private String artista;
    private String genero;
    private String duracion;
    private int numCanciones;

    public CD(String codigoId, String titulo, String ubicacionFisica, int ejemplaresTotales,
              String artista, String genero, String duracion, int numCanciones) {

        super(codigoId, titulo, ubicacionFisica, ejemplaresTotales);
        this.artista = artista;
        this.genero = genero;
        this.duracion = duracion;
        this.numCanciones = numCanciones;
    }

    @Override
    public void mostrarDetalles() {
        System.out.println("CD: " + titulo + " | Artista: " + artista + " | Canciones: " + numCanciones);
    }
    public String getArtista() { return artista; }
    public String getGenero() { return genero; }
    public String getDuracion() { return duracion; }
    public int getNumCanciones() { return numCanciones; }
}
