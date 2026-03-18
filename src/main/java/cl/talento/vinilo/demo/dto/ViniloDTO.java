package cl.talento.vinilo.demo.dto;

public class ViniloDTO {
    private Integer idVinilo;
    private String titulo;
    private String artista;
    private Integer anioLanzamiento;
    private String genero;
    private Boolean disponible;

    public ViniloDTO(Integer idVinilo, String titulo, String artista, Integer anioLanzamiento, String genero, Boolean disponible) {
        this.idVinilo = idVinilo;
        this.titulo = titulo;
        this.artista = artista;
        this.anioLanzamiento = anioLanzamiento;
        this.genero = genero;
        this.disponible = disponible;
    }

    public Integer getIdVinilo() { return idVinilo; }
    public String getTitulo() { return titulo; }
    public String getArtista() { return artista; }
    public Integer getAnioLanzamiento() { return anioLanzamiento; }
    public String getGenero() { return genero; }
    public Boolean getDisponible() { return disponible; }
    //TODO agregar setters
}
