public class Tesis extends Material {
    private String autor;
    private String facultad;
    private String carrera;
    private int anioGraduacion;

    public Tesis(String codigoId, String titulo, String ubicacionFisica, int ejemplaresTotales,
                 String autor, String facultad, String carrera, int anioGraduacion) {

        super(codigoId, titulo, ubicacionFisica, ejemplaresTotales);
        this.autor = autor;
        this.facultad = facultad;
        this.carrera = carrera;
        this.anioGraduacion = anioGraduacion;
    }

    @Override
    public void mostrarDetalles() {
        System.out.println("Tesis: " + titulo + " | Autor: " + autor + " | Carrera: " + carrera);
    }
    public String getAutor() { return autor; }
    public String getFacultad() { return facultad; }
    public String getCarrera() { return carrera; }
    public int getAnioGraduacion() { return anioGraduacion; }
}
