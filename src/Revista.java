public class Revista extends Material{
    //Solo declaramos lo que es Exclusivo de una revista
    private final String issn;
    private final String editorial;
    private final String periodicidad;
    private final int numEdicion;
    private final int fechaPublicacion;
    private final String tematica;
    private final String idioma;
    private final String paisOrigen;

    //El constructor debe recibir TODO, lo del padre y lo del hijo
    public Revista(String codigoId, String titulo, String ubicacionFisica, String ejemplaresTotales, String periodicidad, int numEdicion, int fechaPublicacion, String tematica, String idioma, String issn, String paisOrigen, String editorial) {

        //Enviamos los datos generales al constructor de material
        super(codigoId, titulo, ubicacionFisica, Integer.parseInt(ejemplaresTotales));

        //Guardanos los datos especificos aqui en revistas
        this.issn = issn;
        this.editorial = editorial;
        this.periodicidad = periodicidad;
        this.numEdicion = numEdicion;
        this.fechaPublicacion = fechaPublicacion;
        this.tematica = tematica;
        this.idioma = idioma;
        this. paisOrigen = paisOrigen;

    }

    @Override
    public void mostrarDetalles() {
        System.out.println("Revista: " + titulo + "  | Edición: " + numEdicion + " | ISSN: " + issn);
    }

}
