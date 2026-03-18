package cl.talento.vinilo.demo.modelo;

import jakarta.persistence.*;

@Entity
@Table(name = "vinilos")
public class Vinilo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_vinilo") //<--asi esta en la base de datos
    private Integer idVinilo;

    private String titulo;
    private String artista;
    
    @Column(name = "anio_lanzamiento")//<-- asi en la BD
    private Integer anioLanzamiento;
    
    private String genero;
    private Boolean disponible = true;

    public Vinilo() {}

    public Integer getIdVinilo() { return idVinilo; }
    public void setIdVinilo(Integer idVinilo) { this.idVinilo = idVinilo; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getArtista() { return artista; }
    public void setArtista(String artista) { this.artista = artista; }

    public Integer getAnioLanzamiento() { return anioLanzamiento; }
    public void setAnioLanzamiento(Integer anioLanzamiento) { this.anioLanzamiento = anioLanzamiento; }

    public String getGenero() { return genero; }
    public void setGenero(String genero) { this.genero = genero; }

    public Boolean getDisponible() { return disponible; }
    public void setDisponible(Boolean disponible) { this.disponible = disponible; }
}
