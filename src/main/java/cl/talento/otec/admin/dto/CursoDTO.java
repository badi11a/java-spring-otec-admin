package cl.talento.otec.admin.dto;

public class CursoDTO {
    private Integer idCurso;
    private String canal;
    private String codigo;
    private String nombre;
    private String instructor;
    private Integer duracionHoras;
    private String categoria;
    private Boolean activo;

    public CursoDTO() {
    }

    public CursoDTO(Integer idCurso, String canal, String codigo, String nombre, String instructor, Integer duracionHoras, String categoria, Boolean activo) {
        this.idCurso = idCurso;
        this.canal = canal;
        this.codigo = codigo;
        this.nombre = nombre;
        this.instructor = instructor;
        this.duracionHoras = duracionHoras;
        this.categoria = categoria;
        this.activo = activo;
    }

    public Integer getIdCurso() { return idCurso; }
    public void setIdCurso(Integer idCurso) { this.idCurso = idCurso; }

    public String getCanal() { return canal; }
    public void setCanal(String canal) { this.canal = canal; }

    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) { this.codigo = codigo; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getInstructor() { return instructor; }
    public void setInstructor(String instructor) { this.instructor = instructor; }

    public Integer getDuracionHoras() { return duracionHoras; }
    public void setDuracionHoras(Integer duracionHoras) { this.duracionHoras = duracionHoras; }

    public String getCategoria() { return categoria; }
    public void setCategoria(String categoria) { this.categoria = categoria; }

    public Boolean getActivo() { return activo; }
    public void setActivo(Boolean activo) { this.activo = activo; }
}
