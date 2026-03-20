package cl.talento.otec.admin.modelo;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "relatores")
public class Relator {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_relator")
    private Integer idRelator;

    private String nombres;
    private String apellidos;
    private String email;
    private String especialidad;
    private Boolean activo = true;

    @OneToMany(mappedBy = "relator", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CertificacionReuf> certificacionesReuf;

    @OneToMany(mappedBy = "relator", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Habilitacion> habilitaciones;

    public Relator() {}

    public Integer getIdRelator() { return idRelator; }
    public void setIdRelator(Integer idRelator) { this.idRelator = idRelator; }

    public String getNombres() { return nombres; }
    public void setNombres(String nombres) { this.nombres = nombres; }

    public String getApellidos() { return apellidos; }
    public void setApellidos(String apellidos) { this.apellidos = apellidos; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getEspecialidad() { return especialidad; }
    public void setEspecialidad(String especialidad) { this.especialidad = especialidad; }

    public Boolean getActivo() { return activo; }
    public void setActivo(Boolean activo) { this.activo = activo; }

    public List<CertificacionReuf> getCertificacionesReuf() { return certificacionesReuf; }
    public void setCertificacionesReuf(List<CertificacionReuf> certificacionesReuf) { this.certificacionesReuf = certificacionesReuf; }

    public List<Habilitacion> getHabilitaciones() { return habilitaciones; }
    public void setHabilitaciones(List<Habilitacion> habilitaciones) { this.habilitaciones = habilitaciones; }
}
