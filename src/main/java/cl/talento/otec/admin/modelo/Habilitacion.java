package cl.talento.otec.admin.modelo;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "habilitaciones")
public class Habilitacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_habilitacion")
    private Integer idHabilitacion;

    @Column(name = "area_curso")
    private String areaCurso;

    @Column(name = "validado_sence")
    private Boolean validadoSence;

    @Column(name = "clase_demostrativa")
    private Boolean claseDemostrativa;

    @Column(name = "fecha_evaluacion")
    private LocalDate fechaEvaluacion;

    private String estado;
    private Boolean activo = true;

    @ManyToOne
    @JoinColumn(name = "id_relator")
    private Relator relator;

    public Habilitacion() {}

    public Integer getIdHabilitacion() { return idHabilitacion; }
    public void setIdHabilitacion(Integer idHabilitacion) { this.idHabilitacion = idHabilitacion; }

    public String getAreaCurso() { return areaCurso; }
    public void setAreaCurso(String areaCurso) { this.areaCurso = areaCurso; }

    public Boolean getValidadoSence() { return validadoSence; }
    public void setValidadoSence(Boolean validadoSence) { this.validadoSence = validadoSence; }

    public Boolean getClaseDemostrativa() { return claseDemostrativa; }
    public void setClaseDemostrativa(Boolean claseDemostrativa) { this.claseDemostrativa = claseDemostrativa; }

    public LocalDate getFechaEvaluacion() { return fechaEvaluacion; }
    public void setFechaEvaluacion(LocalDate fechaEvaluacion) { this.fechaEvaluacion = fechaEvaluacion; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    public Boolean getActivo() { return activo; }
    public void setActivo(Boolean activo) { this.activo = activo; }

    public Relator getRelator() { return relator; }
    public void setRelator(Relator relator) { this.relator = relator; }
}
